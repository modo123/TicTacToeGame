package TicTacToeGraphic;

import javax.swing.*;
import java.awt.*;

public class MainPanel2 extends JPanel
{
    private static final int BOARD_SIZE = 3;
    private JButton[][] squares = new JButton[BOARD_SIZE][BOARD_SIZE];
    private FieldListener fieldListener = new FieldListener(squares);
    private OkButton1Listener button1OkListener;
    private OkButton2Listener button2OkListener;
    private StartButtonListener startButtonListener = new StartButtonListener(squares);

    public MainPanel2()
    {
        //****
        //panel z informacjami o graczach
        JPanel informationPanel = new JPanel();
        //informationPanel.setPreferredSize(new Dimension(100,100));
        informationPanel.setLayout(new GridLayout(2,3,0,5));

        JLabel player1Label = new JLabel("Player 1");
        JTextField player1TextField = new JTextField();
        JButton player1OkButton = new JButton("OK");
        button1OkListener = new OkButton1Listener(informationPanel, player1TextField, player1OkButton);
        player1OkButton.addActionListener(button1OkListener);

        JLabel player2Label = new JLabel("Player 2");
        JTextField player2TextField = new JTextField();
        JButton player2OkButton = new JButton("OK");
        button2OkListener = new OkButton2Listener(informationPanel, player2TextField, player2OkButton);
        player2OkButton.addActionListener(button2OkListener);

        informationPanel.add(player1Label);
        informationPanel.add(player1TextField);
        informationPanel.add(player1OkButton);
        informationPanel.add(player2Label);
        informationPanel.add(player2TextField);
        informationPanel.add(player2OkButton);

        //****
        //pomocniczy panel do wyrownania wszystkich komponentow w informationPanel
        JPanel infoHelpPanel = new JPanel();
        infoHelpPanel.setLayout(new BorderLayout(0,15));
        JButton startButton = new JButton("START GAME");
        startButton.addActionListener(startButtonListener);
        infoHelpPanel.add(informationPanel, BorderLayout.CENTER);
        infoHelpPanel.add(startButton, BorderLayout.SOUTH);

        //****
        //plansza do gry
        JPanel gameBoard = new JPanel();
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

        //****
        // dolny panel informacyjny
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(2,1,0,10));
        JLabel playingNowLabel = new JLabel("PLAYING NOW : ");
        JLabel fieldOccupiedInfoLabel = new JLabel("FIELD OCCUPIED !");
        bottomPanel.add(playingNowLabel);
        bottomPanel.add(fieldOccupiedInfoLabel);

        JPanel bottomHelpPanel = new JPanel();
        bottomHelpPanel.setLayout(new BorderLayout(0,10));
        bottomHelpPanel.add(gameBoard, BorderLayout.CENTER);
        bottomHelpPanel.add(bottomPanel, BorderLayout.SOUTH);


        //dodajemy do glownego panelu 'this'
        this.setLayout(new BorderLayout(0,15));
        this.add(infoHelpPanel, BorderLayout.CENTER);
        this.add(bottomHelpPanel, BorderLayout.SOUTH);

        Game2 playersNames = new Game2(player1TextField, player2TextField, playingNowLabel, squares);
        playersNames.initGame();

    }
}