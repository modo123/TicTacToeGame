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
    }

    
}
