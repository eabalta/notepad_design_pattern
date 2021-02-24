package notepad;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.undo.UndoManager;

public class UndoCommand implements UndoableCommand {

    //swing textarea'da geri alma isleminin yapılması için undomanager tanımlandı
    public UndoManager manager;
    //geri alma tusuna basılma eventi
    UndoableEditEvent event;
    //Constructor
    public UndoCommand(UndoManager manager, UndoableEditEvent event){
        this.manager = manager;
        this.event = event;
    }

    //Undo butonuna basıldığında bu fonksiyon çalışıyor
    //Fonksiyon UndoManager ile geri alınabilecek ögeleri her buton tıklamasında geri almaya başlıyor.
    //Alamazsa bir hata mesajı ekrana bastırılıyor.
    @Override
    public void execute() {
        if(manager.canUndo()){
            manager.undo();
        }
        else{
            JOptionPane.showMessageDialog(null, "Geri alınacak öğe yok..");
        }
    }

    //textarea'da yapılan değişiklikler UndoManager classından oluşturulan manager nesnesi içerisinde sıraya alınıyor.
    @Override
    public void delete(UndoableEditEvent editEvent) {
        manager.addEdit(editEvent.getEdit());
    }
}
