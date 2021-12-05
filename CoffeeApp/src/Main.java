import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.frame();
    }

    private void frame(){
        JFrame frame = new JFrame();
        frame.setSize(250,80);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.5f));
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JTextField textField = new JTextField();
        textField.setBounds(10,28,230,20);
        textField.setBackground(Color.DARK_GRAY);
        textField.setForeground(Color.WHITE);

        JLabel label = new JLabel("Insert link");
        label.setForeground(Color.WHITE);
        label.setBounds(10,3,80,25);

        JButton addGIF = new JButton("OK");
        addGIF.setBounds(190,53,50,20);
        addGIF.setFont(new Font("Arial", Font.BOLD,11));
        addGIF.setBackground(Color.DARK_GRAY);
        addGIF.setForeground(Color.WHITE);
        addGIF.addActionListener(e -> {
            try {
                new Image(textField.getText());
            } catch (MalformedURLException malformedURLException) {
                malformedURLException.printStackTrace();
            }
        });

        JButton minimize = new JButton("-");
        minimize.setBounds(150,3,40,20);
        minimize.setFont(new Font("Arial", Font.BOLD,15));
        minimize.setBackground(Color.DARK_GRAY);
        minimize.setForeground(Color.WHITE);
        minimize.addActionListener(e -> {
            frame.setState(JFrame.ICONIFIED);
        });

        JButton exit = new JButton("X");
        exit.setBounds(200,3,40,20);
        exit.setFont(new Font("Arial", Font.BOLD,9));
        exit.setBackground(Color.DARK_GRAY);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(e -> {
            System.exit(0);
        });

        FrameDragListener frameDragListener = new FrameDragListener(frame);
        frame.addMouseListener(frameDragListener);
        frame.addMouseMotionListener(frameDragListener);

        frame.add(minimize);
        frame.add(exit);
        frame.add(label);
        frame.add(addGIF);
        frame.add(textField);
        frame.setVisible(true);
    }
}
