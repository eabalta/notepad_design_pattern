package darkMode;

import javax.swing.*;
import java.awt.*;

// Product olan JButton elemanindan ConcreteProduct olan darkModeButton elemani extend ediliyor.


public class darkModeButton extends JButton {
    public darkModeButton(String name){
        super(name);
        setBackground(Color.DARK_GRAY);
        setForeground(Color.white);
    }
}
