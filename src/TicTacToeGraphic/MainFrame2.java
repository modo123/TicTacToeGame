package TicTacToeGraphic;

import javax.swing.*;
import java.awt.*;

public class MainFrame2 extends JFrame
{
    public MainFrame2()
    {
        super("TicTacToe");
        MainPanel2 mainPanel = new MainPanel2(this);
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
