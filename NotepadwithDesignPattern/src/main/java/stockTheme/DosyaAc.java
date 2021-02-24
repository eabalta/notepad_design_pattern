package stockTheme;

import notepad.Notepad;

import javax.swing.*;
import java.io.File;
import java.util.Scanner;

//DosyaInterface içerisindeki işlem
//Dosya acma işlemine göre yazıldı.
public class DosyaAc implements DosyaInterface {
    private static DosyaAc instance;
    public static File currentFile; //static olarak tanımlandı cunku dosya kaydetme işleminde dosya daha onceden acıldıysa kaydedilecek yer sormadan
                                    //direkt olarak o dosyanın uzerine kaydetme saglandı

    public static Notepad notepad = Notepad.getInstance();

    public static DosyaAc getInstance(){
        if (instance == null){
            instance = new DosyaAc();
        }
        return instance;
    }

    @Override
    public void dosyaİslemi() {
        JFileChooser fileChooser = new JFileChooser();
        int r = fileChooser.showOpenDialog(null);
        if(r == JFileChooser.APPROVE_OPTION){
            String fileName = fileChooser.getSelectedFile().getName();
            notepad.getFrame().setTitle(fileName);
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            currentFile = file;
            try{
                String fileString = "";
                Scanner textFile = new Scanner(file);
                while(textFile.hasNextLine()){
                    fileString = fileString + textFile.nextLine() + "\n";
                }
                notepad.getTextArea().setText(fileString);
            }catch (Exception evt){
                JOptionPane.showMessageDialog(null,evt.getMessage());
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Dosya açma iptal edildi.");
        }
    }
}
