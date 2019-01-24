package TicTacToeGraphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButtonListener implements ActionListener
{
    private JButton[][] squares;

    public StartButtonListener(JButton[][] squares)
    {
        this.squares = squares;
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
    }
}
