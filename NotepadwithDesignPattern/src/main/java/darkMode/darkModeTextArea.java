package darkMode;

import javax.swing.*;
import java.awt.*;

// Product olan JTextArea elemanindan ConcreteProduct olan darkModeTextArea elemani extend ediliyor.

public class darkModeTextArea extends JTextArea {
    public darkModeTextArea(){
        setBackground(Color.GRAY);
    }
}
