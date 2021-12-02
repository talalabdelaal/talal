/*
outputs slope results with appropriate picture then continues to SpecificPointInput
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
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class SlopeOutput extends JFrame implements ActionListener
{

    public static final Font BEST_SIZE = new Font("Bembo",
        Font.BOLD, 36);
    public static final Color NICE_COLOR = new Color(245, 173, 148);
    private final URL SLOPE_PATH = getClass().getResource("Slope.jpg");
    private final ImageIcon SLOPE_IMAGE = new ImageIcon(new ImageIcon(SLOPE_PATH).getImage().getScaledInstance(400, 173,
        Image.SCALE_DEFAULT));

    //Declaring JLabel, JButton, and JPanel
    private JLabel outputLabel;
    private JLabel pic;
    private JButton continueButton;
    private JButton exitButton;
    private JPanel buttonPanel;
    private JButton returnButton;
    private double gNumber1, gNumber2, gNumber3;

    public SlopeOutput(String message, double pNumber1, double pNumber2, double pNumber3)
    {
        //intializes the Frame
        super("Slope Result");//calling the constructor superclass (JFrame)
        gNumber1 = pNumber1;
        gNumber2 = pNumber2;
        gNumber3 = pNumber3;
        this.setBounds(450, 450, 1000, 500); //size and placement
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(NICE_COLOR);
        this.setLayout(new BorderLayout());

        // constructing JLabel
        this.outputLabel = new JLabel(message);
        outputLabel.setForeground(Color.CYAN);
        this.pic = new JLabel(SLOPE_IMAGE);
        outputLabel.setFont(BEST_SIZE);

        //displays message in the center
        this.add(outputLabel, BorderLayout.CENTER);
        this.add(pic, BorderLayout.CENTER);
        this.setVisible(true);

        //exit program
        this.continueButton = new JButton("Contine");
        continueButton.addActionListener(this);
        this.exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        this.returnButton = new JButton("Return");
        returnButton.addActionListener(this);
        this.buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(continueButton);
        buttonPanel.add(returnButton);
        buttonPanel.add(exitButton);

        //add to panel
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(outputLabel, BorderLayout.NORTH);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        //contructs page
        new SlopeOutput("You shouldn't be here!", 1, 2, 3);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //returns to previous page or closes program
        Object command = e.getSource();
        if (command == exitButton)
        {
            System.exit(0);
        }
        else if (command == returnButton)
        {
            this.dispose();
            new InputPage();
        }
        else if (command == continueButton)
        {
            this.dispose();
            new SpecificPointInput(gNumber1, gNumber2, gNumber3);
        }
        this.validate();
        this.repaint();
    }
}
