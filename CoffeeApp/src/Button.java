import javax.swing.*;
import java.awt.*;

public class Button {
    private JButton button;
    public Button(String text, int x, int y, int width, int height, int fSize){
        this.button = new JButton(text);
        button.setBounds(x,y,width,height);
        button.setFont(new Font("Arial", Font.BOLD,fSize));
        button.setBackground(Color.DARK_GRAY);
        button.setForeground(Color.WHITE);
    }
    public JButton getButton() {
        return button;
    }
}
