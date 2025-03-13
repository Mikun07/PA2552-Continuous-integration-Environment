import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;

public class TC07Test {
    private TicTacToe game;

    @BeforeEach
    void setUp() {
        game = new TicTacToe('X'); // Initialize game with player 'X'
        game.testMode = true; // Enable test mode to control turns
    }

    // 🛠 Helper method: Simulate a move safely on the Event Dispatch Thread (EDT)
    private void simulateMove(TicTacToe game, int row, int col) {
        try {
            SwingUtilities.invokeAndWait(() -> game.simulateMove(row, col)); // Ensure move runs on EDT
            Thread.sleep(300); // Give time for event processing (CI/CD race conditions)
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🛠 Helper method: Print board state (for debugging in CI/CD)
    private void printBoard(TicTacToe game) {
        System.out.println("Board State:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(game.buttons[i][j].getText() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Test
    void testPlayerMoves() {
        System.out.println("Starting test: testPlayerMoves");

        // X moves
        simulateMove(game, 0, 0);
        assertEquals("X", game.buttons[0][0].getText(), "Button should display 'X'");
        assertEquals('O', game.getCurrentPlayer(), "Next turn should be 'O'");

        // O moves
        simulateMove(game, 1, 1);
        assertEquals("O", game.buttons[1][1].getText(), "Button should display 'O'");
        assertEquals('X', game.getCurrentPlayer(), "Turn should switch back to 'X'");

        printBoard(game); // Debug board state for GitHub Actions
    }

    @Test
    void testPlayerAlternatesAfterEachMove() {
        System.out.println("Starting test: testPlayerAlternatesAfterEachMove");

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
        System.out.println("Starting test: testTurnDoesNotChangeIfMoveIsInvalid");

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
        System.out.println("Starting test: testTurnDoesNotChangeAfterWin");

        simulateMove(game, 0, 0); // X
        simulateMove(game, 1, 1); // O
        simulateMove(game, 0, 1); // X
        simulateMove(game, 2, 2); // O
        simulateMove(game, 0, 2); // X wins

        printBoard(game); // Debug board state

        assertTrue(game.checkWinner(), "X should have won the game");

        char winner = game.getCurrentPlayer();

        simulateMove(game, 2, 0); // O tries to move after X wins
        assertEquals(winner, game.getCurrentPlayer(), "Turn should not change after a win");

        printBoard(game); // Debug board state for GitHub Actions
    }
}
