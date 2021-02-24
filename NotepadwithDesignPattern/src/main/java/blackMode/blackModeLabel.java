package blackMode;

import javax.swing.*;
import java.awt.*;

// Product olan JLabel elemanindan ConcreteProduct olan blackModeLabel elemani extend ediliyor.


public class blackModeLabel extends JLabel {
    public blackModeLabel(String name){
        super(name);
        setBackground(Color.BLACK);
        setForeground(Color.white);
    }
}
