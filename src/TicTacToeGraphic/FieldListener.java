package TicTacToeGraphic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FieldListener implements ActionListener
{
    private JButton[][] squares;

    public FieldListener(JButton[][] squares)
    {
        this.squares = squares;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
