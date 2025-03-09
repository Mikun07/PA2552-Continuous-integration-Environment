import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;

public class TC4Test {
    private TicTacToe game;

    @BeforeEach
    void setUp() {
        game = new TicTacToe('X'); // Initialize game with player 'X'
        // game.setVisible(true); // Ensure UI loads before testing
    }

    @Test
    void testPreventRepeatedMove() {
        JButton button = game.buttons[1][1]; // Select a button
        button.doClick(); // Player 'X' clicks
        assertEquals("X", button.getText(), "First move should be 'X'");

        button.doClick(); // Try clicking again
        assertEquals("X", button.getText(), "Button should not change after a second click");
        assertEquals('O', game.currentPlayer, "Turn should not switch after an invalid move");
    }
}
