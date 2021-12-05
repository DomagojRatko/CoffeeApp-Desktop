import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;

public class Main {
    public static String gif;
    private JButton button;
    private JTextField tf;
    private JFrame f = new JFrame();

    private void frame(){
            f.setSize(250,80);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setUndecorated(true);
            f.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.5f));
            f.setLocationRelativeTo(null);
            f.setLayout(null);
            button = new JButton("OK");
            button.setBounds(190,50,50,20);
            button.setFont(new Font("BOLD",1,8));
            button.setBackground(Color.DARK_GRAY);
            button.setForeground(Color.WHITE);
            tf = new JTextField();
            tf.setBounds(10,25,230,20);
            tf.setBackground(Color.DARK_GRAY);
            tf.setForeground(Color.WHITE);
            JLabel l = new JLabel("Insert link");
            l.setForeground(Color.WHITE);
            l.setBounds(10,2,80,25);
            f.add(l);
            f.add(tf);
            f.add(button);
            f.setVisible(true);
    }

    public static void main(String[] args) throws MalformedURLException {
           Image img = new Image();
           Main main = new Main();
           main.frame();
           main.button.addActionListener(e -> {
                   try {
                           main.gif = main.tf.getText();
                           img.image();
                           main.f.dispose();
                   } catch (MalformedURLException malformedURLException) {
                           malformedURLException.printStackTrace();
                   }
           });
    }
}
