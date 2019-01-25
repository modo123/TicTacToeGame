package TicTacToeGraphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.temporal.JulianFields;

public class StartButtonListener implements ActionListener
{
    private JButton[][] squares;
    private static JButton player1OkButton, player2OkButton, startButton;
    private JTextField player1Name, player2Name;
    private Player2 players[];
    private ImageIcon player1Sign = new ImageIcon("oIconMiddle.png");
    private ImageIcon player2Sign = new ImageIcon("xIconMiddle.png");
    private JLabel playingNowLabel;

    public StartButtonListener(JButton[][] squares, JButton player1OkButton, JButton player2OkButton, JButton startButton, JTextField player1name, JTextField player2Name, Player2[] players, JLabel playingNowLabel)
    {
        this.squares = squares;
        this.player1OkButton = player1OkButton;
        this.player2OkButton = player2OkButton;
        this.startButton = startButton;
        this.player1Name = player1name;
        this.player2Name = player2Name;
        this.players = players;
        this.playingNowLabel = playingNowLabel;
    }

    public static void checkIfUnlockStartButton()
    {
        if ( !player1OkButton.isEnabled() && !player2OkButton.isEnabled() )
        {
            startButton.setEnabled(true);

        }
        else
        {

        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
//
        for (int i = 0; i < squares.length; i++)
        {
            for (int j = 0; j < squares[i].length; j++)
            {
                squares[i][j].setBackground(Color.white);
                squares[i][j].setEnabled(true);
            }
        }
        players[0] = new Player2(player1Name.getText(), player1Sign );
        players[1] = new Player2(player2Name.getText(), player2Sign );
        startButton.setEnabled(false);
        playingNowLabel.setText("Now playing : " + players[1].getName());
    }
}
