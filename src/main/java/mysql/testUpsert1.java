package mysql;

import java.sql.*;

public class  testUpsert1 {
    public static void main(String[]args) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement2 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;

        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //获取连接
            String url = "jdbc:mysql://localhost:3306/dm?serverTimezone=UTC";
            String user = "root";
            String password = "123456";
            connection = DriverManager.getConnection(url, user, password);

            //获取statement preparedStatement
            String sql = "select * from student where id = 1 and name = '赵六'";
            preparedStatement = connection.prepareStatement(sql);

            // 执行查询
            rs = preparedStatement.executeQuery();

            String id = null;
            String name = null;
            // 处理结果集
            while (rs.next()) {
                id = rs.getString(1);
                name = rs.getString(2);
                String age = rs.getString(3);

                System.out.print(rs.getString("id")+" ");
                System.out.print(rs.getString("name")+" ");
                System.out.println(rs.getString("age")+" ");

            }

            String sql1 = "update student set age = 500 where id = 1 and name = '张三'";
//            String sql2 = "select * from student where id = 1 and name = '张三'";
            connection.prepareStatement(sql1).executeUpdate(sql1);

            String sql2 = "select * from student where id = 1 and name = '张三'";
            preparedStatement2 = connection.prepareStatement(sql2);
            // 执行查询
            rs2 = preparedStatement2.executeQuery();

            String id2 = null;
            String name2 = null;
            // 处理结果集
            while (rs2.next()) {
                id2 = rs2.getString(1);
                name2 = rs2.getString(2);
                String age2 = rs2.getString(3);

                System.out.print(rs2.getString("id")+" ");
                System.out.print(rs2.getString("name")+" ");
                System.out.print(rs2.getString("age")+" ");

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接，释放资源
            if (rs != null && rs2 != null) {
                rs.close();
                rs2.close();
            }
            if (preparedStatement != null && preparedStatement2 != null) {
                preparedStatement.close();
                preparedStatement2.close();
            }
            if (connection != null) {
                connection.close();
            }
            /*if (rs != null) {
                rs.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }*/
        }
    }
}




