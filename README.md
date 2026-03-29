# GameLive-Tracker

A multi-class Java command-line tool that parses pitch-by-pitch text sequences from the GameLive platform to extract and summarize baseball plate appearance statistics for one or more hitters in a game.

## What It Does

GameLive-Tracker takes raw pitch sequence strings (as copied from a GameLive feed) and breaks them down into meaningful hitting metrics per player. After entering all plate appearances for each hitter, the program prints a formatted summary sheet for the game.

### Stats Tracked

- **PA** — total plate appearances
- **Ahead / Behind / Early** — count control classification for each PA
  - `Ahead`: batter reached 2 balls before 2 strikes
  - `Behind`: batter reached 2 strikes before 2 balls
  - `Early`: neither threshold was reached (ended early in the count)
- **Whiffs** — total swinging strikes across all PAs
- **PA lengths** — pitch count for each individual plate appearance

## How It Works

The project is structured across four classes:

- `Main.java` — entry point; handles user input loop for players and plate appearance sequences
- `Player.java` — represents a hitter; stores a list of their plate appearances
- `PlateAppearance.java` — parses a raw pitch sequence string and computes balls, strikes, whiffs, and count control
- `Game.java` — aggregates all players and prints the final stat sheet

## Usage

Compile and run from the command line:

```bash
javac *.java
java Main
```

You'll be prompted to enter a player name, then paste in their plate appearance sequences one at a time (comma-separated pitch events). Enter `e` when done with a player, then choose whether to add another hitter.

### Example Input

```
Enter player name: [player_name]

Enter the plate appearance sequence (or enter 'e' to exit):
Ball, Strike, Foul, Swinging Strike, strike out swinging
```

### Example Output

```
[player_name]:
PA: 1   Ahead: 0    Behind: 1   Early: 0
Whiffs: 2
PA lengths: 5
```

## Requirements

- Java 8 or higher
- No external dependencies
