public class Board
{
    private int boardSize;
    private char[][] board;

    public Board(int boardSize)
    {
        this.boardSize = boardSize;
        this.board = new char[boardSize][boardSize];

        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                board[i][j] = '_';
            }
        }
    }



    public void printBoard()
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                System.out.print(board[i][j] + "\t");

                if (j == board.length - 1)
                    System.out.println();
            }
        }
        System.out.println();
    }

    public void setSign(int y, int x, Player player)
    {
        if (y < board.length && x < board[0].length)
        {
            board[y][x] = player.getSign();
        }
        else
        {
            System.out.println("Niepoprawne koordynaty");
        }

    }
}