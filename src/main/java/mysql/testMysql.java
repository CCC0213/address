package mysql;

import java.sql.*;

public class testMysql {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dm","root","123456");
        if(connection!=null){
            System.out.println(true);
        }
        String sql = "update student set age = 500 where id = ? and name1 = ?";
        PreparedStatement psm =connection.prepareStatement(sql);
        psm.setInt(1,1);
        psm.setString(2,"张三");
        int num ;
        num=psm.executeUpdate();
        if (num == 0) {
            System.out.println("shibai ");
        } else{
            System.out.println("执行成功");
        }
  /*      int  aa=1;
        String bb="张三";

        String sql = "select * from  student  where id = ? and name1 = ?";
        System.out.println(sql);
        PreparedStatement psm =connection.prepareStatement(sql);
        psm.setInt(1,aa);
        psm.setString(2,bb);
        ResultSet rs =psm.executeQuery();
        if (rs.next()){
            System.out.println(rs.getString(2));
        } else {
            System.out.println("查询失败");
        }*/
    }
}
