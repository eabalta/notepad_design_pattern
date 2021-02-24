package darkMode;

import javax.swing.*;
import java.awt.*;

// Product olan JMenu elemanindan ConcreteProduct olan darkModeMenu elemani extend ediliyor.

public class darkModeMenu extends JMenu {
    public darkModeMenu(String name){
        super(name);
        setBackground(Color.DARK_GRAY);
        setForeground(Color.white);
    }
}
