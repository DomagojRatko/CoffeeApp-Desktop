import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
public class Main {
    public static void main(String[] args) throws MalformedURLException {
            URL url = new URL("https://i.pinimg.com/originals/48/70/fc/4870fcf2f864097100be062ee53c9911.gif");
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
            FrameDragListener frameDragListener = new FrameDragListener(f);
            f.addMouseListener(frameDragListener);
            f.addMouseMotionListener(frameDragListener);
    }
        public static class FrameDragListener extends MouseAdapter {
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
