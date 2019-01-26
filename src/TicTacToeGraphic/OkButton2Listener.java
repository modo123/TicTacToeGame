package TicTacToeGraphic;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class OkButton2Listener implements ActionListener
{
    private JPanel panel;
    private JTextField player2TextField;
    private JButton player2Button;
    //private ImageIcon player2Sign = new ImageIcon("xIconMini.png");
    private JButton player2SignButton;
    URL url = OkButton2Listener.class.getResource("/resources/xIconMini.png");
    private ImageIcon player2Sign = new ImageIcon(url);

    public OkButton2Listener(JPanel panel, JTextField player2TextField, JButton player2Button, JButton player2SignButton )
    {
        this.panel = panel;
        this.player2TextField = player2TextField;
        this.player2Button = player2Button;
        this.player2SignButton = player2SignButton;
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

            player2SignButton.setText("");
            player2SignButton.setVisible(true);
            player2SignButton.setBorder(BorderFactory.createEmptyBorder());
            player2SignButton.setBackground(Color.orange);
            player2TextField.setBackground(Color.orange);
            player2SignButton.setIcon(player2Sign);

            StartButtonListener.checkIfUnlockStartButton();
        }

        panel.revalidate();
        panel.repaint();

    }
}
