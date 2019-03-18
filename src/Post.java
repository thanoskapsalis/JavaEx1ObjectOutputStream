import java.io.Serializable;

public class Post implements Serializable {
    String ID;
    String title;
    String writer;

    public Post(String ID ,String title, String writer)
    {
        this.ID=ID;
        this.title=title;
        this.writer=writer;
    }

    public String getID()
    {
        return ID;
    }

    public String getTitle()
    {
        return title;
    }

    public String getWriter()
    {
        return writer;
    }

}
