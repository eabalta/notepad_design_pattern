package blackMode;

import javax.swing.*;
import java.awt.*;

// Product olan JTextArea elemanindan ConcreteProduct olan blackModeTextArea elemani extend ediliyor.

public class blackModeTextArea extends JTextArea {
    public blackModeTextArea(){
        setBackground(Color.DARK_GRAY);
        setForeground(Color.white);
    }
}
