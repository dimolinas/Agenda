package logica;

import datos.Contact;
import datos.Diary;
import visual.contactWindow;
import visual.mainWindow;

import java.io.*;

public class main {

    public static Diary diary = new Diary();

    public static void main(String args[]) throws IOException, ClassNotFoundException {

        mainWindow mainWindow = new mainWindow();
        mainWindow.setVisible(true);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("contactos.ddr"));
        Diary diary1 = (Diary)ois.readObject();
        diary1.getDiary().forEach(i->diary.getDiary().add(i));
    }

    public static void guardar() throws IOException {
        ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("contactos.ddr"));
        oss.writeObject(diary);
        oss.close();
    }
}
