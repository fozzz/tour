package po;

/**
 * Created by Administrator on 2016/9/26.
 */
public class Type {
    private int id;
    private String context;

    public Type(int id, String context) {
        this.id = id;
        this.context = context;
    }

    public Type() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
