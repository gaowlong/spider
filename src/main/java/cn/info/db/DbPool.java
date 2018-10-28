package cn.info.db;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * 新增数据库连接池
 * Created by gaowenlong on 2018/10/28.
 */
public class DbPool {

    private static DbPool dbPool;
    private static DruidDataSource druidDataSource;

    static {
        //加载配置文件
        //初始化数据
        Properties properties = loadProperties("config.properties");;
        try {
            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("创建数据库连接池失败");
        }
    }

    /**
     * 数据库连接池单例
     * @return
     */
    public synchronized static  DbPool getInstance() {
        if(dbPool == null) {
            dbPool = new DbPool();
        }
        return dbPool;
    }


    /**
     * 获取数据库链接
     * @return
     * @throws Exception
     */
    public  DruidPooledConnection getConnection() throws Exception{
        return druidDataSource.getConnection();
    }


    /**
     * 获取配置文件的位置
     * @param fileName
     * @return
     */
    public static Properties loadProperties(String fileName)  {
        Properties properties = null;
        properties = new Properties();
        try {
            InputStream in = DbPool.class.getClassLoader().getResourceAsStream(fileName);
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }


    public static void main(String[] args) {
        loadProperties("config.properties");
    }








}
