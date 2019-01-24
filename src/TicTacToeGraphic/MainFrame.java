package TicTacToeGraphic;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    public MainFrame()
    {
        super("TicTacToe");

        StartGameListener listener = new StartGameListener(this);
        JPanel informationPanel = new InformationPanel(listener);
        add(informationPanel);


        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
