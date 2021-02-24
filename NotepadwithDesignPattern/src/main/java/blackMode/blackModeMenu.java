package blackMode;

import javax.swing.*;
import java.awt.*;

// Product olan JMenu elemanindan ConcreteProduct olan blackModeMenu elemani extend ediliyor.


public class blackModeMenu extends JMenu {
    public blackModeMenu(String name){
        super(name);
        setBackground(Color.BLACK);
        setForeground(Color.white);
    }
}
