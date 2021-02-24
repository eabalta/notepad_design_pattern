package stockTheme;

//DosyaInterface içerisindeki işlem
//Dosya kapatma işlemine göre yazıldı.
public class DosyaKapat implements DosyaInterface{
    @Override
    public void dosyaİslemi() {
        System.exit(1);
    }
}
