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

        Button addGIF = new Button("OK",190,53,50,20,11);
        addGIF.getButton().addActionListener(e -> {
            try {
                new Image(textField.getText());
            } catch (MalformedURLException malformedURLException) {
                malformedURLException.printStackTrace();
            }
        });

        Button minimize = new Button("-",150,3,40,20,15);
        minimize.getButton().addActionListener(e -> {
            frame.setState(JFrame.ICONIFIED);
        });

        Button exit = new Button("x",200,3,40,20,11);
        exit.getButton().addActionListener(e -> {
            System.exit(0);
        });

        FrameDragListener frameDragListener = new FrameDragListener(frame);
        frame.addMouseListener(frameDragListener);
        frame.addMouseMotionListener(frameDragListener);

        frame.add(addGIF.getButton());
        frame.add(minimize.getButton());
        frame.add(exit.getButton());
        frame.add(label);
        frame.add(textField);
        frame.setVisible(true);
    }
}
