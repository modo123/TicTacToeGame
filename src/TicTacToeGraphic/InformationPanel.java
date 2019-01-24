package TicTacToeGraphic;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class InformationPanel extends JPanel
{
    private StartGameListener listener;

    public InformationPanel(StartGameListener listener)
    {
        setPreferredSize(new Dimension(300, 200));
        setLayout(new GridLayout(3,1));
        this.listener = listener;

        //panel z powitaniem
        JPanel panelFirst = new JPanel();
        panelFirst.setSize(300,20);
        JLabel welcomeLabel = new JLabel("WELCOME");
        panelFirst.add(welcomeLabel);

        //panel z danymi graczy
        JPanel panelSecond = new JPanel();
        panelSecond.setLayout(new GridLayout(2,3));
        JLabel player1Label = new JLabel("Player 1");
        JTextField player1TextField = new JTextField();
        JButton player1OkButton = new JButton("OK");

        JLabel player2Label = new JLabel("Player 2");
        JTextField player2TextField = new JTextField();
        JButton player2OkButton = new JButton("OK");

        panelSecond.add(player1Label);
        panelSecond.add(player1TextField);
        panelSecond.add(player1OkButton);
        panelSecond.add(player2Label);
        panelSecond.add(player2TextField);
        panelSecond.add(player2OkButton);

        //pomocniczy panel do wysorodkowania elementow
        JPanel helpPanel = new JPanel();
        helpPanel.setLayout(new BorderLayout());
        JButton startButton = new JButton("Start");
        startButton.addActionListener(listener);
        helpPanel.add(panelSecond, BorderLayout.CENTER);
        helpPanel.add(startButton, BorderLayout.SOUTH);


        //panel z informacjami dla uzytkownika
        JPanel panelThird = new JPanel();
        panelThird.setLayout(new GridLayout(2,1));
        JLabel playingNowInformation = new JLabel("Teraz gra ...");
        JLabel fieldOccupiedInformation = new JLabel("Pole zajete ...");
        panelThird.add(playingNowInformation);
        panelThird.add(fieldOccupiedInformation);


        this.add(panelFirst);
        this.add(helpPanel);
        this.add(panelThird);


    }
}
