import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TC05Test {
    
    @Test
    @DisplayName("Verify if the game detects a draw when all cells are filled and no winner exists")
    public void testGameDrawDetection() {
        // Create a new game instance starting with player 'X'
        TicTacToe game = new TicTacToe('X');
        
        // Simulate a sequence of moves that leads to a draw
        // This pattern creates:
        // X | O | X
        // X | O | O
        // O | X | X
        
        // First row
        game.simulateMove(0, 0); // X at top-left
        game.simulateMove(0, 1); // O at top-middle
        game.simulateMove(0, 2); // X at top-right
        
        // Second row
        game.simulateMove(1, 2); // O at middle-right
        game.simulateMove(1, 0); // X at middle-left
        game.simulateMove(1, 1); // O at middle-middle
        
        // Third row
        game.simulateMove(2, 1); // X at bottom-middle
        game.simulateMove(2, 0); // O at bottom-left
        game.simulateMove(2, 2); // X at bottom-right 
        
        // Check if the board is full
        assertTrue(game.isBoardFull(), "Board should be full after all moves");
        
        // Check that there is no winner
        assertFalse(game.checkWinner(), "There should be no winner in this draw scenario");
    }
    
    @Test
    @DisplayName("Verify another draw scenario with different move sequence")
    public void testAlternateDrawScenario() {
        // Create a new game instance starting with player 'X'
        TicTacToe game = new TicTacToe('X');
        
        // Simulate a different sequence of moves leading to a draw
        // This pattern creates:
        // X | X | O
        // O | O | X
        // X | O | X
        
        game.simulateMove(0, 0); // X at top-left
        game.simulateMove(1, 0); // O at middle-left
        game.simulateMove(0, 1); // X at top-middle
        game.simulateMove(1, 1); // O at middle-middle
        game.simulateMove(2, 0); // X at bottom-left
        game.simulateMove(0, 2); // O at top-right
        game.simulateMove(1, 2); // X at middle-right
        game.simulateMove(2, 1); // O at bottom-middle
        game.simulateMove(2, 2); // X at bottom-right
        
        // Check if the board is full
        assertTrue(game.isBoardFull(), "Board should be full after all moves");
        
        // Check that there is no winner
        assertFalse(game.checkWinner(), "There should be no winner in this draw scenario");
    }
}
