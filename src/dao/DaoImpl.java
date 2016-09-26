package dao;

import po.Context;
import po.Type;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2016/9/26.
 */
public class DaoImpl implements Tour {

    private String url="jdbc:mysql://192.168.1.101";
    private String username="root";
    private String password="root";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delContext(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "DELETE FROM tour_context WHERE id=?";
        try {
            conn = DriverManager.getConnection(url,username,password);

            ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addContext(Context context) {

    }

    @Override
    public List<Context> getContext(int num) {
        return null;
    }

    @Override
    public void editContext(Context context) {

    }

    @Override
    public void delType(int id) {

    }

    @Override
    public void addType(Type type) {

    }

    @Override
    public Type getType(int id) {
        return null;
    }

    @Override
    public void editType(Type type) {

    }
}
