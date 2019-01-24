package TicTacToeGraphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGameListener implements ActionListener
{
    private final JFrame mainFrame;


    public StartGameListener(JFrame frame)
    {
        mainFrame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JPanel newPanel = new JPanel();
        newPanel.setSize(600,600);
        //JButton tmp = new JButton("temp");
        //newPanel.add(tmp);
        mainFrame.getContentPane().removeAll();
        mainFrame.add(newPanel);
        mainFrame.validate();
        //System.out.println("HEHEH");
    }
}
