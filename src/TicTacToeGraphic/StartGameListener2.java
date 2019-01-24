package TicTacToeGraphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGameListener2 implements ActionListener
{
    private JButton[][] squares;
    private ImageIcon oIcon = new ImageIcon("O.png");
    private ImageIcon xIcon = new ImageIcon("X.png");

    public StartGameListener2(JButton[][] squares)
    {
        this.squares = squares;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

//        Object source = e.getSource();
//
//        for (int i = 0; i < squares.length; i++)
//        {
//            for (int j = 0; j < squares[i].length; j++)
//            {
//                if (source == squares[i][j])
//                {
//                    squares[i][j].setIcon(xIcon);
//                }
//            }
//        }
        System.out.println("HEHE");
    }
}
