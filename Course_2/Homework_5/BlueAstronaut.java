import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {
    private int numTasks;
    private int taskSpeed;

    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    public BlueAstronaut(String name) {
        this(name, 15, 6, 10);
    }

    @Override
    public void emergencyMeeting() {
        if (!this.isFrozen()) {
            Player[] playerArray = BlueAstronaut.getPlayers();
            Arrays.sort(playerArray);
            int length = playerArray.length;

            if (playerArray[length - 1].getSusLevel() != playerArray[length - 2].getSusLevel()) {
                playerArray[length - 1].setFrozen(true);
            }
        }

        this.gameOver();
    }

    @Override
    public void completeTask() {
        if (!this.isFrozen() && this.numTasks != 0) {
            if (taskSpeed > 20) {
                this.numTasks = this.numTasks - 2;
            }
            else
                this.numTasks--;

            if (numTasks <= 0) {
                if (numTasks < 0)
                    this.numTasks = 0;
                System.out.println("I have completed all my tasks");
                int newSus = (int) Math.floor(this.getSusLevel() * 0.5);
                this.setSusLevel(newSus);
            }
        }   
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof BlueAstronaut) {
            BlueAstronaut player = (BlueAstronaut) o;
            return super.equals(player) && this.numTasks == player.numTasks && this.taskSpeed == player.taskSpeed;
        }
        return false;
    }

    @Override
    public String toString() {
        String fullString = super.toString() + "I have " + this.numTasks + " left over.";

        if (this.getSusLevel() > 15)
            fullString = fullString.toUpperCase();
            
        return fullString;
    }

    public void setNumTasks(int numTasks) {
        if (numTasks < 0) {
            numTasks = 0;
        }

        this.numTasks = numTasks;
    }

    public int getNumTasks() {
        return this.numTasks;
    }

    public void setTaskSpeed(int taskSpeed) {
        if (taskSpeed < 0) {
            taskSpeed = 0;
        }

        this.taskSpeed = taskSpeed;
    }

    public int getTaskSpeed() {
        return this.taskSpeed;
    }
}