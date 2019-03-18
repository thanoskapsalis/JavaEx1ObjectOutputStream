import java.io.Serializable;

public class Magazine_Post extends Post implements Serializable {

    String magazine;
    String page_num;
    String year;
    String volume;
    String mag_page;

    public Magazine_Post(String ID, String title, String writer, String magazine, String page_num, String year, String volume, String mag_page) {
        super(ID, title, writer);
        this.magazine = magazine;
        this.page_num = page_num;
        this.year = year;
        this.volume = volume;
        this.mag_page = mag_page;
    }

    @Override
    public String toString() {
        return title + "     " + writer + "     " + magazine + "     " + page_num + "     " + year + "     " + volume + "     " + mag_page;
    }
}
