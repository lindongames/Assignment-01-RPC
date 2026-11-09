import java.util.Scanner;

public class rpc {
    static final Scanner in = new Scanner(System.in);

    // Keeps asking until the player enters R, P, or S.
    static char getMove(String player) {
        while (true) {
            System.out.print("Player " + player + ", enter your move (R, P, S): ");
            String line = in.nextLine().trim();

            if (line.length() == 1) {
                char move = Character.toUpperCase(line.charAt(0));

                if (move == 'R' || move == 'P' || move == 'S') {
                    return move;
                }
            }

            System.out.println("Invalid move. Please enter R, P, or S.");
        }
    }

    static void showResult(char a, char b) {
        System.out.println();

        if (a == b) {
            System.out.println(a + " vs " + b + " it's a Tie!");
        } else if (
                (a == 'R' && b == 'S') ||
                        (a == 'P' && b == 'R') ||
                        (a == 'S' && b == 'P')
        ) {
            System.out.println("Player A wins!");
        } else {
            System.out.println("Player B wins!");
        }

        System.out.println();
    }

    static boolean playAgain() {
        while (true) {
            System.out.print("Play again? [Y/N]: ");
            String answer = in.nextLine().trim();

            if (answer.equalsIgnoreCase("Y")) {
                return true;
            } else if (answer.equalsIgnoreCase("N")) {
                return false;
            }

            System.out.println("Invalid choice. Please enter Y or N.");
        }
    }

    public static void main(String[] args) {
        boolean again = true;

        while (again) {
            char moveA = getMove("A");
            char moveB = getMove("B");

            showResult(moveA, moveB);
            again = playAgain();

            if (again) {
                System.out.println();
            }
        }

        System.out.println("Thanks for playing!");
        in.close();
    }
}