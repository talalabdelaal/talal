/*
Talal Abdel Aal
3/7/2021
This program will find the slope when given two points on a graph and will calculate the discriminant
telling the user whether the discriminant is greater than, less than, or equal to zero and their corresponding solutions
 */
package abdelaalsteam;

import com.sun.xml.internal.messaging.saaj.soap.MessageImpl;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomePage extends JFrame implements ActionListener
{

    public static final Color FIRST_COLOR = new Color(81, 192, 191);
    public static final Font SUPER_SIZE = new Font("Bembo",
        Font.BOLD, 30);
    public static final Font NORMAL_SIZE = new Font("Bembo",
        Font.PLAIN, 25);
    private final URL DISC_PATH = getClass().getResource("Discriminant.jpg");
    private final ImageIcon DISC_IMAGE = new ImageIcon(new ImageIcon(DISC_PATH).getImage().getScaledInstance(1500, 298,
        Image.SCALE_DEFAULT));
    //Declaring JLabel
    private JLabel title;
    private JLabel name;
    private JLabel message;
    private JLabel pic;
    //declaring JPanel
    private JPanel buttonPanel;
    private JPanel textPanel;
    //declaring JButtons
    private JButton inputSlope;
    private JButton inputDis;
    private JButton exit;

    public WelcomePage()
    {
        //intializes the Frame
        super("Binomial Finder");//calling the constructor superclass (JFrame)
        this.setBounds(400, 400, 1700, 700); //size and placement
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(FIRST_COLOR);
        this.setLayout(new BorderLayout());

        // constructing JLabel
        this.title = new JLabel("Slope and Discriminant Calaculator ");
        this.message = new JLabel("This program calculates the slope and discriminant when given two different points and/or a binomial");
        this.name = new JLabel(" By: Talal Abdel Aal");
        title.setFont(SUPER_SIZE);
        message.setFont(NORMAL_SIZE);
        name.setFont(NORMAL_SIZE);
        title.setForeground(Color.GRAY);
        message.setForeground(Color.darkGray);
        name.setForeground(Color.darkGray);
        this.pic = new JLabel(DISC_IMAGE);

        //constructing button
        this.inputSlope = new JButton("Slope Calculator");
        inputSlope.addActionListener(this);
        this.inputDis = new JButton("Discriminant Calculator");
        inputDis.addActionListener(this);
        this.exit = new JButton("Exit");
        exit.addActionListener(this);
        this.buttonPanel = new JPanel(new FlowLayout());
        this.textPanel = new JPanel(new FlowLayout());

        //adding buttons to panels
        buttonPanel.add(inputSlope);
        buttonPanel.add(inputDis);
        buttonPanel.add(exit);
        textPanel.add(title, BorderLayout.NORTH);
        textPanel.add(message, BorderLayout.CENTER);
        textPanel.add(name, BorderLayout.SOUTH);
        textPanel.setBackground(FIRST_COLOR);

        //displays messages in given locations and set visible
        this.add(textPanel, BorderLayout.NORTH);
        this.add(pic, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        //constructs new obj for testing
        WelcomePage objName = new WelcomePage();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //allows the frame to be closed or continue to the Input Frame
        String command = e.getActionCommand();
        if (command.equals("Slope Calculator"))
        {
            this.dispose();
            new InputPage();
        }
        else if (command.equals("Discriminant Calculator"))
        {
            this.dispose();
            new DiscriminantInputPage();
        }
        else if (command.equals("Exit"))
        {
            System.exit(0);
        }
        //checks the OOP for errors
        this.validate();
        this.repaint();
    }
}
