package TicTacToeGraphic;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel
{
    private static final int BOARD_SIZE = 3;
    private JButton[][] squares = new JButton[BOARD_SIZE][BOARD_SIZE];
    private OkButton1Listener button1OkListener;
    private OkButton2Listener button2OkListener;
    Player[] players = new Player[2];
    JFrame mainFrame;

    public MainPanel(JFrame mainFrame)
    {
        this.mainFrame = mainFrame;
        //****
        //panel z informacjami o graczach
        JPanel informationPanel = new JPanel();
        informationPanel.setBackground(Color.orange);
        informationPanel.setLayout(new GridLayout(2,4,0,5));

        JLabel player1Label = new JLabel("Player 1");
        JTextField player1TextField = new JTextField();
        JButton player1Sign = new JButton("p1");
        player1Sign.setVisible(false);
        JButton player1OkButton = new JButton("OK");

        JLabel player2Label = new JLabel("Player 2");
        JTextField player2TextField = new JTextField();
        JButton player2Sign = new JButton("p2");
        player2Sign.setVisible(false);
        JButton player2OkButton = new JButton("OK");

        informationPanel.add(player1Label);
        informationPanel.add(player1TextField);
        informationPanel.add(player1Sign);
        informationPanel.add(player1OkButton);

        informationPanel.add(player2Label);
        informationPanel.add(player2TextField);
        informationPanel.add(player2Sign);
        informationPanel.add(player2OkButton);

        //****
        //pomocniczy panel do wyrownania wszystkich komponentow w informationPanel
        JPanel infoHelpPanel = new JPanel();
        infoHelpPanel.setBackground(Color.orange);
        infoHelpPanel.setLayout(new BorderLayout(0,15));
        JButton startButton = new JButton("START GAME");
        startButton.setEnabled(false);
        infoHelpPanel.add(informationPanel, BorderLayout.CENTER);
        infoHelpPanel.add(startButton, BorderLayout.SOUTH);

        //****
        // dolny panel informacyjny
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.orange);
        bottomPanel.setLayout(new GridLayout(2,1,0,10));
        JLabel playingNowLabel = new JLabel("-");
        JLabel fieldOccupiedInfoLabel = new JLabel("-");
        bottomPanel.add(playingNowLabel);
        bottomPanel.add(fieldOccupiedInfoLabel);

        StartButtonListener startButtonListener = new StartButtonListener(squares, player1OkButton, player2OkButton, startButton, player1TextField, player2TextField, players, playingNowLabel);
        startButton.addActionListener(startButtonListener);
        button1OkListener = new OkButton1Listener(informationPanel, player1TextField, player1OkButton, player1Sign);
        player1OkButton.addActionListener(button1OkListener);
        button2OkListener = new OkButton2Listener(informationPanel, player2TextField, player2OkButton, player2Sign);
        player2OkButton.addActionListener(button2OkListener);

        FieldListener fieldListener = new FieldListener(squares, players, playingNowLabel, fieldOccupiedInfoLabel, mainFrame, player1TextField, player2TextField);

        //****
        //plansza do gry
        JPanel gameBoard = new JPanel();
        gameBoard.setBackground(Color.orange);
        gameBoard.setPreferredSize(new Dimension(400,400));
        gameBoard.setLayout(new GridLayout(BOARD_SIZE,BOARD_SIZE));

        for (int i = 0; i < squares.length; i++)
        {
            for (int j = 0; j < squares[i].length; j++)
            {
                squares[i][j] = new JButton("-");
                squares[i][j].setEnabled(false);
                gameBoard.add(squares[i][j]);
                squares[i][j].setBackground(Color.lightGray);
                squares[i][j].addActionListener(fieldListener);
            }
        }

        //dalsza czesc dolnego panelu
        JPanel bottomHelpPanel = new JPanel();
        bottomHelpPanel.setBackground(Color.orange);
        bottomHelpPanel.setLayout(new BorderLayout(0,10));
        bottomHelpPanel.add(gameBoard, BorderLayout.CENTER);
        bottomHelpPanel.add(bottomPanel, BorderLayout.SOUTH);


        //dodajemy do glownego panelu 'this'
        this.setLayout(new BorderLayout(0,15));
        this.add(infoHelpPanel, BorderLayout.CENTER);
        this.add(bottomHelpPanel, BorderLayout.SOUTH);

    }
}
