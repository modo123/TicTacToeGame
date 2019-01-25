package TicTacToeGraphic;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    public MainFrame()
    {
        super("TicTacToe");
        MainPanel mainPanel = new MainPanel(this);
        mainPanel.setBackground(Color.orange);
        this.setSize(550,600);
        add(mainPanel);


        setLocationRelativeTo(null);
        setResizable(false);
        //pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
