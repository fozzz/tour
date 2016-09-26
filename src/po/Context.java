package po;

/**
 * Created by Administrator on 2016/9/26.
 */
public class Context {
    private int id;
    private int type_id;
    private String title;
    private int date;
    private String context;
    private String pic;

    public Context(int id, int type_id, String title, int date, String context, String pic) {
        this.id = id;
        this.type_id = type_id;
        this.title = title;
        this.date = date;
        this.context = context;
        this.pic = pic;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
