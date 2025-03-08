import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame implements ActionListener {
    JButton[][] buttons = new JButton[3][3]; // 3x3 board
    char currentPlayer; // Current player's symbol ('X' or 'O')
    boolean testMode = false; // Enables test mode (disables player switching)
    static boolean headlessMode = GraphicsEnvironment.isHeadless(); // Detect if running in headless mode

    // Constructor: Initializes the game
    public TicTacToe(char chosenPlayer) {
        this.currentPlayer = chosenPlayer;

        // Always initialize buttons array, even in headless mode
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton(" ");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(this);
            }
        }

        // Skip JFrame setup in headless mode
        if (!headlessMode) {
            setTitle("Tic-Tac-Toe");
            setSize(300, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new GridLayout(3, 3));

            // Add buttons to the UI
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    add(buttons[i][j]);
                }
            }

            setVisible(true);
        } else {
            System.out.println("Running in headless mode (CI/CD). UI will not be created.");
        }
    }

    // Handles button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        // Ignore already filled buttons
        if (!clickedButton.getText().equals(" ")) {
            return;
        }

        // Set button text to current player's symbol
        clickedButton.setText(String.valueOf(currentPlayer));

        // Check for winner
        if (checkWinner()) {
            if (!headlessMode) {
                JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!");
            } else {
                System.out.println("Player " + currentPlayer + " wins!");
            }
            resetBoard();
            return;
        }

        // Check if the board is full (draw condition)
        if (isBoardFull()) {
            if (!headlessMode) {
                JOptionPane.showMessageDialog(this, "It's a draw!");
            } else {
                System.out.println("It's a draw!");
            }
            resetBoard();
            return;
        }

        // Prevent player switching in test mode
        if (!testMode) {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    // Checks if a player has won
    public boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if ((buttons[i][0].getText().equals(String.valueOf(currentPlayer)) &&
                 buttons[i][1].getText().equals(String.valueOf(currentPlayer)) &&
                 buttons[i][2].getText().equals(String.valueOf(currentPlayer))) ||

                (buttons[0][i].getText().equals(String.valueOf(currentPlayer)) &&
                 buttons[1][i].getText().equals(String.valueOf(currentPlayer)) &&
                 buttons[2][i].getText().equals(String.valueOf(currentPlayer)))) {
                return true;
            }
        }
        return (buttons[0][0].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[1][1].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[2][2].getText().equals(String.valueOf(currentPlayer))) ||
               (buttons[0][2].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[1][1].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[2][0].getText().equals(String.valueOf(currentPlayer)));
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
        for (JButton[] row : buttons) {
            for (JButton button : row) {
                button.setText(" ");
            }
        }
    }
}
