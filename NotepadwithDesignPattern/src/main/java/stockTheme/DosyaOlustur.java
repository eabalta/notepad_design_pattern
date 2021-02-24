package stockTheme;

import notepad.Notepad;

import java.io.File;

//DosyaInterface içerisindeki işlem
//Dosya olusturma işlemine göre yazıldı.
public class DosyaOlustur implements DosyaInterface {

    private static DosyaOlustur instance;
    //File currentFile = DosyaAc.currentFile;
    public static Notepad notepad = Notepad.getInstance();

    public static DosyaOlustur getInstance(){
        if (instance == null){
            instance = new DosyaOlustur();
        }
        return instance;
    }
    @Override
    public void dosyaİslemi() {
        notepad.getFrame().setTitle("Yeni Metin Belgesi");
        notepad.getTextArea().setText(" ");
        DosyaAc.currentFile = null;
    }
}
