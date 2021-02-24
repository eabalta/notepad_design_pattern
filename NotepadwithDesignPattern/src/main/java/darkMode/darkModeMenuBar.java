package darkMode;

import javax.swing.*;
import java.awt.*;

// Product olan JMenuBar elemanindan ConcreteProduct olan darkModeMenuBar elemani extend ediliyor.

public class darkModeMenuBar extends JMenuBar {
    public darkModeMenuBar(){
        setBackground(Color.DARK_GRAY);
    }
}
