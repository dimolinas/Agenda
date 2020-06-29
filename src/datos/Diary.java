package datos;

import java.io.Serializable;
import java.util.ArrayList;

public class Diary  implements Serializable {

    private ArrayList<Contact> diary = new ArrayList<Contact>();

    public ArrayList<Contact> getDiary() {
        return diary;
    }

    public void setDiary(ArrayList<Contact> diary) {
        this.diary = diary;
    }
}
