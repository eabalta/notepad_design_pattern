package darkMode;

import javax.swing.*;
import java.awt.*;

// Product olan JLabel elemanindan ConcreteProduct olan darkModeLabel elemani extend ediliyor.

public class darkModeLabel extends JLabel {
    public darkModeLabel(String name){
        super(name);
        setBackground(Color.DARK_GRAY);
        setForeground(Color.white);
    }
}
