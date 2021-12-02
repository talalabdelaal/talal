/*
Allows input for slope then send the input to SlopePage
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

public class InputPage extends JFrame implements ActionListener
{

    private final URL TEMP_PATH = getClass().getResource("template.jpg");
    private final ImageIcon TEMP_IMAGE = new ImageIcon(new ImageIcon(TEMP_PATH).getImage().getScaledInstance(1200, 630,
        Image.SCALE_DEFAULT));
    public static final Color SECOND_COLOR = new Color(202, 159, 146);

    //initializes JLabels and relevant JTextFields
    private JLabel image;
    private JLabel number1label;
    private JTextField number1field;
    private JLabel number2label;
    private JTextField number2field;
    private JLabel number3label;
    private JTextField number3field;
    private JLabel number4label;
    private JTextField number4field;

    //initializes JPanels and JButtons
    private JPanel slopePanel;
    private JPanel megaPanel;
    private JButton calculateButton;
    private JPanel buttonPanel;
    private JButton returnButton;
    private JButton exitButton;

    //initializes JMenu items
    private JMenu menu;
    private JMenuBar mBar;
    private JMenuItem item1;

    public InputPage()
    {
        //constructs frame
        super("Slope Calculator");
        this.setBounds(400, 400, 1320, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(SECOND_COLOR);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.image = new JLabel(TEMP_IMAGE);

        //constructs previously initialized JLabels and textfields
        this.number1label = new JLabel("X1");
        this.number1field = new JTextField(10);
        this.number2label = new JLabel("X2");
        this.number2field = new JTextField(10);
        this.number3label = new JLabel("Y1");
        this.number3field = new JTextField(10);
        this.number4label = new JLabel("Y2");
        this.number4field = new JTextField(10);

        //constructs and add actionlistener to Jbuttons
        this.returnButton = new JButton("Return");
        returnButton.addActionListener(this);
        this.exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        this.calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);

        //constucts panels
        this.slopePanel = new JPanel(new FlowLayout());
        this.megaPanel = new JPanel(new FlowLayout());
        this.mBar = new JMenuBar();
        //adds calculate button and both textfields to slope panel
        slopePanel.setBackground(SECOND_COLOR);
        slopePanel.add(number1label);
        slopePanel.add(number1field);
        slopePanel.add(number2label);
        slopePanel.add(number2field);
        slopePanel.add(number3label);
        slopePanel.add(number3field);
        slopePanel.add(number4label);
        slopePanel.add(number4field);
        slopePanel.add(calculateButton);

        //adds other panels to mega panel
        megaPanel.setBackground(SECOND_COLOR);
        megaPanel.add(mBar, BorderLayout.WEST);
        megaPanel.add(slopePanel);

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
        new InputPage();
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
        double answer;
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
        else if (command == calculateButton)
        {
            try
            {
                number1 = Double.parseDouble(number1field.getText());
                number2 = Double.parseDouble(number2field.getText());
                number3 = Double.parseDouble(number3field.getText());
                number4 = Double.parseDouble(number4field.getText());
                SlopePage slopeObj = new SlopePage(number1, number2, number3, number4);
                answer = slopeObj.resultCalc();
                message = "The slope of point (" + slopeObj.getX1() + ", " + slopeObj.getY1() + ") and point (" + slopeObj.getX2() + ", " + slopeObj.getY2() + ") is " + answer;
                this.dispose();
                new SlopeOutput(message, answer, number1, number3);

            }

            catch (NumberFormatException nfe)
            {
                new WarningPage("Invalid Entry! Please enter a number");
            }
            catch (Exception exc)
            {
                new WarningPage("Unexpected error. Please Restart!");
            }
        }

        else if (command == item1)
        {
            this.dispose();
            new HelpPage();
        }

    }
}
