import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TC02Test {

    @Test
    void testHorizontalWin() {
        TicTacToe.headlessMode = true; // Ensure headless mode is enabled
        TicTacToe game = new TicTacToe('X');
        game.testMode = false;

        game.buttons[0][0].setText("X");
        game.buttons[0][1].setText("X");
        game.buttons[0][2].setText("X");

        assertTrue(game.checkWinner(), "Horizontal win should be detected");
    }

    @Test
    void testVerticalWin() {
        TicTacToe.headlessMode = true;
        TicTacToe game = new TicTacToe('X');
        game.testMode = false;

        game.buttons[0][0].setText("X");
        game.buttons[1][0].setText("X");
        game.buttons[2][0].setText("X");

        assertTrue(game.checkWinner(), "Vertical win should be detected");
    }

    @Test
    void testDiagonalWin() {
        TicTacToe.headlessMode = true;
        TicTacToe game = new TicTacToe('X');
        game.testMode = false;

        game.buttons[0][0].setText("X");
        game.buttons[1][1].setText("X");
        game.buttons[2][2].setText("X");

        assertTrue(game.checkWinner(), "Diagonal win should be detected");
    }
}