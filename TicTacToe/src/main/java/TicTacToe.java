import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe {
    JButton[][] buttons = new JButton[3][3]; // 3x3 board
    char currentPlayer; // Current player's symbol ('X' or 'O')
    boolean testMode = false; // Enables test mode (disables player switching)
    boolean gameWon = false; // Track if the game is already won
    static boolean headlessMode = GraphicsEnvironment.isHeadless(); // Detect if running in CI/CD (headless mode)

    // Constructor: Initializes the game
    public TicTacToe(char chosenPlayer) {
        this.currentPlayer = chosenPlayer;
        this.gameWon = false; // Reset game state at start

        // Always initialize buttons array, even in headless mode
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton(" ");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                buttons[i][j].setFocusPainted(false);
            }
        }

        // If running in headless mode, do not create JFrame
        if (!headlessMode) {
            JFrame frame = new JFrame("Tic-Tac-Toe");
            frame.setSize(300, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new GridLayout(3, 3));

            // Add buttons to the UI
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                    frame.add(buttons[i][j]);
                }
            }

            frame.setVisible(true);
        } else {
            System.out.println("Running in headless mode (CI/CD). UI will not be created.");
        }
    }

    // Handles button clicks
    private class ButtonClickListener implements ActionListener {
        int row, col;

        ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (gameWon) return; // Stop moves after a win

            if (!buttons[row][col].getText().equals(" ")) {
                return; // Ignore already filled buttons
            }

            buttons[row][col].setText(String.valueOf(currentPlayer));

            if (checkWinner()) {
                gameWon = true; // Mark game as won
                if (!headlessMode) {
                    JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
                } else {
                    System.out.println("Player " + currentPlayer + " wins!");
                }
                return;
            }

            if (isBoardFull()) {
                if (!headlessMode) {
                    JOptionPane.showMessageDialog(null, "It's a draw!");
                } else {
                    System.out.println("It's a draw!");
                }
                return;
            }

            if (!testMode) {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    // Checks if a player has won
    public boolean checkWinner() {
        String playerSymbol = String.valueOf(currentPlayer);

        // Check rows
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(playerSymbol) &&
                buttons[i][1].getText().equals(playerSymbol) &&
                buttons[i][2].getText().equals(playerSymbol)) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (buttons[0][i].getText().equals(playerSymbol) &&
                buttons[1][i].getText().equals(playerSymbol) &&
                buttons[2][i].getText().equals(playerSymbol)) {
                return true;
            }
        }

        // Check diagonals
        if ((buttons[0][0].getText().equals(playerSymbol) &&
             buttons[1][1].getText().equals(playerSymbol) &&
             buttons[2][2].getText().equals(playerSymbol)) ||
            (buttons[0][2].getText().equals(playerSymbol) &&
             buttons[1][1].getText().equals(playerSymbol) &&
             buttons[2][0].getText().equals(playerSymbol))) {
            return true;
        }

        return false;
    }

    // Checks if board is full
    boolean isBoardFull() {
        for (JButton[] row : buttons) {
            for (JButton button : row) {
                if (button.getText().equals(" ")) return false;
            }
        }
        return true;
    }

    // Resets the board for a new game
    void resetBoard() {
        gameWon = false; // Reset game state
        for (JButton[] row : buttons) {
            for (JButton button : row) {
                button.setText(" ");
            }
        }
    }

    // Simulate a button click programmatically for testing
    public void simulateMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) return; // Ignore out-of-bounds moves
        buttons[row][col].doClick(); // Simulate click event
    }

    // Get the current player (for testing purposes)
    public char getCurrentPlayer() {
        return currentPlayer;
    }
}
