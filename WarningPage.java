//this serves as a warning page for missing or lettered wording in textfields meant for numbers
package abdelaalsteam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class WarningPage extends JFrame
{

    //initializes private variables
    private JLabel messageLabel;
    private JLabel pic;

    private final URL WARN_PATH = getClass().getResource("really.jpg");
    private final ImageIcon WARN_IMAGE = new ImageIcon(new ImageIcon(WARN_PATH).getImage().getScaledInstance(500, 440,
        Image.SCALE_DEFAULT));

    public WarningPage(String message)
    {
        //construct the frame
        super("Warning");
        this.setBounds(200, 200, 900, 500);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Color.red);
        this.setLayout(new BorderLayout());

        //display a message on JLabel
        this.messageLabel = new JLabel(message, SwingConstants.CENTER);//Swing center the message
        messageLabel.setFont(WelcomePage.SUPER_SIZE);

        //initializing photo
        this.pic = new JLabel(WARN_IMAGE);

        //add to frame
        this.add(messageLabel, BorderLayout.NORTH);
        this.add(pic, BorderLayout.CENTER);
        this.setVisible(true);

    }

    public static void main(String[] args)
    {
        new WarningPage("BRO! What are you doing?!");
    }

}
