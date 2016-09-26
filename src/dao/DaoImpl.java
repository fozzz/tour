package dao;

import po.Context;
import po.Type;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/26.
 */
public class DaoImpl implements Tour {

    private String url = "jdbc:mysql://192.168.1.101/tour";
    private String username = "root";
    private String password = "root";

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
            conn = DriverManager.getConnection(url, username, password);

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
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            ps = conn.prepareStatement("INSERT INTO tour_context(id,type_id,title,date,context,pic)VALUES (?,?,?,?,?,?)");
            ps.setInt(1, context.getId());
            ps.setInt(2, context.getType_id());
            ps.setString(3, context.getTitle());
            ps.setInt(4, context.getDate());
            ps.setString(5, context.getContext());
            ps.setString(6, context.getPic());
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
    public List<Context> getContext(int num, int tp_id) {
        List<Context> cts = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "SELECT * FROM tour_context WHERE type_id=? ORDER BY date DESC LIMIT " + num;
        try {
            conn = DriverManager.getConnection(url, username, password);
            ps = conn.prepareStatement(sql);
            ps.setInt(1, tp_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int type_id = rs.getInt(2);
                String title = rs.getString(3);
                int date = rs.getInt(4);
                String context = rs.getString(5);
                String pic = rs.getString(6);
                Context ct = new Context(id, type_id, title, date, context, pic);
                cts.add(ct);
            }
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
        return cts;
    }

    @Override
    public void editContext(Context context) {

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            ps = conn.prepareStatement("update tour_context set id=?,type_id=?,title=?,date=?,context=?,pic=? where id=?");
            ps.setInt(1, context.getId());
            ps.setInt(2, context.getType_id());
            ps.setString(3, context.getTitle());
            ps.setInt(4, context.getDate());
            ps.setString(5, context.getContext());
            ps.setString(6, context.getPic());
            ps.setInt(7, context.getId());
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

//    @Override
//    public void delType(int id) {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        String sql = "DELETE FROM tour_type WHERE id=?";
//        try {
//            conn = DriverManager.getConnection(url, username, password);
//
//            ps = conn.prepareStatement(sql);
//
//            ps.setInt(1, id);
//
//            ps.execute();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                ps.close();
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    @Override
    public void addType(Type type) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            ps = conn.prepareStatement("INSERT INTO tour_type(id,context)VALUES (?,?)");
            ps.setInt(1, type.getId());
            ps.setString(2, type.getContext());
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
    public Type getType(int tid) {
        Type type=new Type();
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "SELECT * FROM tour_type WHERE id=? ";
        try {
            conn = DriverManager.getConnection(url, username, password);
            ps = conn.prepareStatement(sql);
            ps.setInt(1, tid);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id = rs.getInt(1);
            String context = rs.getString(2);
            type = new Type(id, context);
            return type;
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
        return type;
    }

    @Override
    public void editType(Type type) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            ps = conn.prepareStatement("update tour_type set id=?,context=? where id=?");
            ps.setInt(1, type.getId());
            ps.setString(2, type.getContext());
            ps.setInt(3, type.getId());
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

    public static void main(String[] args) {
        Tour tour = new DaoImpl();
//        try {
//            tour.delContext(1);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        tour.addContext(new Context(1,1,"新闻标题",20160926,"内容","F://1.gif"));
//        List<Context>list=tour.getContext(3);
//        System.out.println(list.get(0).getId());
//        tour.delContext(1);
//        tour.editContext(new Context(2,1,"xwbt",20160928,"内容","C://"));
//        System.out.println(tour.getType(1).getContext());
//        tour.editType(new Type(2,"公告"));
//         tour.addType(new Type(3,"路线"));
    }
}
