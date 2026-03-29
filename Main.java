/*
 * GameLive Tracker
 * Copyright (c) 2026 Ryan Patrick O'Connor. All rights reserved.
 *
 * Licensed for non-commercial use only, with required attribution.
 * See LICENSE.md for full terms.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Create Game object
        Game game = new Game();

        // Create variable to dictate while loop
        String morePlayers = "y";

        // Loop while there are still more players to add
        while (morePlayers.equals("y")) {

            // Format input for entering text strings
            System.out.print("Enter player name: ");
            String name = input.nextLine();
            Player player = new Player(name);

            // Loop through player's plate appearances while more to add
            while (true) {
                System.out.println("\nEnter the plate appearance sequence (or enter 'e' to exit): ");
                String sequence = input.nextLine();

                if (sequence.equals("e")) {
                    break;
                }
                else {
                    player.addPlateAppearance(sequence);
                }
            }
            // Add player to final game sheet for outputting
            game.addPlayerToSheet(player);

            // Check if there are still more players to add
            System.out.print("More hitters? (y or n) ");
            morePlayers = input.nextLine();
        }
        // Print final stats
        game.printFinalSheet();
    }
}
