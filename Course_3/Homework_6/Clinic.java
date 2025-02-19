import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Clinic {
    private File patientFile;
    private int day;

    public Clinic(File file) {
        this.patientFile = file;
        this.day = 1;
    }

    public Clinic(String fileName) {
        this(new File(fileName));
    }

    public String nextDay(File f) throws FileNotFoundException, InvalidPetException {
        Scanner fileReader = null;
        
        fileReader = new Scanner(f);
        Scanner input = new Scanner(System.in);
        double inputHealth = 0.0;
        int inputPainLevel = 0;
        String exitTime = "";
        String patientInfo = "";
        String[] apptInfo;
        String line;
        String name;
        String typeOfPet;
        String petMetric;
        int entryTime;
        boolean isValid;
        int timeTaken;
        
        while (fileReader.hasNextLine()) {
            line = fileReader.nextLine();
            apptInfo = line.split(",");

            name = apptInfo[0];
            typeOfPet = apptInfo[1];
            petMetric = apptInfo[2];
            entryTime = Integer.parseInt(apptInfo[3]);
            isValid = false;

            if (!typeOfPet.equals("Cat") && !typeOfPet.equals("Dog")) {
                throw new InvalidPetException();
            }

            System.out.printf("Consultation for %s the %s at %d.\nWhat is the health of %s?\n",
            name, typeOfPet, entryTime, name);

            while (!isValid) {
                if (input.hasNextDouble()) {
                    inputHealth = input.nextDouble();
                    isValid = true;
                }
                else {
                    input.nextLine();
                    System.out.println("Please enter a number");
                    System.out.printf("What is the health of %s?\n", name);
                }
            }
            input.nextLine();

            isValid = false;
            while (!isValid) {
                System.out.printf("On a scale of 1 to 10, how much pain is %s in right now?\n", name);
                if (input.hasNextInt()) {
                    inputPainLevel = input.nextInt();
                    isValid = true;
                }
                else {
                    input.nextLine();
                    System.out.println("Please enter a number");
                }
            }
            input.nextLine();

            if (typeOfPet.equals("Cat")) {
                Cat catPatient = new Cat(name, inputHealth, inputPainLevel, Integer.parseInt(petMetric));
                catPatient.speak();
                timeTaken = catPatient.treat();
                exitTime = addTime(String.format("%d", entryTime), timeTaken);
            }
            else {
                Dog dogPatient = new Dog(name, inputHealth, inputPainLevel, Double.parseDouble(petMetric));
                dogPatient.speak();
                timeTaken = dogPatient.treat();
                exitTime = addTime(String.format("%d", entryTime), timeTaken);
            }

            patientInfo += String.format("%s,%s,%s,Day %d,%d,%s,%f,%d\n",
            name, typeOfPet, petMetric, day, entryTime, exitTime, inputHealth, inputPainLevel);
        }

        day++;

        if (fileReader != null) {
            fileReader.close();
        }
        input.close();

        return patientInfo.trim();
    }

    public String nextDay(String fileName) throws FileNotFoundException, InvalidPetException {
        return nextDay(new File(fileName));
    }

    public boolean addToFile(String patientInfo) {
        String[] appointmentInfo = patientInfo.split(",");
        String name = appointmentInfo[0];
        String addInfo = "";
        int fileLength = 0;
        String[] fullFile = new String[100];
        boolean found = false;
        PrintWriter fileExport = null;
        Scanner fileReader = null;
        int existingIndex = 0;

        for (int i=3; i<appointmentInfo.length; i++) {
            addInfo += "," + appointmentInfo[i];
        }

        try {
            fileReader = new Scanner(patientFile);

            while (fileReader.hasNextLine()) {
                fullFile[fileLength] = fileReader.nextLine();

                if (name.equals(fullFile[fileLength].split(",")[0])) {
                    existingIndex = fileLength;
                    found = true;
                }

                fileLength++;
            }

            if (fileReader != null) {
                fileReader.close();
            }

            fileExport = new PrintWriter(patientFile);

            if (found == true) {
                fullFile[existingIndex] += addInfo;
            }
            else {
                fullFile[fileLength] = patientInfo;
            }

            for (int i=0; i<fileLength + 1; i++) {
                System.out.println(i);
                fileExport.println(fullFile[i]);
            }
            
            return true;
        }
        catch (FileNotFoundException fnfe) {
            return false;
        }
        finally {
            if (fileExport != null) { 
                fileExport.close();
            }
        }
    }

    private String addTime(String timeIn, int treatmentTime) {
        int intTimeIn = Integer.parseInt(timeIn);

        int minutes = intTimeIn % 100;
        intTimeIn -= minutes;
        minutes += treatmentTime;
        int hours = (int) minutes / 60;
        minutes -= hours*60;
        String totalTime = "" + (intTimeIn + minutes + hours*100);

        return totalTime;
    }
}