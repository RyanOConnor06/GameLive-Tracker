import java.util.ArrayList;

public class Player {

    // Instance Variables
    private ArrayList<PlateAppearance> plateAppearances;
    private String name;

    // Constructors
    public Player() {
        plateAppearances = new ArrayList<>();
        name = "";
    }

    public Player(String name) {
        plateAppearances = new ArrayList<>();
        this.name = name;
    }

    // Getters
    public ArrayList<PlateAppearance> getPlateAppearances() {
        return plateAppearances;
    }

    public String getName() {
        return name;
    }

    // Other Methods

    /*
    addPLateAppearance()
    Using a String argument, convert it to
    a PlateAppearance,and add it to the plateAppearances HashMap
    */
    public void addPlateAppearance(String sequence) {
        PlateAppearance pa = new PlateAppearance();
        plateAppearances.add(pa.readAtBat(sequence));
    }



}
