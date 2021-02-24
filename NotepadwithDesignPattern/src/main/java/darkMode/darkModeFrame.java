package darkMode;

import javax.swing.*;
import java.awt.*;

// Product olan JFrame elemanindan ConcreteProduct olan darkModeFrame elemani extend ediliyor.

public class darkModeFrame extends JFrame {

    public darkModeFrame(String name){
        super(name);
        setBackground(Color.DARK_GRAY);

    }
}
