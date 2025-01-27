import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
    private String skill;

    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);

        this.skill = skill;
    }

    public RedAstronaut(String name) {
        this(name, 15, "experienced");
    }

    @Override
    public void emergencyMeeting() {
        if (!this.isFrozen()) {
            Player[] playerArray = RedAstronaut.getPlayers();
            Arrays.sort(playerArray);
            int length = playerArray.length;

            for (int i = length-1; i >= 0; i--){
                if (playerArray[i].isFrozen())
                    continue;

                else {
                    if (playerArray[i] == this) {
                        if (playerArray[i - 1].getSusLevel() != playerArray[i - 2].getSusLevel()) {
                            playerArray[i - 1].setFrozen(true);
                        }
                    }
        
                    else if (playerArray[i] != this) {
                        if (playerArray[i].getSusLevel() != playerArray[i - 1].getSusLevel()) {
                            playerArray[i].setFrozen(true);
                        }
                    }
                }
                break;
            }
            
            this.gameOver();
        }
    }

    @Override
    public void freeze(Player p) {
        if (!(p instanceof Impostor) && !p.isFrozen()){
            if (this.getSusLevel() < p.getSusLevel()) {
                p.setFrozen(true);
            }
            else {
                this.setSusLevel(this.getSusLevel() * 2);
            }
        }

        this.gameOver();
    }

    @Override
    public void sabotage(Player p) {
        if (!(p instanceof Impostor) && !this.isFrozen() && !p.isFrozen()) {
            if (this.getSusLevel() < 20) {
                int newSus = (int) Math.floor(p.getSusLevel() * 1.5);
                p.setSusLevel(newSus);
            }
            else {
                int newSus = (int) Math.floor(p.getSusLevel() * 1.25);
                p.setSusLevel(newSus);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof RedAstronaut) {
            RedAstronaut player = (RedAstronaut) o;
            return super.equals(player) && this.skill.equals(player.skill);
        }
        return false;
    }

    @Override
    public String toString() {
        String fullString = super.toString() + " I am an " + this.skill + " player!";
        if (this.getSusLevel() > 15)
            fullString = fullString.toUpperCase();
            
        return fullString;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getSkill() {
        return this.skill;
    }
}
