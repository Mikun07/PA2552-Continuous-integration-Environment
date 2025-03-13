import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TC01Test {
    
    private TicTacToe game;

    @Test
    public void testEmptyBoardOnNewGame() {
        // Create a new game with 'X' as the starting player
        game = new TicTacToe('X');
        
        // Check all buttons are empty
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                assertEquals(" ", game.buttons[row][col].getText(), 
                            "Button at position [" + row + "][" + col + "] should be empty at start");
            }
        }
    }
    
    @AfterEach
    public void cleanup() {
        game = null; // Allow garbage collection to clean up
    }
}