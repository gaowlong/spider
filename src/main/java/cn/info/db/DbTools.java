package cn.info.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by gaowenlong on 2018/10/27.
 */
public class DbTools {

    //public final static String url = "jdbc:mysql://97.64.18.141:3306/spider?useUnicode=true&characterEncoding=UTF-8";
    private final static String url = "jdbc:mysql://127.0.0.1:3306/spider?useUnicode=true&characterEncoding=UTF-8";

    public final static String driver = "com.mysql.jdbc.Driver";

    public final static String username = "root";

    public final static String password = "654321";

    /**
     * 获取连接
     * @return
     */
    public static Connection getConnection() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    public static void main(String[] args) {
        getConnection();
    }


}
