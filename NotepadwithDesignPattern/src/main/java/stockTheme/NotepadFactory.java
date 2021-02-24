package stockTheme;

import javax.swing.*;

// Abstract Factory Pattern sablonunda bulunan AbstractFactory yapisini burada olusturduk.
// Default temanin gerceklestirimi de burada oluyor.
// new islemleri kullanicidan soyutlanip makeX fonksiyonlarina donusturuldu.
// new islemini gerceklestirdigimiz her bir swing elemani bir Product yerine gecmektedir.

public class NotepadFactory {

    public JFrame makeFrame(String name){
        return new JFrame(name);
    }

    public JPanel makePanel(){
        return new JPanel();
    }

    public JTextArea makeTextArea(){
        return new JTextArea();
    }

    public JMenuBar makeMenuBar(){
        return new JMenuBar();
    }

    public JMenu makeMenu(String name){
        return new JMenu(name);
    }

    public JLabel makeLabel(String text){
        return new JLabel(text);
    }

    public JTextField makeTextField(int column){
        return new JTextField(column);
    }

    public JMenuItem makeMenuItem(String name){
        return new JMenuItem(name);
    }

    public JButton makeButton(String name){
        return new JButton(name);
    }

    public  JScrollPane makeScrollPane(JTextArea textArea){ return  new JScrollPane(textArea);}
}
