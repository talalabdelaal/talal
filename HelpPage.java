/*
displays the help page accesed from the menu
 */
package abdelaalsteam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelpPage extends JFrame implements ActionListener
{

    //initializes private instance variables
    public static final Color FOURTH_COLOR = new Color(141, 182, 199);
    public static final Font SUPER_SIZE = new Font("Bembo",
        Font.BOLD, 20);
    private final URL EXP_PATH = getClass().getResource("example.jpg");
    private final ImageIcon EXP_IMAGE = new ImageIcon(new ImageIcon(EXP_PATH).getImage().getScaledInstance(700, 393,
        Image.SCALE_DEFAULT));
    //Declaring JLabel
    private JLabel message;
    private JLabel pic;
    //declaring JPanel
    private JPanel buttonPanel;
    private JPanel textPanel;
    //declaring JButtons
    private JButton back;
    private JButton exit;

    public HelpPage()
    {
        //intializes the Frame
        super("Help");//calling the constructor superclass (JFrame)
        this.setBounds(400, 400, 1700, 700); //size and placement
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(FOURTH_COLOR);
        this.setLayout(new BorderLayout());

        // constructing JLabel
        this.message = new JLabel("Please use the example below to navigate the discriminant calculator. For the slope calculator, p"
            + "lease enter the two points in this order: X1, X2, Y1, Y2");
        message.setFont(SUPER_SIZE);
        message.setForeground(Color.WHITE);
        this.pic = new JLabel(EXP_IMAGE);

        //constructing button
        this.back = new JButton("Return");
        back.addActionListener(this);
        this.exit = new JButton("Exit");
        exit.addActionListener(this);
        this.buttonPanel = new JPanel(new FlowLayout());
        this.textPanel = new JPanel(new FlowLayout());

        //adding button to panel
        buttonPanel.add(back);
        buttonPanel.add(exit);

        //displays messages in given locations and set visible
        this.add(message, BorderLayout.NORTH);
        this.add(pic, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        //constructs new obj
        HelpPage objName = new HelpPage();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //allows the frame to be closed or continue to the Input Frame
        String command = e.getActionCommand();
        if (command.equals("Return"))
        {
            this.dispose();
            new WelcomePage();
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
