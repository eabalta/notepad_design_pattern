package darkMode;

import javax.swing.*;
import java.awt.*;

// Product olan JMenuItem elemanindan ConcreteProduct olan darkModeMenuItem elemani extend ediliyor.

public class darkModeMenuItem extends JMenuItem {
    public darkModeMenuItem(String name){
        super(name);
        setBackground(Color.DARK_GRAY);
        setForeground(Color.white);
    }
}
