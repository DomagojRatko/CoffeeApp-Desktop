import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

public class Image extends Main {
    public void image() throws MalformedURLException {
        URL url = new URL(gif);
        Icon icon = new ImageIcon(url);
        JLabel label = new JLabel(icon);
        JFrame f = new JFrame();
        f.getContentPane().add(label);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setUndecorated(true);
        f.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.0f));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        Image.FrameDragListener frameDragListener = new Image.FrameDragListener(f);
        f.addMouseListener(frameDragListener);
        f.addMouseMotionListener(frameDragListener);
    }
    public class FrameDragListener extends MouseAdapter {
        private final JFrame frame;
        private Point mouseDownCompCoords = null;
        public FrameDragListener(JFrame frame) {
            this.frame = frame;
        }
        public void mouseReleased(MouseEvent e) {
            mouseDownCompCoords = null;
        }
        public void mousePressed(MouseEvent e) {
            mouseDownCompCoords = e.getPoint();
        }
        public void mouseDragged(MouseEvent e) {
            Point currCoords = e.getLocationOnScreen();
            frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
        }
    }
}
