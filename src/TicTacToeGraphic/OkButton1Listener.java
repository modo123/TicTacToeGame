package TicTacToeGraphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OkButton1Listener implements ActionListener
{
    private JPanel panel;
    private JTextField player1TextField;
    private JButton player1Button;

    public OkButton1Listener(JPanel panel, JTextField player1TextField, JButton player1Button)
    {
        this.panel = panel;
        this.player1TextField = player1TextField;
        this.player1Button = player1Button;
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
        }

        panel.revalidate();
        panel.repaint();
       //System.out.println("LOL");
    }
}
