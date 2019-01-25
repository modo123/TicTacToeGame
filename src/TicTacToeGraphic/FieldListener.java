package TicTacToeGraphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class FieldListener implements ActionListener
{
    private JButton[][] squares;
    public Player2[] players;
    private int turn = 1;
    private JLabel playingNowLabel, fieldOccupied;
    //private ImageIcon player2Sign = new ImageIcon("xIconMiddle.png");
    Object[] gameOverWindowOptions = {"Try again", "Exit"};
    int winnerDialowWindow, drawDialogWindow;
    private JFrame mainFrame;
    private JTextField player1Name, player2Name;


    public FieldListener(JButton[][] squares, Player2[] players, JLabel playingNowLabel, JLabel fieldOccupied, JFrame mainFrame, JTextField player1Name, JTextField player2Name)
    {
        this.squares = squares;
        this.players = players;
        this.playingNowLabel = playingNowLabel;
        this.fieldOccupied = fieldOccupied;
        this.mainFrame = mainFrame;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void setSign(int i, int j)
    {
        if (!squares[i][j].getText().equals("-"))
        {
            System.out.println("nie możesz postawić tu znaku. graj jeszcze raz");
            fieldOccupied.setForeground(Color.red);
            fieldOccupied.setText("Field occupied! Try again");
            switchPlayers();
            switchPlayers();
        }
        else if (squares[i][j].getText().equals("-"))
        {
            Player2 player = players[turn];
            squares[i][j].setIcon(player.getSign());
            squares[i][j].setText("");
            fieldOccupied.setText("");
            switchPlayers();
        }
    }

    public boolean checkIfAllFieldOccupied()
    {
        int occupiedFieldsCounter = 0;

        for (int i = 0; i < squares.length; i++)
        {
            for (int j = 0; j < squares[i].length; j++)
            {
                if (!squares[i][j].getText().equals("-"))
                {
                    occupiedFieldsCounter++;
                }
            }
        }

        if (occupiedFieldsCounter == 9)
        {
            drawDialogWindow = JOptionPane.showOptionDialog(null, "Draw !", "Game over", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, gameOverWindowOptions, gameOverWindowOptions[0]);
            playingNowLabel.setText("");
            callDrawDialogActions();
            return true;
        }

        return false;
    }


    public void gameWin()
    {
        switchPlayers();
        playingNowLabel.setText("");
    }

    public boolean checkIfWin()
    {
        //sprawdzanie wygranej w poziomie
        if
        (
                squares[0][0].getIcon() != null && squares[0][0].getIcon().equals(squares[0][1].getIcon()) && squares[0][0].getIcon().equals(squares[0][2].getIcon()) ||
                squares[1][0].getIcon() != null && squares[1][0].getIcon().equals(squares[1][1].getIcon()) && squares[1][0].getIcon().equals(squares[1][2].getIcon()) ||
                squares[2][0].getIcon() != null && squares[2][0].getIcon().equals(squares[2][1].getIcon()) && squares[2][0].getIcon().equals(squares[2][2].getIcon())
        )
            {
                gameWin();
                return true;
            }

        //sprawdzanie wygranej w pionie
        if
        (
                squares[0][0].getIcon() != null && squares[0][0].getIcon().equals(squares[1][0].getIcon()) && squares[0][0].getIcon().equals(squares[2][0].getIcon()) ||
                squares[0][1].getIcon() != null && squares[0][1].getIcon().equals(squares[1][1].getIcon()) && squares[0][1].getIcon().equals(squares[2][1].getIcon()) ||
                squares[0][2].getIcon() != null && squares[0][2].getIcon().equals(squares[1][1].getIcon()) && squares[0][2].getIcon().equals(squares[2][2].getIcon())
        )
            {
               gameWin();
                return true;
            }

        //sprawdzenie wygranej po ukosie
        if
        (
                squares[0][0].getIcon() != null && squares[0][0].getIcon().equals(squares[1][1].getIcon()) && squares[0][0].getIcon().equals(squares[2][2].getIcon()) ||
                squares[0][2].getIcon() != null && squares[0][2].getIcon().equals(squares[1][1].getIcon()) && squares[0][2].getIcon().equals(squares[2][0].getIcon())
        )
            {
                gameWin();
                return true;
            }

            return false;
    }

    public void switchPlayers()
    {
        turn++;
        if (turn >= players.length)
            turn = 0;
    }

    public void callDrawDialogActions()
    {
        if (drawDialogWindow == 0)
        {
            mainFrame.dispose();

            MainFrame2 newMainFrame = new MainFrame2();
        }

        if (drawDialogWindow == 1)
        {
            mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
        }
    }

    public void callWinDialogActions()
    {
        if (winnerDialowWindow == 0)
        {
            mainFrame.dispose();

            MainFrame2 newMainFrame = new MainFrame2();
        }

        if (winnerDialowWindow == 1)
        {
            mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
        }
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        for (int i = 0; i < squares.length; i++)
        {
            for (int j = 0; j < squares[i].length; j++)
            {
                if (source == squares[i][j])
                {
                    setSign(i,j);

                    checkIfAllFieldOccupied();

                    if (checkIfWin())
                    {
                        winnerDialowWindow = JOptionPane.showOptionDialog(null, "The winner is " + players[turn].getName(), "Game over", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null, gameOverWindowOptions, gameOverWindowOptions[0]);
                        callWinDialogActions();
                    }
                    else
                    {
                        playingNowLabel.setText("Now playing : " + players[turn].getName());
                    }
                }
            }
        }
    }
}
