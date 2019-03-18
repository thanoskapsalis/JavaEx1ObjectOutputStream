import java.io.Serializable;

public class Conference_Post extends Post implements Serializable {
    String con_name;
    String date;
    String location;

    public  Conference_Post(String ID,String title,String writer,String con_name,String date,String location){
        super(ID,title, writer);
        this.con_name=con_name;
        this.date=date;
        this.location=location;
    }

    @Override
    public String toString() {
        return title+"     "+writer+"     "+con_name+"     "+date+"     "+location;
    }
}
