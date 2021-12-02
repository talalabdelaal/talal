/*
Displays the output for discriminant calculator with the appropriate photo
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

public class DisOutput extends JFrame implements ActionListener
{

    public static final Font BEST_SIZE = new Font("Bembo",
        Font.BOLD, 36);
    public static final Color THIRD_COLOR = new Color(249, 205, 151);
    private final URL DIS_PATH = getClass().getResource("TheDiscriminantNotes.jpg");
    private final ImageIcon DIS_IMAGE = new ImageIcon(new ImageIcon(DIS_PATH).getImage().getScaledInstance(500, 371,
        Image.SCALE_DEFAULT));

    //Declaring JLabel, JButton, and JPanel
    private JLabel outputLabel;
    private JLabel pic;
    private JButton exitButton;
    private JPanel buttonPanel;
    private JButton returnButton;

    public DisOutput(String message)
    {
        //intializes the Frame
        super("Discriminant Result");//calling the constructor superclass (JFrame)
        this.setBounds(450, 450, 1000, 500); //size and placement
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(THIRD_COLOR);
        this.setLayout(new BorderLayout());

        // constructing JLabel
        this.outputLabel = new JLabel(message);
        outputLabel.setForeground(Color.PINK);
        this.pic = new JLabel(DIS_IMAGE);
        outputLabel.setFont(BEST_SIZE);
        this.returnButton = new JButton("Return");
        returnButton.addActionListener(this);

        //displays message in the center
        this.add(outputLabel, BorderLayout.CENTER);
        this.add(pic, BorderLayout.CENTER);
        this.setVisible(true);

        //exit program
        this.returnButton = new JButton("Return");
        returnButton.addActionListener(this);
        this.exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
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
        new DisOutput("You shouldn't be here!");
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
            new DiscriminantInputPage();
        }
        this.validate();
        this.repaint();
    }
}
