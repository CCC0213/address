package mysql;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author zkq
 * @title:
 * @projectName airportdatareport
 * @description: TODO
 * @date 2022/3/23 11:06
 */
public class mysql {

    private static Connection connection;
    private static PreparedStatement preparedStatement;


    public static void main(String[] args) {

        String sql1 = "update student set age = 1000 where id = ? and name = ?";
        //String sql2 = "select *from test111.student ";

        connection = JdbcUtils1.getConnection();

        try {
            preparedStatement = connection.prepareStatement(sql1);

           // ResultSet rs = preparedStatement.executeQuery();


            preparedStatement.setString(1, "1");
            preparedStatement.setString(2, "张三");


//            while (rs.next()){
//              String id = rs.getString(1);
//                String username = rs.getString(2);
//                String pwd = rs.getString(3);
//                System.out.println(id+"----"+username+"-----"+pwd);
//            }

            preparedStatement.clearBatch();
            preparedStatement.executeUpdate();
            //preparedStatement.addBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
