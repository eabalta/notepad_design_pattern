package stockTheme;

import notepad.Notepad;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//DosyaInterface içerisindeki işlem
//Dosya kaydetme işlemine göre yazıldı.
public class DosyaKaydet implements DosyaInterface {
    private static DosyaKaydet instance;
    File currentFile = DosyaAc.currentFile;
    public static Notepad notepad = Notepad.getInstance();

    public static DosyaKaydet getInstance(){
        if (instance == null){
            instance = new DosyaKaydet();
        }
        return instance;
    }

    @Override
    public void dosyaİslemi() {
        if(DosyaAc.currentFile != null){
            try {
                File file = new File(currentFile.getAbsolutePath());
                DosyaAc.currentFile = file;
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter w = new BufferedWriter(fileWriter);
                w.write(notepad.getTextArea().getText());
                w.flush();
                w.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "File Not Found!");
            }
        }
        else {
            JFileChooser j = new JFileChooser();
            int r = j.showSaveDialog(null);
            if (r == JFileChooser.APPROVE_OPTION) {
                File file = new File(j.getSelectedFile().getAbsolutePath() + ".txt");
                try {
                    FileWriter fileWriter = new FileWriter(file);
                    BufferedWriter w = new BufferedWriter(fileWriter);
                    w.write(notepad.getTextArea().getText());
                    w.flush();
                    w.close();
                    DosyaAc.currentFile = file;
                    notepad.getFrame().setTitle(j.getSelectedFile().getName());
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "File Not Found!");
                }
            }
        }
    }
}
