import java.util.Scanner;

public class Game
{
    Player[] players = new Player[2];
    Board board;

    private int turn = 0;

    Scanner scanner = new Scanner(System.in);

    public void setPlayersData()
    {
        for (int i = 0; i < players.length; i++)
        {
            System.out.println("Podaj imię gracza numer " + (i + 1) );
            String playerName = scanner.next();
            System.out.println("Podaj znak gracza numer " + (i + 1) );
            char playerSign = scanner.next().charAt(0);

            players[i] = new Player(playerName, playerSign);
        }
    }

    public void setTitleText()
    {
        System.out.println("WITAJCIE W GRZE KOŁKO I KRZYŻYK. ZACZYNAJMY!");
    }

    public void initBoard()
    {
        System.out.println("Podaj rozmiary kwadratowej planszy ");
        int boardSize = scanner.nextInt();
        board = new Board(boardSize);
        board.printBoard();
    }



    public void playGame()
    {
        while (true)
        {
            Player player = players[turn];
            System.out.println("Teraz gra " + player.getName());

            System.out.println("Podaj wspolrzedne y i x");
            int y = scanner.nextInt();
            int x = scanner.nextInt();

            board.setSign(y,x, player);
            board.printBoard();
            switchPlayers();
        }

    }

    public void switchPlayers()
    {
        turn++;
        if (turn >= players.length)
            turn = 0;
    }

    public void initGame()
    {
        setTitleText();
        setPlayersData();
        initBoard();
        playGame();
    }

}
