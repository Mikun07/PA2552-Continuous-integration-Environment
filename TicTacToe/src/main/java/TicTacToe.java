import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame implements ActionListener {
<<<<<<< HEAD
    JButton[][] buttons = new JButton[3][3];
    public char currentPlayer;
    public boolean isTestMode;

    // Normal constructor (for real gameplay)
=======
    JButton[][] buttons = new JButton[3][3]; // 3x3 board
    char currentPlayer; // Current player's symbol ('X' or 'O')

    // Constructor: Initializes the game
>>>>>>> 17fde664e3631a9e7daf71db56ab47f50e499bdd
    public TicTacToe(char chosenPlayer) {
        this(chosenPlayer, false); // Calls the second constructor with test mode disabled
    }

    // Test mode constructor (prevents GUI from showing)
    public TicTacToe(char chosenPlayer, boolean isTestMode) {
        this.currentPlayer = chosenPlayer;
<<<<<<< HEAD
        this.isTestMode = isTestMode; // Store test mode flag
        
=======

        // Window properties
>>>>>>> 17fde664e3631a9e7daf71db56ab47f50e499bdd
        setTitle("Tic-Tac-Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

<<<<<<< HEAD
=======
        // Initialize board
>>>>>>> 17fde664e3631a9e7daf71db56ab47f50e499bdd
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton(" ");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
            }
        }

<<<<<<< HEAD
        if (!isTestMode) {  // Only show UI if not in test mode
            setVisible(true);
        }
    }

=======
        setVisible(true);
    }

    // Handles button clicks
>>>>>>> 17fde664e3631a9e7daf71db56ab47f50e499bdd
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        // Ignore already filled buttons
        if (!clickedButton.getText().equals(" ")) {
            return;
        }

<<<<<<< HEAD
=======
        // Set button text to current player's symbol
>>>>>>> 17fde664e3631a9e7daf71db56ab47f50e499bdd
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

<<<<<<< HEAD
        if (isBoardFull()) {
=======
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
>>>>>>> 17fde664e3631a9e7daf71db56ab47f50e499bdd
            JOptionPane.showMessageDialog(this, "It's a draw!");
            resetBoard();
            return;
        }

<<<<<<< HEAD
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public boolean checkWinner() {  
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[i][1].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[i][2].getText().equals(String.valueOf(currentPlayer))) {
                return true;
            }
            if (buttons[0][i].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[1][i].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[2][i].getText().equals(String.valueOf(currentPlayer))) {
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

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

=======
        // Switch player
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Resets the board for a new game
>>>>>>> 17fde664e3631a9e7daf71db56ab47f50e499bdd
    void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText(" ");
            }
        }
    }

<<<<<<< HEAD
=======
    // Main method: Handles game start
>>>>>>> 17fde664e3631a9e7daf71db56ab47f50e499bdd
    public static void main(String[] args) {
        int option = JOptionPane.showOptionDialog(null, "Welcome to Tic-Tac-Toe!", "Tic-Tac-Toe",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                new String[]{"New Game", "Exit"}, "New Game");

        if (option == 1) {
            System.exit(0);
        }

<<<<<<< HEAD
=======
        // Ask user to choose 'X' or 'O'
>>>>>>> 17fde664e3631a9e7daf71db56ab47f50e499bdd
        String[] choices = {"X", "O"};
        String selected = (String) JOptionPane.showInputDialog(null, "Choose your symbol:",
                "Player Selection", JOptionPane.QUESTION_MESSAGE, null, choices, "X");

        if (selected == null) {
            System.exit(0);
        }

<<<<<<< HEAD
=======
        // Start game with chosen player
>>>>>>> 17fde664e3631a9e7daf71db56ab47f50e499bdd
        new TicTacToe(selected.charAt(0));
    }
}
