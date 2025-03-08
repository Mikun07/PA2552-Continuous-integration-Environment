import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TC02Test {

    @Test
    void testHorizontalWin() {
        TicTacToe.headlessMode = true; // Set before initializing game
        TicTacToe game = new TicTacToe('X');
        game.testMode = true;

        // Directly set button values in headless mode
        game.buttons[0][0].setText("X");
        game.buttons[0][1].setText("X");
        game.buttons[0][2].setText("X");

        // Ensure the game correctly detects a horizontal win
        assertTrue(game.checkWinner(), "Horizontal win should be detected");
    }

    @Test
    void testVerticalWin() {
        TicTacToe.headlessMode = true; 
        TicTacToe game = new TicTacToe('X');
        game.testMode = true;

        game.buttons[0][0].setText("X");
        game.buttons[1][0].setText("X");
        game.buttons[2][0].setText("X");

        assertTrue(game.checkWinner(), "Vertical win should be detected");
    }

    @Test
    void testDiagonalWin() {
        TicTacToe.headlessMode = true; 
        TicTacToe game = new TicTacToe('X');
        game.testMode = true;

        game.buttons[0][0].setText("X");
        game.buttons[1][1].setText("X");
        game.buttons[2][2].setText("X");

        assertTrue(game.checkWinner(), "Diagonal win should be detected");
    }
}
