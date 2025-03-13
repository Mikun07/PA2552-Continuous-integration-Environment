import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TC04Test {
    private TicTacToe game;

    @BeforeEach
    void setUp() {
        game = new TicTacToe('X'); // Initialize game with player 'X'
    }

    @Test
    void testPreventRepeatedMove() {
        game.simulateMove(1, 1); // Player 'X' moves
        assertEquals("X", game.buttons[1][1].getText(), "First move should be 'X'");
        assertEquals('O', game.getCurrentPlayer(), "Turn should switch to 'O' after valid move");

        game.simulateMove(1, 1); // Player 'O' tries to move to the same spot (invalid)

        // Assert that the move was not overwritten
        assertEquals("X", game.buttons[1][1].getText(), "Button should not change after a second click");
        assertEquals('O', game.getCurrentPlayer(), "Turn should not switch after an invalid move");
    }
}
