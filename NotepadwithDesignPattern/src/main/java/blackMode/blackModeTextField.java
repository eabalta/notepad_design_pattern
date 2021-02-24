package blackMode;

import javax.swing.*;
import java.awt.*;

// Product olan JTextField elemanindan ConcreteProduct olan blackModeTextField elemani extend ediliyor.

public class blackModeTextField extends JTextField {

    public blackModeTextField(int column){
        super(column);
        setBackground(Color.BLACK);
        setForeground(Color.white);
    }
}
