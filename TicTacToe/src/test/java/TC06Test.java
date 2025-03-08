import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.SwingUtilities;

public class TC06Test {

    private void simulateMove(TicTacToe game, int row, int col) {
        try {
            SwingUtilities.invokeAndWait(() -> game.simulateMove(row, col)); // Ensure move runs on EDT
            Thread.sleep(100); // Small delay for UI to process
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printBoard(TicTacToe game) {
        System.out.println("Board State:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(game.buttons[i][j].getText() + " ");
            }
            System.out.println();
        }
    }

    @Test
    void testPlayerAlternatesAfterEachMove() {
        TicTacToe game = new TicTacToe('X');

        simulateMove(game, 0, 0); // X moves
        assertEquals('O', game.getCurrentPlayer(), "After X moves, it should be O's turn");

        simulateMove(game, 0, 1); // O moves
        assertEquals('X', game.getCurrentPlayer(), "After O moves, it should be X's turn");

        simulateMove(game, 0, 2); // X moves
        assertEquals('O', game.getCurrentPlayer(), "After X moves, it should be O's turn");

        printBoard(game); // Debug board state for GitHub Actions
    }

    @Test
    void testTurnDoesNotChangeIfMoveIsInvalid() {
        TicTacToe game = new TicTacToe('X');

        simulateMove(game, 1, 1); // X moves
        assertEquals('O', game.getCurrentPlayer(), "After X moves, it should be O's turn");

        simulateMove(game, 1, 1); // O tries to overwrite the same cell
        assertEquals('O', game.getCurrentPlayer(), "Turn should not change if move is invalid");

        simulateMove(game, 2, 2); // O makes a valid move
        assertEquals('X', game.getCurrentPlayer(), "After O moves, it should be X's turn");

        printBoard(game); // Debug board state for GitHub Actions
    }

    @Test
    void testTurnDoesNotChangeAfterWin() {
        TicTacToe game = new TicTacToe('X');

        simulateMove(game, 0, 0); // X
        simulateMove(game, 1, 1); // O
        simulateMove(game, 0, 1); // X
        simulateMove(game, 2, 2); // O
        simulateMove(game, 0, 2); // X wins

        assertTrue(game.checkWinner(), "X should have won the game");

        char winner = game.getCurrentPlayer();

        simulateMove(game, 2, 0); // O tries to move after X wins
        assertEquals(winner, game.getCurrentPlayer(), "Turn should not change after a win");

        printBoard(game); // Debug board state for GitHub Actions
    }
}