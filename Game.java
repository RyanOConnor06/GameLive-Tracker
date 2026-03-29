/*
 * GameLive Tracker
 * Copyright (c) 2026 Ryan Patrick O'Connor. All rights reserved.
 *
 * Licensed for non-commercial use only, with required attribution.
 * See LICENSE.md for full terms.
 */

import java.util.ArrayList;
import java.util.HashMap;

public class Game {

    // Instance Variable
    private HashMap<String, ArrayList<PlateAppearance>> finalSheet;

    // Default Constructor
    public Game() {
        finalSheet = new HashMap<>();
    }

    // Getter
    public HashMap<String, ArrayList<PlateAppearance>> getFinalSheet() {
        return finalSheet;
    }

    /*
    addPlayerToSheet()
    Adds a Player object to finalSheet
     */
    public void addPlayerToSheet(Player player) {
        finalSheet.put(player.getName(), player.getPlateAppearances());
    }

    /*
    printFinalSheet()
    Prints formatted finalSheet
     */
    public void printFinalSheet() {
        for (String player : finalSheet.keySet()) {
            System.out.println(player + ":");

            // Access player's plate appearances from that game
            ArrayList<PlateAppearance> pas = finalSheet.get(player);

            // Initialize counter variables
            int ahead = 0;
            int behind = 0;
            int early = 0;
            int whiffs = 0;
            ArrayList<Integer> pitches = new ArrayList<>();

            // Update counters for each
            for (PlateAppearance pa : pas) {
                String count = pa.getCountControlled();
                if (count.equals("Ahead")) {
                    ahead++;
                }
                else if (count.equals("Behind")) {
                    behind++;
                }
                else {
                    early++;
                }
                whiffs += pa.getWhiffs();
                pitches.add(pa.getBalls() + pa.getStrikes() + 1);
            }
            // Print tracked stats by player
            System.out.printf("PA: %d\tAhead: %d\tBehind: %d\tEarly: %d\nWhiffs: %d", pitches.size(), ahead, behind, early, whiffs);
            System.out.print("\nPA lengths: ");
            // Loop through pitches ArrayList to print out lengths
            for (Integer pitch : pitches) {
                System.out.print(pitch + " ");
            }
            System.out.println("\n");
        }
    }

}
