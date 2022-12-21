import java.io.*;
import java.util.*;

/**
 * A class that generates a 2-D char array representing an 'X'
 *
 * <p>Purdue University -- CS18000 -- Spring 2022</p>
 *
 * @author Purdue CS
 * @version January 10, 2022
 */

public class PlayGame {
    public static void main(String[] args) {
        int player1 = 1;
        int player2 = 2;
        String[] p1 = new String[11];
        String[] p2 = new String[11];
        Scanner scanner = new Scanner(System.in);

        try {
            File f1 = new File("ShipPositionsPlayerOne.txt");
            File f2 = new File("ShipPositionsPlayerTwo.txt");
            File f3 = new File("GameLog.txt");
            FileReader r1 = new FileReader(f1);
            BufferedReader br1 = new BufferedReader(r1);
            String line1 = br1.readLine();
            int i = 1;
            p1[0] = line1;
            while (line1 != null) {
                line1 = br1.readLine();
                p1[i++] = line1;
            }
            br1.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not Found!");
        } catch (IOException e) {
            System.out.println("File not Found!");
        }

        try {
            File f2 = new File("ShipPositionsPlayerTwo.txt");
            FileReader r2 = new FileReader(f2);
            BufferedReader br2 = new BufferedReader(r2);
            String line2 = br2.readLine();
            int i = 1;
            p2[0] = line2;
            while (line2 != null) {
                line2 = br2.readLine();
                p2[i++] = line2;
            }
            br2.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not Found!");
        } catch (IOException e) {
            System.out.println("File not Found!");
        }

        System.out.println("Hello, Welcome to Battleship!\nPlease enter a Game mode:\n" +
                "1. Automated\n" +
                "2. Active");
        int option = scanner.nextInt();
        scanner.nextLine();
        if (option == 1) {
            char guessC1;
            char guessC2;
            int guessN1;
            int guessN2;
            int guess1;
            System.out.println("Enter the filename with the game data:");
            String file = scanner.nextLine();
            int p1guess = 0;
            int p1hits = 0;
            int p2guess = 0;
            int p2hits = 0;
            int p1top = 0;
            int p1middle = 0;
            int p1bottom = 0;
            int p2top = 0;
            int p2middle = 0;
            int p2bottom = 0;
            String p1type = "";
            String p2type = "";
            int numTurns = 0;
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line2 = br.readLine();

                for (int y = 0; y < 14; y++) {
                    if (p2[0].charAt(y) == 'H') {
                        p2top++;
                    }
                    if (p2[1].charAt(y) == 'H') {
                        p2top++;
                    }
                    if (p2[2].charAt(y) == 'H') {
                        p2top++;
                    }
                }

                for (int y = 0; y < 14; y++) {
                    if (p2[7].charAt(y) == 'H') {
                        p2bottom++;
                    }
                    if (p2[8].charAt(y) == 'H') {
                        p2bottom++;
                    }
                    if (p2[9].charAt(y) == 'H') {
                        p2bottom++;
                    }
                }

                for (int y = 0; y < 14; y++) {
                    if (p2[3].charAt(y) == 'H') {
                        p2middle++;
                    }
                    if (p2[4].charAt(y) == 'H') {
                        p2middle++;
                    }
                    if (p2[5].charAt(y) == 'H') {
                        p2middle++;
                    }
                    if (p2[6].charAt(y) == 'H') {
                        p2middle++;
                    }
                }

                for (int y = 0; y < 14; y++) {
                    if (p1[0].charAt(y) == 'H') {
                        p1top++;
                    }
                    if (p1[1].charAt(y) == 'H') {
                        p1top++;
                    }
                    if (p1[2].charAt(y) == 'H') {
                        p1top++;
                    }
                }

                for (int y = 0; y < 14; y++) {
                    if (p1[3].charAt(y) == 'H') {
                        p1middle++;
                    }
                    if (p1[4].charAt(y) == 'H') {
                        p1middle++;
                    }
                    if (p1[5].charAt(y) == 'H') {
                        p1middle++;
                    }
                    if (p1[6].charAt(y) == 'H') {
                        p1middle++;
                    }
                }

                for (int y = 0; y < 14; y++) {
                    if (p1[7].charAt(y) == 'H') {
                        p1bottom++;
                    }
                    if (p1[8].charAt(y) == 'H') {
                        p1bottom++;
                    }
                    if (p1[9].charAt(y) == 'H') {
                        p1bottom++;
                    }
                }

                while (line2 != null) {
                    guessC1 = line2.charAt(0);
                    line2 = br.readLine();
                    guess1 = Integer.parseInt(line2);
                    guessN1 = guess1;
                    line2 = br.readLine();
                    guessC2 = line2.charAt(0);
                    line2 = br.readLine();
                    guessN2 = Integer.parseInt(line2);
                    line2 = br.readLine();
                    numTurns++;
                    if (p2[guessC1 - 65].charAt(guessN1 - 1) == 'H') {
                        p1guess++;
                        p1hits++;

                        p2[guessC1 - 65] = p2[guessC1 - 65].substring(0, guessN1 - 1) + "M" +
                                p2[guessC1 - 65].substring(guessN1);
                    }
                    if (p1[guessC2 - 65].charAt(guessN2 - 1) == 'H') {
                        p2guess++;
                        p2hits++;
                        p1[guessC2 - 65] = p1[guessC2 - 65].substring(0, guessN2 - 1) + "M" +
                                p1[guessC2 - 65].substring(guessN2);
                    }
                }
                br.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            } catch (IOException e) {
                System.out.println("File not found!");
            }

            if (p1bottom >= 9) {
                p1type = "Bottom Heavy";
            } else if (p1top >= 9) {
                p1type = "Top Heavy";
            } else if (p1middle >= 9) {
                p1type = "Middle Heavy";
            } else {
                p1type = "Scattered";
            }

            if (p2bottom >= 9) {
                p2type = "Bottom Heavy";
            } else if (p2top >= 9) {
                p2type = "Top Heavy";
            } else if (p2middle >= 9) {
                p2type = "Middle Heavy";
            } else {
                p2type = "Scattered";
            }

            try {
                if (p1hits == 17) {
                    BufferedWriter br = new BufferedWriter(new FileWriter("GameLog.txt"));
                    System.out.println("Enemy fleet destroyed. Congratulations player 1!");
                    GameLog gameLog = new GameLog(player1, p2hits, numTurns, p1type, p2type);
                    br.write(gameLog.toString());
                    br.close();

                } else if (p2hits == 17) {
                    BufferedWriter br = new BufferedWriter(new FileWriter("GameLog.txt"));
                    System.out.println("Enemy fleet destroyed. Congratulations player 2!");
                    GameLog gameLog = new GameLog(player2, p1hits, numTurns, p1type, p2type);
                    br.write(gameLog.toString());
                    br.close();
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not Found!");
            } catch (IOException e) {
                System.out.println("File not Found!");
            }
        }

        if (option == 2) {
            char guessC1;
            char guessC2;
            int guessN1;
            int guessN2;
            int p1guess = 0;
            int p1hits = 0;
            int p2guess = 0;
            int p2hits = 0;
            int p1top = 0;
            int p1middle = 0;
            int p1bottom = 0;
            int p2top = 0;
            int p2middle = 0;
            int p2bottom = 0;
            String p1type = "";
            String p2type = "";
            int numTurns = 0;

            for (int y = 0; y < 14; y++) {
                if (p2[0].charAt(y) == 'H') {
                    p2top++;
                }
                if (p2[1].charAt(y) == 'H') {
                    p2top++;
                }
                if (p2[2].charAt(y) == 'H') {
                    p2top++;
                }
            }
            for (int y = 0; y < 14; y++) {
                if (p2[7].charAt(y) == 'H') {
                    p2bottom++;
                }
                if (p2[8].charAt(y) == 'H') {
                    p2bottom++;
                }
                if (p2[9].charAt(y) == 'H') {
                    p2bottom++;
                }
            }

            for (int y = 0; y < 14; y++) {
                if (p2[3].charAt(y) == 'H') {
                    p2middle++;
                }
                if (p2[4].charAt(y) == 'H') {
                    p2middle++;
                }
                if (p2[5].charAt(y) == 'H') {
                    p2middle++;
                }
                if (p2[6].charAt(y) == 'H') {
                    p2middle++;
                }
            }

            for (int y = 0; y < 14; y++) {
                if (p1[0].charAt(y) == 'H') {
                    p1top++;
                }
                if (p1[1].charAt(y) == 'H') {
                    p1top++;
                }
                if (p1[2].charAt(y) == 'H') {
                    p1top++;
                }
            }

            for (int y = 0; y < 14; y++) {
                if (p1[7].charAt(y) == 'H') {
                    p1bottom++;
                }
                if (p1[8].charAt(y) == 'H') {
                    p1bottom++;
                }
                if (p1[9].charAt(y) == 'H') {
                    p1bottom++;
                }
            }

            for (int y = 0; y < 14; y++) {
                if (p1[3].charAt(y) == 'H') {
                    p1middle++;
                }
                if (p1[4].charAt(y) == 'H') {
                    p1middle++;
                }
                if (p1[5].charAt(y) == 'H') {
                    p1middle++;
                }
                if (p1[6].charAt(y) == 'H') {
                    p1middle++;
                }
            }

            while (p1hits < 17 && p2hits < 17) {
                System.out.println("Player 1 - Enter a row letter from A - J");
                guessC1 = scanner.next().charAt(0);
                System.out.println("Player 1 - Enter a column number from 1 - 14");
                guessN1 = scanner.nextInt();
                scanner.nextLine();

                if (p2[guessC1 - 65].charAt(guessN1 - 1) == 'H') {
                    p1guess++;
                    p1hits++;
                    p2[guessC1 - 65] = p2[guessC1 - 65].substring(0, guessN1 - 1) + "M" +
                            p2[guessC1 - 65].substring(guessN1);
                }

                numTurns++;

                System.out.println("Value:" + p2[guessC1 - 65].charAt(guessN1 - 1));
                if (p1hits >= 17) {
                    break;
                }

                System.out.println("Player 2 - Enter a row letter from A - J");
                guessC2 = scanner.next().charAt(0);
                System.out.println("Player 2 - Enter a column number from 1 - 14");
                guessN2 = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Value:" + p1[guessC2 - 65].charAt(guessN2 - 1));

                if (p1[guessC2 - 65].charAt(guessN2 - 1) == 'H') {
                    p2guess++;
                    p2hits++;
                    p1[guessC2 - 65] = p1[guessC2 - 65].substring(0, guessN2 - 1) + "M" +
                            p1[guessC2 - 65].substring(guessN2);
                }
            }

            if (p1bottom >= 9) {
                p1type = "Bottom Heavy";
            } else if (p1top >= 9) {
                p1type = "Top Heavy";
            } else if (p1middle >= 9) {
                p1type = "Middle Heavy";
            } else {
                p1type = "Scattered";
            }

            if (p2bottom >= 9) {
                p2type = "Bottom Heavy";
            } else if (p2top >= 9) {
                p2type = "Top Heavy";
            } else if (p2middle >= 9) {
                p2type = "Middle Heavy";
            } else {
                p2type = "Scattered";
            }

            try {
                if (p1hits == 17) {
                    File f = new File("GameLog.txt");
                    BufferedWriter br = new BufferedWriter(new FileWriter("GameLog.txt"));
                    System.out.println("Enemy fleet destroyed. Congratulations player 1!");
                    GameLog gameLog = new GameLog(player1, p2hits, numTurns, p1type, p2type);
                    br.write(gameLog.toString());
                    br.close();

                } else if (p2hits == 17) {
                    BufferedWriter br = new BufferedWriter(new FileWriter("GameLog.txt"));
                    System.out.println("Enemy fleet destroyed. Congratulations player 2!");
                    GameLog gameLog = new GameLog(player2, p1hits, numTurns, p1type, p2type);
                    br.write(gameLog.toString());
                    br.close();
                }

            } catch (FileNotFoundException e) {
                System.out.println("File not Found!");
            } catch (IOException e) {
                System.out.println("File not Found!");
            }
        }
    }
}