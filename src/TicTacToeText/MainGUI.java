package TicTacToeText;

import TicTacToeText.BoardGUI;

import java.awt.*;

public class MainGUI
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new BoardGUI();
            }
        });
    }
}
