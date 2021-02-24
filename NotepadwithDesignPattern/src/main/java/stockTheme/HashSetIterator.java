package stockTheme;

import java.util.HashSet;
import java.util.Iterator;

// Iterator Pattern Burada Gerceklestirildi.

// Iteratorumuzu HashSet icin kullanacagimiz icin class ismimize HashSetIterator verdik.

public class HashSetIterator implements Iterator {

    // Kullanilacak olan HashSetin referansini olusturduk.
    HashSet<String> hs;
    // Indexi tutabilmek icin bir int deger olusturduk.
    int current_index = 0;

    public HashSetIterator(HashSet<String> hs) {
        this.hs = hs;
    }

    @Override
    public boolean hasNext() {
        return (current_index<hs.size()?true:false);
    }

    @Override
    public Object next() {
        Object[] temp = hs.toArray();
        return temp[current_index++];
    }
}
