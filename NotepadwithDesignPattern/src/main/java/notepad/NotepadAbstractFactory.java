package notepad;

import blackMode.blackModeFactory;
import stockTheme.NotepadFactory;
import darkMode.darkModeFactory;

// Abstract Factory Pattern icerisindeki Client elemani olan Notepad classinin factoryi arguman olarak alan NotepadCreator metodunu burada kullaniyoruz.
// main metoduna gelen argumana gore temamiz cagiriliyor.

// Ayrica her temaya adit swing elemanlari, temaya ait olan paket altinda tanimlanmistir.

public class NotepadAbstractFactory {
    public static void main(String[] args){
        Notepad notepad = Notepad.getInstance();
        NotepadFactory factory = null;

        if (args.length > 0) {
            if ("Dark Mode".equals(args[0])) {
                factory = new darkModeFactory();
            } else if ("Black Mode".equals(args[0])) {
                factory = new blackModeFactory();
            } else if ("Stock Theme".equals(args[0])) {
                factory = new NotepadFactory();
            }
        }
        if (factory == null) {
            factory = new NotepadFactory();
        }
        notepad.NotepadCreator(factory);
    }
}
