package stockTheme;

import notepad.Notepad;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search {
    // Arama yapmak ve kelimeyi değiştirmek için bu arrayListi kullanıyoruz.
    // 0.indexte kelimenin kendisi, 1.indexten itibaren de kelimenin text içerisinde hangi indexlerde olduğunu tutuyor.
    ArrayList<Object> searchAndReplaceWordList = new ArrayList<>();
    // Search butonuna kaç kere basıldığını tutuyor. Böylece text içerisindeki tüm kelimelerde gezinebiliyoruz.
    int searchButtonCount;
    // Notepad classintan notepad adinda bir instance olusturmak icin Notepad classi icerisinde bulunan getInstance metodunu kullaniyoruz.
    Notepad notepad = Notepad.getInstance();

    // Search Classi icin Singleton yapisini olusturduk.
    private static Search instance;
    public static Search getInstance(){
        if(instance==null){
            instance = new Search();
        }
        return instance;
    }


    public void searchAreaButton(){
        // Search butonunun işlevini burada tanımladık.
        // ArrayListimiz boş değilse içeride kelime vardır anlamına gelir.
        notepad.getTextField2().setEnabled(true);
        notepad.getReplaceButton().setEnabled(true);
        if(!searchAndReplaceWordList.isEmpty()){
            if(!searchAndReplaceWordList.get(0).equals(notepad.getTextField1().getText())){
                searchAndReplaceWordList = new ArrayList<>();
                searchButtonCount = 0;
            }
        }
        searchTextArea();
    }

    private void searchTextArea(){
        // Highlightlı kelimeleri temizliyoruz.
        removeHighLight(notepad.getTextArea());
        Highlighter highlight = notepad.getTextArea().getHighlighter();
        // Eğer hiç aratılmamışsa kelime var mı diye kontrol ediyoruz.
        if (searchButtonCount == 0){
            isContainWord();
            searchButtonCount++;
        }
        // Eğer textarea içerisindeki son kelimedeysek count değerini 1 yaparak en başa dönüyoruz.
        // 1 yapmamızın nedeni searchAndReplaceWordList listesinde 0.indexte kelimenin kendisi 1.indexten itibaren konumları yer alıyor.
        if(searchButtonCount == searchAndReplaceWordList.size()){
            searchButtonCount = 1;
        }
        // Eğer kelime birden fazla varsa ve sonuna gelinmediyse işaretlemeye devam ediyoruz.
        if(searchButtonCount != 0 && searchButtonCount < searchAndReplaceWordList.size()){
            try {
                highlight.addHighlight((int) searchAndReplaceWordList.get(searchButtonCount), ((int) searchAndReplaceWordList.get(searchButtonCount) + ((String) searchAndReplaceWordList.get(0)).length()), highLighter);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
            searchButtonCount++;
        }

    }

    private void isContainWord(){
        // Kelimenin olup olmadığını bulmak için bu metodu kullanıyoruz.
        // Bu metotta regex kullandık.
        String fullString = notepad.getTextArea().getText();
        String partWord = notepad.getTextField1().getText();
        String pattern = "\\b" + partWord + "\\b";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(fullString);
        // listenin 0. indexine kelimenin kendisini ekliyoruz.
        searchAndReplaceWordList.add(partWord);
        int position;
        while(m.find()){
            position = m.start();
            // listenin 1. indexinden itibaren kelimenin konumlarını ekliyoruz.
            searchAndReplaceWordList.add(position);
        }
    }

    public void replaceWordButton(){
        // Replace butonunun işlevini burada tanımladık.
        replaceWord();
        searchAndReplaceWordList = new ArrayList<>();
        isContainWord();
        searchButtonCount--;
        notepad.getTextField2().setText("");
    }

    private void replaceWord() {
        // Kelimeleri değiştirme işlemini burada yapıyoruz.
        StringBuilder finalText = new StringBuilder("");
        Document document = notepad.getTextArea().getDocument();
        StringBuilder text = null;
        try {
            text = new StringBuilder(document.getText(0, document.getLength()));
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        String takeReplaceWord = notepad.getTextField2().getText();
        finalText = text.replace((int) searchAndReplaceWordList.get(searchButtonCount - 1), (int) searchAndReplaceWordList.get(searchButtonCount - 1) + ((String) searchAndReplaceWordList.get(0)).length(), takeReplaceWord);
        notepad.getTextArea().setText(finalText.toString());
    }

    // Highlighter
    static class MyHighLighter extends DefaultHighlighter.DefaultHighlightPainter {

        public MyHighLighter(Color color) {
            super(color);
        }
    }

    DefaultHighlighter.DefaultHighlightPainter highLighter = new MyHighLighter(Color.yellow);

    private void removeHighLight(JTextArea textArea) {
        Highlighter removeHighlighter = textArea.getHighlighter();
        Highlighter.Highlight[] remove = removeHighlighter.getHighlights();

        for (Highlighter.Highlight highlight : remove) {
            if (highlight.getPainter() instanceof MyHighLighter) {
                removeHighlighter.removeHighlight(highlight);
            }
        }
    }

}
