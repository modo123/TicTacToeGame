package TicTacToeGraphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class OkButton1Listener implements ActionListener
{
    private JPanel panel;
    private JTextField player1TextField;
    private JButton player1Button;
    //private ImageIcon player1Sign = new ImageIcon("oIconMini.png");
    private JButton player1SignButton;
    URL url = OkButton2Listener.class.getResource("/resources/oIconMini.png");
    private ImageIcon player1Sign = new ImageIcon(url);


    public OkButton1Listener(JPanel panel, JTextField player1TextField, JButton player1Button, JButton player1SignButton)
    {
        this.panel = panel;
        this.player1TextField = player1TextField;
        this.player1Button = player1Button;
        this.player1SignButton = player1SignButton;
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

            player1SignButton.setText("");
            player1SignButton.setVisible(true);
            player1SignButton.setBorder(BorderFactory.createEmptyBorder());
            player1SignButton.setBackground(Color.orange);
            player1TextField.setBackground(Color.orange);
            player1SignButton.setIcon(player1Sign);

            StartButtonListener.checkIfUnlockStartButton();
        }

        panel.revalidate();
        panel.repaint();
    }
}
