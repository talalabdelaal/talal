/*
Displays the corresponding x or y
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

public class SpecificPointOutput extends JFrame implements ActionListener
{

    public static final Font BEST_SIZE = new Font("Bembo",
        Font.BOLD, 36);
    public static final Color NICE_COLOR = new Color(159, 163, 227);
    private final URL LINE_PATH = getClass().getResource("line_graph.jpg");
    private final ImageIcon LINE_IMAGE = new ImageIcon(new ImageIcon(LINE_PATH).getImage().getScaledInstance(800, 566,
        Image.SCALE_DEFAULT));

    //Declaring JLabel, JButton, and JPanel
    private JLabel outputLabel;
    private JLabel pic;
    private JButton exitButton;
    private JPanel buttonPanel;
    private JButton returnButton;

    private double gNumber1, gNumber2, gNumber3;

    public SpecificPointOutput(String message, double pNumber1, double pNumber2, double pNumber3)
    {
        //intializes the Frame
        super("Corresponding Coordinate");//calling the constructor superclass (JFrame)
        gNumber1 = pNumber1;
        gNumber2 = pNumber2;
        gNumber3 = pNumber3;
        this.setBounds(450, 450, 1400, 800); //size and placement
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(NICE_COLOR);
        this.setLayout(new BorderLayout());

        // constructing JLabel
        this.outputLabel = new JLabel(message);
        outputLabel.setForeground(Color.CYAN);
        this.pic = new JLabel(LINE_IMAGE);
        outputLabel.setFont(BEST_SIZE);

        //displays message in the center
        this.add(outputLabel, BorderLayout.CENTER);
        this.add(pic, BorderLayout.CENTER);
        this.setVisible(true);

        //exit program
        this.exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        this.returnButton = new JButton("Return");
        returnButton.addActionListener(this);
        this.buttonPanel = new JPanel(new FlowLayout());
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
        new SpecificPointOutput("You shouldn't be here!", 1, 2, 3);
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
            new SpecificPointInput(gNumber1, gNumber2, gNumber3);
        }
        this.validate();
        this.repaint();
    }
}
