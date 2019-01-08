import java.util.Scanner;

public class Game
{
    Player[] players = new Player[2];
    Board board;

    private int turn = 0;
    private int boardSize = 0;
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
        boardSize = scanner.nextInt();
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

            if (y < 0 || y >= board.getSize() || x < 0 || x > board.getSize())
            {
                System.out.println("Podałeś nieprawidłowe współrzędne. Spróbuj jeszcze raz");
                continue;
            }

            if (board.getSign(y,x) != '_')
            {
                System.out.println("Nie możesz tu postawić znaku. Spróbuj jeszcze raz");
                continue;
            }

            board.setSign(y,x, player);
            board.printBoard();
            if (checkIfWin(player))
                break;
            switchPlayers();
        }

    }

    public void switchPlayers()
    {
        turn++;
        if (turn >= players.length)
            turn = 0;
    }

    int ile = 0;
    char first, second;
    boolean ifWin = false;
    public boolean checkIfWin(Player player) //sposób dla 3 znaków/ mało uniwersalny
    {
        for (int i = 0; i < boardSize - 2; i++)
        {
            for (int j = 0; j < boardSize - 2; j++)
            {
                if (board.getSign(i, j) != '_')
                {
                    //sprawdzenie w poziomie
                    if (board.getSign(i,j) == board.getSign(i,j + 1) &&  board.getSign(i, j) == board.getSign(i, j + 2) )
                    {
                        System.out.println("KONIEC GRY! WYGRYWA GRACZ " + player.getName() + " !");
                        ifWin = true;
                        return ifWin;
                    }

                    //sprawdzanie w pionie
                    if (board.getSign(i,j) == board.getSign(i + 1, j) &&  board.getSign(i,j) == board.getSign(i + 2, j ) )
                    {
                        System.out.println("KONIEC GRY! WYGRYWA GRACZ " + player.getName() + " !");
                        ifWin = true;
                        return ifWin;
                    }
                }
            }
        }
        return false;
    }

    public void initGame()
    {
        setTitleText();
        setPlayersData();
        initBoard();
        playGame();
    }


}
