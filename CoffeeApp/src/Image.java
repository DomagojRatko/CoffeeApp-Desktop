import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Image {

    private final String gifURL;

    public Image(String gifURL) throws MalformedURLException {
        this.gifURL = gifURL;
        image();
    }

    public void image() throws MalformedURLException {
        URL url = new URL(gifURL);

        Icon icon = new ImageIcon(url);

        JLabel label = new JLabel(icon);
        
        JFrame frame = new JFrame();
        frame.getContentPane().add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.0f));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        FrameDragListener frameDragListener = new FrameDragListener(frame);
        frame.addMouseListener(frameDragListener);
        frame.addMouseMotionListener(frameDragListener);
    }
}
