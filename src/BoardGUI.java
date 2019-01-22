import javax.imageio.ImageIO;
import javax.management.modelmbean.InvalidTargetObjectTypeException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class BoardGUI extends JFrame
{
    private Container contents;
    private static final int BOARD_SIZE = 3;
    private JButton[][] squares = new JButton[BOARD_SIZE][BOARD_SIZE];
    private ButtonHandler buttonHandler;
    private ImageIcon oIcon = new ImageIcon("O.png");
    private ImageIcon xIcon = new ImageIcon("X.png");


    public BoardGUI()
    {
        super("TicTacToe");
        contents = getContentPane();
        contents.setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,800);
        //setLayout(new GridLayout(BOARD_SIZE,BOARD_SIZE));
        setLocationRelativeTo(null);
        buttonHandler = new ButtonHandler();

        for (int i = 0; i < squares.length; i++)
        {
            for (int j = 0; j < squares[i].length; j++)
            {
                squares[i][j] = new JButton();
                //contents.add(squares[i][j]);
                add(squares[i][j]);
                squares[i][j].setBackground(Color.white);
                squares[i][j].addActionListener(buttonHandler);
            }
        }

        setVisible(true);
    }


    class ButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Object source = e.getSource();

            for (int i = 0; i < squares.length; i++)
            {
                for (int j = 0; j < squares[i].length; j++)
                {
                    if (source == squares[i][j])
                    {
                        squares[i][j].setIcon(xIcon);
//                        {
//                            squares[i][j].setBackground(Color.blue);
//                        }
//                        else
//                        {
//                            squares[i][j].setBackground(Color.green);
//                        }
                    }
                }
            }
        }
    }

}



