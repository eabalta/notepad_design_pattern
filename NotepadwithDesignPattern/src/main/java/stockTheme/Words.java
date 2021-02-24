package stockTheme;

import notepad.Notepad;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Words {
    // words.txt içerisinde Kelimeleri bu hashset içerisinde tutuyoruz.
    private static HashSet<String> wordsTxtHashSet;
    // TextArea içerisindeki kelimeleri bu HashSet içerisinde tutuyoruz.
    private static HashSet<String> textAreaWordHashSet;
    // control metodunda hata almamak için gecici tempHash oluşturduk.
    private static HashSet<String> tempHash;
    // Doğru olan kelimeleri bu hashset içerisinde tutuyoruz.
    private static HashSet<String> trueWordsHashSet;

    // Notepad classindan bir instance olusturuyoruz.
    Notepad notepad = Notepad.getInstance();

    private Words(){
        wordsTxtHashSet = new HashSet<>();
        readWords();
    }

    // Words classi icin Singleton patternini kullaniyoruz.
    private static Words instance;
    public static Words getInstance(){
        if(instance==null){
            instance = new Words();
        }
        return instance;
    }

    private void readWords(){
        try {
            Scanner textFile = new Scanner(new File("words.txt"));
            while (textFile.hasNext()) {
                wordsTxtHashSet.add(textFile.next().trim());
            }
                textFile.close();
        } catch (FileNotFoundException e) {
                System.out.println("Words File Not Found!");
            }

    }

    public void controlButton(){
        // Kelimelerin doğruluğunu kontrol eden Control butonunun işlevini burada tanımladık.
        // StringTokenizer sayesinde aşağıdaki işaretleri metinden temizlenerek sadece kelimeleri  textAreaWordHashSet içerisine ekliyoruz.
        String regex = "[!._,;-':@?\n ]";
        StringTokenizer str = new StringTokenizer(notepad.getTextArea().getText(), regex);
        textAreaWordHashSet = new HashSet<String>();
        tempHash = new HashSet<>();
        while(str.hasMoreTokens()){
            textAreaWordHashSet.add(str.nextToken().toLowerCase());
        }

        // textArea içindeki kelimelerden oluşan trueWordsHashSet adında bir hs oluşturuyoruz.
        // trueWords içerisinde sadece doğru kelimeleri bırakıyoruz.
        // trueWords içerisindeki doğru kelimeleri textArea içerisinden çıkartarak yanlış olabilecek kelimeler ile başbaşa kalıyoruz.
        trueWordsHashSet = new HashSet<>(textAreaWordHashSet);
        trueWordsHashSet.retainAll(wordsTxtHashSet);
        textAreaWordHashSet.removeAll(trueWordsHashSet);

        // Iterator Pattern'ini burada kullaniyoruz.
        HashSetIterator iterator = new HashSetIterator(textAreaWordHashSet);
            // Burada sayısal değerleri de doğru kelime olarak alıyoruz.
        while(iterator.hasNext()){
            String current = (String) iterator.next();
            if(isNumeric(current)){
                trueWordsHashSet.add(current);
                textAreaWordHashSet.remove(current);
            }
        }

        // Foreach içerisinde remove metodunu gerçekleştirirken hata almamak için geçici tempHash oluşturduk.
        // İçerisine kalan yanlış olabilecek kelimeleri attık.
        tempHash.addAll(textAreaWordHashSet);

        // Single Transposition olan kelimeleri depolamak için gecici olarak oluşturduk.
        ArrayList singleTranspositionTexts = new ArrayList();
        ArrayList singleTransTrueVersion = new ArrayList();

        for(String falseText : textAreaWordHashSet){
            StringBuilder temp = new StringBuilder(falseText);
            for(int i=0; i < falseText.length()-1; i++){
                char tempChar = temp.charAt(i);
                temp.setCharAt(i,temp.charAt(i+1));
                temp.setCharAt(i+1,tempChar);

                // Ayarlanan kelime var mı yok mu diye kontrol ediyoruz.
                if(wordsTxtHashSet.contains(temp.toString())) {
                    trueWordsHashSet.add(temp.toString());
                    singleTransTrueVersion.add(temp.toString());

                    // Yerini bulduktan sonra kelimeyi düzeltme işlemini burada yapıyoruz.
                    int index = notepad.getTextArea().getText().toLowerCase().indexOf(falseText);
                    notepad.getTextArea().replaceRange(temp.toString(), index, index + falseText.length());
                    // Single Transposition olan kelimeyi arrayliste ekliyoruz.
                    singleTranspositionTexts.add(falseText);
                    tempHash.remove(falseText);
                }
                temp = new StringBuilder(falseText);
            }
        }
        JOptionPane.showMessageDialog(null,"Single Transposition Olan Kelimeler : \n" + singleTranspositionTexts + "\nDoğru Versiyonları : \n" + singleTransTrueVersion);
        textAreaWordHashSet.removeAll(singleTranspositionTexts);
        JOptionPane.showMessageDialog(null, "True def.Words : \n" + trueWordsHashSet+"\nFalse words: \n" + textAreaWordHashSet);
    }

    // karakterin numerik olup olmadığını bu metotla kontrol ediyoruz.
    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
