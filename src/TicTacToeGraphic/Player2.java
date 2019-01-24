package TicTacToeGraphic;

import javax.swing.*;
import java.awt.*;

public class Player2
{
    private String name;
    private ImageIcon sign;

    public Player2(String name, ImageIcon sign)
    {
        this.name = name;
        this.sign = sign;
    }

    public String getName()
    {
        return name;
    }
    public ImageIcon getSign()
    {
        return sign;
    }
}
