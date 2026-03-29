public class PlateAppearance {

    // Instance Variables
    private int balls;
    private int strikes;
    private int whiffs;
    private int countControlled;

    // Constructors
    public PlateAppearance() {
        balls = 0;
        strikes = 0;
        whiffs = 0;
        countControlled = 0;
    }

    public PlateAppearance(int balls, int strikes, int whiffs, int countControlled) {
        this.balls = balls;
        this.strikes = strikes;
        this.whiffs = whiffs;
        this.countControlled = countControlled;
    }

    // Getters
    public int getBalls() {
        return balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getWhiffs() {
        return whiffs;
    }

    public String getCountControlled() {
        String count = "";
        if (countControlled == 0) {
            count = "Early";
        }
        else if (countControlled == 1) {
            count = "Behind";
        }
        else if (countControlled == 2) {
            count = "Ahead";
        }
        return count;
    }

   // Class Methods
    public PlateAppearance readAtBat(String event) {
       String[] events = event.split(", ");
       for (String pitch : events) {
           // Categorize pitch events
           if (pitch.equals("Ball") || pitch.contains("Walk")) {
               balls++;
           }
           else if (pitch.contains("Strike") || pitch.equals("Foul")) {
               strikes++;
           }
           if (pitch.equals("Swinging Strike") || pitch.contains("strike out swinging") || pitch.contains("KS")) {
               whiffs++;
           }

           // Check if ahead or behind
           if (countControlled == 0) {
               if (balls == 2) {
                   countControlled = 2;
               }
               if (strikes == 2) {
                   countControlled = 1;
               }
           }
       }
       // Return PlateAppearance object
       return new PlateAppearance(balls, strikes, whiffs, countControlled);
    }

}
