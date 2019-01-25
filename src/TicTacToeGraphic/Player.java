package TicTacToeGraphic;

import javax.swing.*;
import java.awt.*;

public class Player
{
    private String name;
    private ImageIcon sign;

    public Player(String name, ImageIcon sign)
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
