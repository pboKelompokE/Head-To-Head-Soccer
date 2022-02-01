import java.util.*;
public class Headsoccer {
                public static int Kakikiri = 10;
                public static int Kakikanan = 10;
                public static int player;
                public static int computer;
                public static String[][] grid = new String[Kakikiri][Kakikanan];
                public static int[][] missedGuesses = new int[Kakikiri][Kakikanan];

                public static void main(String[] args) {
                    System.out.println("** Selamat datang di game Head to Head Soccer **");
                    System.out.println("Kerahkan Tendangan terbaik mu\n");

                    //Step 1 – Create the map
                    createlapanganMap();

                    //Step 2 – Deploy player’s
                    deployPlayer();

                    //Step 3 - Deploy computer's
                    deployComputer();

                    //Step 4 Battle
                    do {
                        Battle();
                    } while (Headsoccer.player != 0 && Headsoccer.computer != 0);

                    //Step 5 - Game over
                    gameOver();
                }

                public static void createlapanganMap() {
                    //First section of Map
                    System.out.print("  ");
                    for (int i = 0; i < Kakikanan; i++)
                        System.out.print(i);
                    System.out.println();

                    //Middle section of Ocean Map
                    for (int i = 0; i < grid.length; i++) {
                        for (int j = 0; j < grid[i].length; j++) {
                            grid[i][j] = " ";
                            if (j == 0)
                                System.out.print(i + "|" + grid[i][j]);
                            else if (j == grid[i].length - 1)
                                System.out.print(grid[i][j] + "|" + i);
                            else
                                System.out.print(grid[i][j]);
                        }
                        System.out.println();
                    }

                    //Last section of Map
                    System.out.print("  ");
                    for (int i = 0; i < Kakikanan; i++)
                        System.out.print(i);
                    System.out.println();
                }

                public static void deployPlayer() {
                    Scanner input = new Scanner(System.in);

                    System.out.println("\nTentukan titik mu:");
                    //Tentukan 5 titik kordinat
                    Headsoccer.player = 3;
                    for (int i = 1; i <= Headsoccer.player; ) {
                        System.out.print("Masukkan kordinat x " + i + " Gawang: ");
                        int x = input.nextInt();
                        System.out.print("Masukkan kordinat y " + i + " Gawang: ");
                        int y = input.nextInt();

                        if ((x >= 0 && x < Kakikiri) && (y >= 0 && y < Kakikanan) && (grid[x][y] == " ")) {
                            grid[x][y] = "@";
                            i++;
                        } else if ((x >= 0 && x < Kakikiri) && (y >= 0 && y < Kakikanan) && grid[x][y] == "@")
                            System.out.println("Anda tidak boleh menempatkan kordinat di tempat yang sama");
                        else if ((x < 0 || x >= Kakikiri) || (y < 0 || y >= Kakikanan))
                            System.out.println("Anda tidak dapat menempatkan kordinat di luar jangkauan " + Kakikiri + " by " + Kakikanan + " grid");
                    }

                }

                public static void deployComputer() {
                    System.out.println("\nComputer menentukan titik");
                    //Temukan 5 titik kordinat dari komputer
                    Headsoccer.computer = 3;
                    for (int i = 1; i <= Headsoccer.computer; ) {
                        int x = (int) (Math.random() * 10);
                        int y = (int) (Math.random() * 10);

                        if ((x >= 0 && x < Kakikiri) && (y >= 0 && y < Kakikanan) && (grid[x][y] == " ")) {
                            grid[x][y] = "x";
                            System.out.println(i + ". kordinat telah ditentukan");
                            i++;
                        }
                    }

                }

                public static void Battle() {
                    playerTurn();
                    computerTurn();


                    System.out.println();
                    System.out.println("Your : " + Headsoccer.player + " | Computer : " + Headsoccer.computer);
                    System.out.println();
                }

                public static void playerTurn() {
                    System.out.println("\nGILIRANMU");
                    int x = -1, y = -1;
                    do {
                        Scanner input = new Scanner(System.in);
                        System.out.print("TENDANGAN KAKI KIRI: ");
                        x = input.nextInt();
                        System.out.print("TENDANGAN KAKI KANAN: ");
                        y = input.nextInt();

                        if ((x >= 0 && x < Kakikiri) && (y >= 0 && y < Kakikanan)) //valid guess
                        {
                            if (grid[x][y] == "x") //
                            {
                                System.out.println("GOALLLLLLL! ANDA MENCETAK GOAL!");
                                grid[x][y] = "!"; //Hit mark
                                --Headsoccer.computer;
                            } else if (grid[x][y] == "@") {
                                System.out.println("Oh TIDAK!!!!, KAMU MELAKUKAN BLUNDER :(");
                                grid[x][y] = "x";
                                --Headsoccer.player;
                                ++Headsoccer.computer;
                            } else if (grid[x][y] == " ") {
                                System.out.println("SILAHKAN COBA LAGI, SEMANGATLAH!!!!!!!");
                                grid[x][y] = "-";
                            }
                        } else if ((x < 0 || x >= Kakikiri) || (y < 0 || y >= Kakikanan))  //invalid guess
                            System.out.println("ANDA TIDAK DAPAT MENENTUKAN KORDINAT DI LUAR " + Kakikiri + " by " + Kakikanan + " grid");
                    } while ((x < 0 || x >= Kakikiri) || (y < 0 || y >= Kakikanan));  //keep re-prompting till valid guess
                }

                public static void computerTurn() {
                    System.out.println("\nCOMPUTER'S TURN");
                    //Guess co-ordinates
                    int x = -1, y = -1;
                    do {
                        x = (int) (Math.random() * 10);
                        y = (int) (Math.random() * 10);

                        if ((x >= 0 && x < Kakikiri) && (y >= 0 && y < Kakikanan)) //valid guess
                        {
                            if (grid[x][y] == "@") {
                                System.out.println("Computer mendapatkan kordinat anda!");
                                grid[x][y] = "x";
                                --Headsoccer.player;
                                ++Headsoccer.computer;
                            } else if (grid[x][y] == "x") {
                                System.out.println("Computer melakukan BLUNDER");
                                grid[x][y] = "!";
                            } else if (grid[x][y] == " ") {
                                System.out.println("Computer missed");
                                //Saving missed guesses for computer
                                if (missedGuesses[x][y] != 1)
                                    missedGuesses[x][y] = 1;
                            }
                        }
                    } while ((x < 0 || x >= Kakikiri) || (y < 0 || y >= Kakikanan));  //keep re-prompting till valid guess
                }

                public static void gameOver() {
                    System.out.println("Team kamu: " + Headsoccer.player + " | Team komputer: " + Headsoccer.computer);
                    if (Headsoccer.player > 0 && Headsoccer.computer <= 0)
                        System.out.println("Hooray! KAMU MEMENANGKAN PERTANDINGAN  :)");

                    else
                        System.out.println("Sorry, KAMU KALAH DALAM PERTANDINGAN");
                    System.out.println();
                }


            }
        }
    }
}