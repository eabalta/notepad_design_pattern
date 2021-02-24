package blackMode;

import javax.swing.*;
import java.awt.*;

// Product olan JButton elemanindan ConcreteProduct olan blackModeButton elemani extend ediliyor.

public class blackModeButton extends JButton {
    public blackModeButton(String name){
        super(name);
        setBackground(Color.BLACK);
        setForeground(Color.white);
    }
}
