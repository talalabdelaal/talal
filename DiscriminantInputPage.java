/*
Allows the input for the discriminant calculator which is then sent to the DisPage
*/
package abdelaalsteam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Talal
 */
public class DiscriminantInputPage extends JFrame implements ActionListener
{

    private final URL INST_PATH = getClass().getResource("DisInstructions.jpg");
    private final ImageIcon INST_IMAGE = new ImageIcon(new ImageIcon(INST_PATH).getImage().getScaledInstance(745, 368,
        Image.SCALE_DEFAULT));
    public static final Color SIXTH_COLOR = new Color(228, 153, 105);

    private JLabel image;
    private JLabel number1label;
    private JTextField number1field;
    private JLabel number2label;
    private JTextField number2field;
    private JLabel number3label;
    private JTextField number3field;

    //initializes JPanels and JButtons
    private JPanel discriminantPanel;
    private JPanel megaPanel;
    private JButton disCalculateButton;
    private JPanel buttonPanel;
    private JButton returnButton;
    private JButton exitButton;

    //initializes JMenu items
    private JMenu menu;
    private JMenuBar mBar;
    private JMenuItem item1;

    double answer;

    public DiscriminantInputPage()
    {
        //constructs frame
        super("Discriminant Calculator");
        this.setBounds(400, 400, 1320, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(SIXTH_COLOR);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.image = new JLabel(INST_IMAGE);

        //constructs previously initialized JLabels and textfields
        this.number1label = new JLabel("A");
        this.number1field = new JTextField(10);
        this.number2label = new JLabel("B");
        this.number2field = new JTextField(10);
        this.number3label = new JLabel("C");
        this.number3field = new JTextField(10);

        //constructs and add actionlistener to Jbuttons
        this.returnButton = new JButton("Return");
        returnButton.addActionListener(this);
        this.exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        this.disCalculateButton = new JButton("Calculate");
        disCalculateButton.addActionListener(this);
        //constucts panels
        this.discriminantPanel = new JPanel(new FlowLayout());
        this.megaPanel = new JPanel(new FlowLayout());
        this.mBar = new JMenuBar();
        //adds calculate button and both textfields to discriminant panel
        discriminantPanel.setBackground(SIXTH_COLOR);
        discriminantPanel.add(number1label);
        discriminantPanel.add(number1field);
        discriminantPanel.add(number2label);
        discriminantPanel.add(number2field);
        discriminantPanel.add(number3label);
        discriminantPanel.add(number3field);
        discriminantPanel.add(disCalculateButton);
        //adds other panel and menu bar to mega panel
        megaPanel.setBackground(SIXTH_COLOR);
        megaPanel.add(mBar, BorderLayout.WEST);
        megaPanel.add(discriminantPanel);

        //constructs input panel and adds return and exit buttons to it
        this.buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(returnButton);
        buttonPanel.add(exitButton);

        //constructs and initializes JMenu and JMenuBar
        menu = new JMenu("Menu");
        item1 = new JMenuItem("Help");
        item1.addActionListener(this);
        menu.add(item1);
        mBar.add(menu);

        //adds all relevant panels to the Frame as well as the image
        this.add(megaPanel, BorderLayout.NORTH);
        this.add(image, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        //constructs the initial page of the page
        new DiscriminantInputPage();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //initializing temp objects
        Object command = e.getSource();
        double number1;
        double number2;
        double number3;
        double number4;
        double number5;
        double number6;
        double number7;
        String message;

        //exits program, returns to previous page or calculates
        if (command == exitButton)
        {
            System.exit(0);
        }
        else if (command == returnButton)
        {
            this.dispose();
            new WelcomePage();
        }
        else if (command == disCalculateButton)
        {
            try
            {
                number1 = Double.parseDouble(number1field.getText());
                number2 = Double.parseDouble(number2field.getText());
                number3 = Double.parseDouble(number3field.getText());
                DisPage disObj = new DisPage(number1, number2, number3);
                message = "The discriminant is " + disObj.resultCalc() + " and " + disObj.getResult();
                this.dispose();

                new DisOutput(message);
            }

            catch (NumberFormatException nfe)
            {
                new WarningPage("Invalid Entry! Please enter a number");
            }
            catch (Exception exc)
            {
                new WarningPage("Unexpected error. Please Restart!");
            }
            this.validate();
            this.repaint();

        }
        else if (command == item1)
        {
            this.dispose();
            new HelpPage();
        }

    }
}
