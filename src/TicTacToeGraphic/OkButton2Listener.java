package TicTacToeGraphic;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OkButton2Listener implements ActionListener
{
    private JPanel panel;
    private JTextField player2TextField;
    private JButton player2Button;

    public OkButton2Listener(JPanel panel, JTextField player2TextField, JButton player2Button)
    {
        this.panel = panel;
        this.player2TextField = player2TextField;
        this.player2Button = player2Button;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        if (player2TextField.getText().isEmpty())
        {
            player2TextField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
        }
        else
        {
            player2TextField.setBorder(BorderFactory.createEmptyBorder());
            player2TextField.setEditable(false);
            player2Button.setEnabled(false);

        }

        panel.revalidate();
        panel.repaint();
        //System.out.println("LOL2");
    }
}
