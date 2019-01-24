package TicTacToeGraphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FieldListener implements ActionListener
{
    private JButton[][] squares;
    public Player2[] players;
    private int turn = 0;
    private JLabel playingNowLabel;


    public FieldListener(JButton[][] squares, Player2[] players, JLabel playingNowLabel)
    {
        this.squares = squares;
        this.players = players;
        this.playingNowLabel = playingNowLabel;
    }

    public void checkIfCanSetSign()
    {

    }

    public void setSign(int i, int j)
    {
        Player2 player = players[turn];
        squares[i][j].setIcon(player.getSign());
    }

    public void switchPlayers()
    {
        turn++;
        if (turn >= players.length)
            turn = 0;

        playingNowLabel.setText("PLAYING NOW : " + players[turn].getName());
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
                    switchPlayers();
                    setSign(i,j);
                    //System.out.println("Teraz gra " + players[turn].getName());
                    //setSign(i,j);

                    //System.out.println(turn);
                    //System.out.println(players[1].getName());
                    //System.out.println(players[0].getName());
                }
            }
        }
    }
}
