import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A game is played by two players on a 3 by 3 board. The board’s squares are
 * marked in a similar manner to chess. e.g. the square on the bottom left
 * corner is a1 and so on. (You can google for an explanation of chess square
 * notation if this is not very clear.)	Player 1 goes first and marks an X on
 * any square of the board. Also, any square adjacent to the square marked X on
 * his turn are also marked X except for the ones diagonally adjacent e.g. if he
 * marks square b1 with an X, then squares a1, c1 and b2 are all marked with an
 * X. Player 2 marks an O on any square of the board not marked with an X, and
 * the adjacent squares (except for the ones already marked) are marked with an
 * O following the same rules as above. For example, if player 1 marks an X on
 * square b1 on an open board, then, if player 2 marks an O on square a2, then
 * squares a3 and b2 are marked with an O but not square a1 since it has already
 * been marked with X from the previous turn of player 1. The player who fills
 * in the last remaining square(s) wins the game. Write a program that enables
 * two players to play this game.
 *
 * @author Arun Kumar
 */
public class SquareTrouble {

    /**
     * chess board size
     */
    private final int N = 3;
    /**
     * flag to maintain player win and lose status after each move
     */
    boolean win = false, tie = false;

    /**
     * to track total move counts for both players.
     */
    private int playersMoveCount = 0;
    /**
     * Declare chess board size of NxN
     */
    String[][] chessboard = new String[N][N];

    public SquareTrouble() {
        /**
         * Initialize chess board.
         */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                chessboard[i][j] = "-";
            }
        }
        playGame();
    }

    /**
     * check current game status, win or tie.
     *
     * @return
     */
    private boolean isOver() {
        return win || tie;
    }

    /**
     * start playing the game.
     */
    private void playGame() {
        Scanner input = new Scanner(System.in);
        boolean xTurn = true;
        boolean IsValidMove = false;
        /**
         * loop till give is not over or tie.
         */
        while (!isOver()) {
            try {
                if (xTurn) {
                    System.out.println("Player 1, enter the position [1-9] to place X");
                    byte position = input.nextByte();
                    IsValidMove = addMove("X", position);
                } else {
                    System.out.println("Player 2, enter the position [1-9] to place O");
                    byte position = input.nextByte();
                    IsValidMove = addMove("O", position);
                }
                //if last move of a player is valid then allow other player to enter the move.
                if (IsValidMove && !isOver()) {
                    xTurn = !xTurn;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input, please enter only numbers from [1-9]");
                break;

            }

        }
        System.out.println("-------------------------------------------------");
        if (tie) {
            System.out.println("Gave over! result is TIE");
        } else if (xTurn && win) {
            System.out.println("Gave Over!, Player 1 is winner");
        } else if (win) {
            System.out.println("Gave Over!, Player 2 is winner");
        }
        displayResult();
    }

    /**
     * add a move position in chess board, if valid. given position is not
     * already selected by other player.
     *
     * @param x
     * @param position
     * @return
     */
    private boolean addMove(String x, byte position) {
        byte row = (byte) ((position - 1) / 3);
        byte col = (byte) ((position - 1) % 3);
        if (chessboard[row][col].equals("X") || chessboard[row][col].equals("O")) {
            System.out.println("Invalid position, position is already selected by other player, Please try again!");
            return false;
        }
        chessboard[row][col] = x;
        playersMoveCount++;

        updateChessBoard(row, col, x);

        //for user convenience, display the matrix after each move
        displayResult();
        return true;
    }

    /**
     * check for win, loss or tie possibility.
     *
     * @param row
     * @param col
     * @param x
     */
    private void updateChessBoard(byte row, byte col, String x) {

        //first check the win condition for the player.
        int rowCount = 0;
        int colCount = 0;
        for (int i = 0; i < N; i++) {
            if (chessboard[row][i].equals(x)) {
                rowCount++;
            }
            if (chessboard[i][col].equals(x)) {
                colCount++;
            }
        }
        //if count is threee in a row or column for given symbol X then declare win.
        if (rowCount == 3 || colCount == 3) {
            win = true;
            return;
        }
        //check three consecutive occurance of  element X in diagonal
        if (row == col) {
            //check major diagonal 
            if (chessboard[0][0].equals(x) && chessboard[1][1].equals(x) && chessboard[2][2].equals(x)) {
                win = true;
                return;
            }
        } else if ((row == N - 1 && col == 2) || (row == N - 1 && col == 0)) {
            //check minor diagonal
            if (chessboard[0][2].equals(x) && chessboard[1][1].equals(x) && chessboard[2][0].equals(x)) {
                win = true;
                return;
            }
        }

        /**
         * check for tie condition, if win has been not declared in minimal
         * move.
         */
        if (playersMoveCount == 7) {
            tie = true;
        }

    }

    /**
     * display chess board matrix
     */
    private void displayResult() {
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(chessboard[i][j] + "\t");
            }
            System.out.print("\n");
        }

        System.out.println("-------------------------------------------------");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new SquareTrouble();

    }

}
