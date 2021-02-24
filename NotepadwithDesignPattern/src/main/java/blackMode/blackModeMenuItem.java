package blackMode;

import javax.swing.*;
import java.awt.*;

// Product olan JMenuItem elemanindan ConcreteProduct olan blackModeMenuItem elemani extend ediliyor.


public class blackModeMenuItem extends JMenuItem {
    public blackModeMenuItem(String name){
        super(name);
        setBackground(Color.BLACK);
        setForeground(Color.white);
    }
}
