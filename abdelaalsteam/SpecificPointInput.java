/*
Allows the calculation of a specific point along the line's slope(which was previously calculated) then send the information to either NewXPage or NewYPage
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SpecificPointInput extends JFrame implements ActionListener
{

    public static final Font BEST_SIZE = new Font("Bembo",
        Font.BOLD, 36);
    public static final Color FOURTH_COLOR = new Color(30, 80, 150);

    private final URL PS_PATH = getClass().getResource("pointslope.jpg");
    private final ImageIcon PS_IMAGE = new ImageIcon(new ImageIcon(PS_PATH).getImage().getScaledInstance(626, 341,
        Image.SCALE_DEFAULT));

    //initializes JLabels and relevant JTextFields
    private JLabel image;
    private JLabel number1label;
    private JTextField number1field;
    private JLabel number2label;
    private JTextField number2field;

    //initializes JPanels and JButtons
    private JPanel inputPanel;
    private JButton calculateXButton;
    private JButton calculateYButton;
    private JPanel buttonPanel;
    private JButton returnButton;
    private JButton exitButton;

    private double gNumber1, gNumber2, gNumber3;

    public SpecificPointInput(double pNumber1, double pNumber2, double pNumber3)
    {
        //constructs frame
        super("Specific Point on a Line");
        gNumber1 = pNumber1;
        gNumber2 = pNumber2;
        gNumber3 = pNumber3;
        this.setBounds(400, 400, 1320, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(FOURTH_COLOR);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.image = new JLabel(PS_IMAGE);

        //constructs previously initialized JLabels and textfields
        this.number1label = new JLabel("X");
        this.number1field = new JTextField(10);
        number1label.setForeground(Color.PINK);
        this.number2label = new JLabel("Y");
        this.number2field = new JTextField(10);
        number2label.setForeground(Color.PINK);

        //constructs and add actionlistener to Jbuttons
        this.returnButton = new JButton("Return");
        returnButton.addActionListener(this);
        this.exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        this.calculateXButton = new JButton("Calculate");
        calculateXButton.addActionListener(this);
        this.calculateYButton = new JButton("Calculate");
        calculateYButton.addActionListener(this);

        //constucts panels
        this.inputPanel = new JPanel(new FlowLayout());

        //adds calculate button and both textfields to slope panel
        inputPanel.setBackground(FOURTH_COLOR);
        inputPanel.add(number1label);
        inputPanel.add(number1field);
        inputPanel.add(calculateXButton);
        inputPanel.add(number2label);
        inputPanel.add(number2field);
        inputPanel.add(calculateYButton);

        //constructs input panel and adds return and exit buttons to it
        this.buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(returnButton);
        buttonPanel.add(exitButton);

        //adds all relevant panels to the Frame as well as the image
        this.add(inputPanel, BorderLayout.NORTH);
        this.add(image, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        //constructs the initial page of the page
        new SpecificPointInput(1, 2, 3);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //initializing temp objects
        Object command = e.getSource();
        double number1;
        double number2;
        String message;
        double answer;

        //exits program, returns to previous page or calculates
        if (command == exitButton)
        {
            System.exit(0);
        }
        else if (command == returnButton)
        {
            this.dispose();
            new InputPage();
        }
        else if (command == calculateXButton)
        {
            try
            {
                number1 = Double.parseDouble(number1field.getText());
                NewXPage newSlopeX = new NewXPage(number1, gNumber1, gNumber2, gNumber3);
                answer = newSlopeX.getResult();
                message = "The corresponding Y is " + answer + " and the point on the graph is (" + number1 + ", " + answer + ").";
                this.dispose();
                new SpecificPointOutput(message, gNumber1, gNumber2, gNumber3);

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
        else if (command == calculateYButton)
        {
            try
            {
                number2 = Double.parseDouble(number2field.getText());
                NewYPage newSlopeY = new NewYPage(number2, gNumber1, gNumber2, gNumber3);
                answer = newSlopeY.getResult();
                message = "The corresponding X is " + answer + " and the point on the graph is (" + answer + ", " + number2 + ").";
                this.dispose();
                new SpecificPointOutput(message, gNumber1, gNumber2, gNumber3);
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
    }
}
