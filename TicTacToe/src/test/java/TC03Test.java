import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * TC03Test - Tests for the board reset functionality
 * Description: Ensure the board resets correctly when a new game starts.
 */
public class TC03Test {
    
    private TicTacToe game;
    
    @BeforeEach
    public void setUp() {
        // Initialize game with player 'X'
        game = new TicTacToe('X');
        // Enable test mode to prevent automatic player switching
        game.testMode = false;
    }
    
    @Test
    @DisplayName("TC03.1 - Verify board resets after a win")
    public void testResetAfterWin() {
        // Create a winning scenario (X wins with first row)
        game.simulateMove(0, 0); // X in top-left
        //Force player to be X since simulateMove() toggles player
        game.currentPlayer = 'X';
        game.simulateMove(0, 1); // X in top-middle
        game.currentPlayer = 'X';  
        game.simulateMove(0, 2); // X in top-right
        
        // Verify game is marked as won before reset
        assertTrue(game.gameWon, "Game should be marked as won");
        
        // Reset the board
        game.resetBoard();
        
        // Verify game is no longer marked as won
        assertFalse(game.gameWon, "gameWon flag should be reset to false");
        
        // Verify all buttons are reset to empty space
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(" ", game.buttons[i][j].getText(), 
                        "Button at position [" + i + "][" + j + "] should be empty");
            }
        }
    }
    
    @Test
    @DisplayName("TC03.2 - Verify board resets after partial game")
    public void testResetAfterPartialGame() {
        // Make some moves without winning
        game.simulateMove(0, 0); // X in top-left  
        game.currentPlayer = 'O';   // Switch to O
        game.simulateMove(1, 1); // O in middle   
        game.currentPlayer = 'X';  // Switch back to X
        game.simulateMove(2, 2); // X in bottom-right
        
        // Verify game is not won
        assertFalse(game.gameWon, "Game should not be won yet");
        
        // Verify buttons have X and O values
        assertEquals("X", game.buttons[0][0].getText());
        assertEquals("O", game.buttons[1][1].getText());
        assertEquals("X", game.buttons[2][2].getText());
        
        // Reset the board
        game.resetBoard();
        
        // Verify game is still not marked as won
        assertFalse(game.gameWon, "gameWon flag should still be false");
        
        // Verify all buttons are reset to empty space
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(" ", game.buttons[i][j].getText(), 
                        "Button at position [" + i + "][" + j + "] should be empty");
            }
        }
    }
    
    @Test
    @DisplayName("TC03.3 - Verify board resets after a draw")
    public void testResetAfterDraw() {
        // Create a draw scenario
        // X | O | X
        // X | O | O
        // O | X | X
        game.simulateMove(0, 0); // X
        game.simulateMove(0, 1); // O
        game.simulateMove(0, 2); // X
        game.simulateMove(1, 0); // O
        game.simulateMove(1, 1); // X
        game.simulateMove(1, 2); // O
        game.simulateMove(2, 0); // X
        game.simulateMove(2, 1); // O
        game.simulateMove(2, 2); // X
        
        // Verify all buttons are filled
        assertTrue(game.isBoardFull(), "Board should be full");
        
        // Reset the board
        game.resetBoard();
        
        // Verify game is not marked as won
        assertFalse(game.gameWon, "gameWon flag should be false");
        
        // Verify all buttons are reset to empty space
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(" ", game.buttons[i][j].getText(), 
                        "Button at position [" + i + "][" + j + "] should be empty");
            }
        }
        
        // Verify board is no longer full
        assertFalse(game.isBoardFull(), "Board should not be full after reset");
    }
    
    @Test
    @DisplayName("TC03.4 - Verify multiple resets work correctly")
    public void testMultipleResets() {
        // Make some moves
        game.simulateMove(0, 0);
        game.simulateMove(1, 1);
        
        // First reset
        game.resetBoard();
        
        // Verify reset worked
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(" ", game.buttons[i][j].getText());
            }
        }
        
        // Make different moves
        game.simulateMove(2, 2);
        game.simulateMove(0, 2);
        
        // Second reset
        game.resetBoard();
        
        // Verify second reset worked
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(" ", game.buttons[i][j].getText());
            }
        }
    }
}
