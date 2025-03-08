import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame implements ActionListener {
    JButton[][] buttons = new JButton[3][3]; // 3x3 board
    char currentPlayer; // Current player's symbol ('X' or 'O')
    boolean testMode = false; // Enables test mode (disables player switching)

    // Constructor: Initializes the game
    public TicTacToe(char chosenPlayer) {
        this.currentPlayer = chosenPlayer;

        // Window properties
        setTitle("Tic-Tac-Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        // Initialize board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton(" ");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
            }
        }

        setVisible(true);
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
        for (int i = 0; i < 3; i++) {
            if ((buttons[i][0].getText().equals(String.valueOf(currentPlayer)) &&
                 buttons[i][1].getText().equals(String.valueOf(currentPlayer)) &&
                 buttons[i][2].getText().equals(String.valueOf(currentPlayer))) ||

                (buttons[0][i].getText().equals(String.valueOf(currentPlayer)) &&
                 buttons[1][i].getText().equals(String.valueOf(currentPlayer)) &&
                 buttons[2][i].getText().equals(String.valueOf(currentPlayer)))) {
                
                JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!");
                resetBoard();
                return;
            }
        }

        // Check diagonals for winner
        if ((buttons[0][0].getText().equals(String.valueOf(currentPlayer)) &&
             buttons[1][1].getText().equals(String.valueOf(currentPlayer)) &&
             buttons[2][2].getText().equals(String.valueOf(currentPlayer))) ||

            (buttons[0][2].getText().equals(String.valueOf(currentPlayer)) &&
             buttons[1][1].getText().equals(String.valueOf(currentPlayer)) &&
             buttons[2][0].getText().equals(String.valueOf(currentPlayer)))) {
            
            JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!");
            resetBoard();
            return;
        }

        // Check if the board is full (draw condition)
        boolean boardFull = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals(" ")) {
                    boardFull = false;
                    break;
                }
            }
        }

        if (boardFull) {
            JOptionPane.showMessageDialog(this, "It's a draw!");
            resetBoard();
            return;
        }

        // Prevent player switching in test mode
        if (!testMode) {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    // Resets the board for a new game
    void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText(" ");
            }
        }
    }

    // Main method: Handles game start
    public static void main(String[] args) {
        int option = JOptionPane.showOptionDialog(null, "Welcome to Tic-Tac-Toe!", "Tic-Tac-Toe",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                new String[]{"New Game", "Exit"}, "New Game");

        if (option == 1) {
            System.exit(0);
        }

        // Ask user to choose 'X' or 'O'
        String[] choices = {"X", "O"};
        String selected = (String) JOptionPane.showInputDialog(null, "Choose your symbol:",
                "Player Selection", JOptionPane.QUESTION_MESSAGE, null, choices, "X");

        if (selected == null) {
            System.exit(0);
        }

        // Start game with chosen player
        new TicTacToe(selected.charAt(0));
    }
}
