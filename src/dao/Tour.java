package dao;

import po.Context;
import po.Type;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2016/9/26.
 */
public interface Tour {
    public void delContext(int id) throws SQLException;
    public void addContext(Context context);
    public List<Context> getContext(int num);
    public void editContext(Context context);

    public void delType(int id);
    public void addType(Type type);
    public Type getType(int id);
    public void editType(Type type);
}
