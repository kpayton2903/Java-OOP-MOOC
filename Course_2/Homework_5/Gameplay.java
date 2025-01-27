
import java.util.Arrays;




public class Gameplay {
    public static void main(String[] args) {
        BlueAstronaut Bob = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut Heath = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut Albert = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut Angel = new BlueAstronaut("Angel", 0, 1, 0);
        RedAstronaut Liam = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut SuspiciousPerson = new RedAstronaut("Suspicious Person", 100, "expert");

        Player[] playerarray = SuspiciousPerson.getPlayers();
        Arrays.sort(playerarray);

        Liam.sabotage(Bob);
        System.out.println(Bob);
        Liam.freeze(SuspiciousPerson);
        System.out.println(SuspiciousPerson);
        Liam.freeze(Albert);
        System.out.println(Albert);
        System.out.println(Liam);
        Albert.emergencyMeeting();
        SuspiciousPerson.emergencyMeeting();
        System.out.println(Arrays.toString((playerarray)));
        Bob.emergencyMeeting();
        System.out.println(Bob);
        Heath.completeTask();
        System.out.println(Heath);
        Heath.completeTask();
        System.out.println(Heath);
        Heath.completeTask();
        System.out.println(Heath);
        Liam.freeze(Angel);
        System.out.println(Angel);
        System.out.println(Liam);
        Liam.sabotage(Bob);
        System.out.println(Bob);
        Liam.sabotage(Bob);
        System.out.println(Bob);
        Liam.freeze(Bob);
        System.out.println(Bob);
        System.out.println(Heath);
        Liam.sabotage(Heath);
        System.out.println(Heath);
        Liam.sabotage(Heath);
        System.out.println(Heath);
        Liam.sabotage(Heath);
        System.out.println(Heath);
        Liam.sabotage(Heath);
        System.out.println(Heath);
        Liam.sabotage(Heath);
        System.out.println(Heath);
        Liam.freeze(Heath);
    }
}

