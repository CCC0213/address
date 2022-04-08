package mysql;

import com.alibaba.druid.pool.DruidDataSourceFactory;


import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


public class JdbcUtils1 {

    private static DataSource dataSource; //Druid 连接池
    private static Connection conn; //数据库连接对象
   // private static Logger logger = LogManager.getLogger(JdbcUtils.class);
    private static InputStream in = null;
    private final static String CONF_NAME = "jdbcDruid.properties";

    static {
        //使用druid.properties属性文件的配置方式 设置参数，文件名称没有规定但是属性文件中的key要一定的
        // 从druid.properties属性文件中获取key参数对应的value配置信息
        Properties properties = new Properties();

        try {

            properties.load(JdbcUtils1.class.getClassLoader().getResourceAsStream(CONF_NAME));

            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
           // logger.error("ERROR:", e);//错误异常完整写入日志文件
        }


    }

    //获得连接池
   /* public static DataSource getDataSource(){
        return dataSource;
    }*/

    //从 连接池中获取一个 数据库连接对象
    public static Connection getConnection() {
        //从 连接池中获取一个 数据库连接对象
        try {
            //System.out.println("从 连接池中获取一个 数据库连接对象");
            conn = dataSource.getConnection();

        } catch (Exception e) {
            //e.printStackTrace();//窗口也打印错误信息
           //logger.error("ERROR:", e);//错误异常完整写入日志文件
        }
        return conn;
    }

    //调用数据库连接对象的close()方法，把指定的连接对象归还给连接池，并不是关闭连接
    public static void closeAll(Connection conn, PreparedStatement pstmt) {
        //调用数据库连接对象的close()方法，把连接对象归还给连接池，并不是关闭连接
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();//关闭
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


}
