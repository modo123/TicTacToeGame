package TicTacToeGraphic;

import javax.swing.*;

public class Game2
{
    Player2[] players = new Player2[2];
    private JButton[][] board;
    private JPanel mainPanel;
    private int turn = 0;
    private static final int BOARD_SIZE = 3;
    private ImageIcon[] signs = {new ImageIcon("O.png"), new ImageIcon("X.png")};
    private JTextField player1name, player2name;
    private JLabel playingNowLabel;
    private JButton[][] squares;

    public Game2(JTextField player1name, JTextField player2name, JLabel playingNowLabel, JButton[][] squares)
    {
        this.player1name = player1name;
        this.player2name = player2name;
        this.playingNowLabel = playingNowLabel;
        this.squares = squares;
    }

    public void setPlayersData()
    {
       players[0] = new Player2(player1name.getText(), signs[0]);
       players[1] = new Player2(player2name.getText(), signs[1]);
    }

    public void switchPlayers()
    {
        turn++;
        if (turn >= players.length)
            turn = 0;
    }

    public void playGame()
    {
        while (true)
        {
            Player2 player = players[turn];
            playingNowLabel.setText("PLAYING NOW : " + player.getName());

            switchPlayers();
        }
    }

    public void initGame()
    {
        System.out.println("INICJACJA GRY");
       // setPlayersData();
        //FieldListener fl = new FieldListener(players);


    }

}
