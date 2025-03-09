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
    void testPreventRepeatedMove() throws InterruptedException {
        JButton button = game.buttons[1][1]; // Select a button
        button.doClick(); // Player 'X' clicks or moves

        // Allow UI to update (only needed for CI/CD)
        Thread.sleep(500); // Give time for UI to process

        assertEquals("X", button.getText(), "First move should be 'X'");

        button.doClick();  // Second click (invalid)
        Thread.sleep(500); // Allow UI to update
        
        assertEquals("X", button.getText(), "Button should not change after a second click");
        assertEquals('O', game.currentPlayer, "Turn should not switch after an invalid move");
    }
}
