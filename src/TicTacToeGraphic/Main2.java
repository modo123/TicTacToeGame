package TicTacToeGraphic;

import java.awt.*;

public class Main2
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new MainFrame2();
            }
        });
    }
}
