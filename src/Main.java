import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj imię gracza 1");
        String name = scanner.next();
        System.out.println("Podaj znak gracza 1");
        char sign = scanner.next().charAt(0);

        Player player1 = new Player(name, sign);

        System.out.println("Podaj imię gracza 2");
        String name2 = scanner.next();
        System.out.println("Podaj znak gracza 2");
        char sign2 = scanner.next().charAt(0);

        Player player2 = new Player(name2, sign2);

        System.out.println("Podaj rozmiar planszy");
        int boardSize = scanner.nextInt();

        Board board = new Board(boardSize);
        board.printBoard();
    }
}
