package TicTacToeGraphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OkButton1Listener implements ActionListener
{
    private JPanel panel;
    private JTextField player1TextField;
    private JButton player1Button, startButton;
    private JTextField player1Name;
    private ImageIcon player1Sign = new ImageIcon("O3.png");

    public OkButton1Listener(JPanel panel, JTextField player1TextField, JButton player1Button, JButton startButton, JTextField player1Name)
    {
        this.panel = panel;
        this.player1TextField = player1TextField;
        this.player1Button = player1Button;
        this.startButton = startButton;
        this.player1Name = player1Name;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (player1TextField.getText().isEmpty())
        {
            player1TextField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
        }
        else
        {
            player1TextField.setBorder(BorderFactory.createEmptyBorder());
            player1TextField.setEditable(false);
            player1Button.setEnabled(false);
            //player1Button.setText("");
            //player1Button.setBackground(Color.white);
            //player1Button.setBorder(BorderFactory.createEmptyBorder());
            //player1Button.setIcon(player1Sign);

            StartButtonListener.checkIfUnlockStartButton();
        }

        panel.revalidate();
        panel.repaint();
    }
}
