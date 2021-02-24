package darkMode;

import javax.swing.*;
import java.awt.*;

// Product olan JTextField elemanindan ConcreteProduct olan darkModeTextField elemani extend ediliyor.

public class darkModeTextField extends JTextField {

    public darkModeTextField(int column){
        super(column);
        setBackground(Color.DARK_GRAY);
        setForeground(Color.white);
    }
}
