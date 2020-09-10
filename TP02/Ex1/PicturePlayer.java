import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.Dimension;
/**
 * Write a description of class PicturePlayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PicturePlayer
{
    // instance variables - replace the example below with your own
    private BufferedImage myPicture;
    private JLabel picLabel;
    private JPanel jPanel;
    private JFrame f;
    
    private boolean frameExist = false;
    /**
     * Constructor for objects of class PicturePlayer
     */
    public PicturePlayer()
    {
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
    public void loadFrame(){
        f = new JFrame();
        f.setSize(new Dimension(900, 900));
    }
    
    public void playPicture(String picturePath)
    {
        if (!frameExist){
            loadFrame();
            frameExist = true;
        }else{
            f.remove(jPanel);
        }
        try {
            myPicture = ImageIO.read(new File(picturePath));
            picLabel = new JLabel(new ImageIcon(myPicture));
            jPanel = new JPanel();
            jPanel.add(picLabel);
            f.add(jPanel);
            f.setVisible(true);
        }
        catch(Exception e){
            System.out.print("Problème de lecture de l'image.");
        }
        }
}
