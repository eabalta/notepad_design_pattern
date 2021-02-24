package notepad;

import javax.swing.event.UndoableEditEvent;

//text area'da yapılan son islemleri kendi içerisinde sıraya alır
//undocommand içerisinde execute edildiginde bu sırayla geri almayı saglar
public interface UndoableCommand extends Command {
    public void delete(UndoableEditEvent editEvent);
}
