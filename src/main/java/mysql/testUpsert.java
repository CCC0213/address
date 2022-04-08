package mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class  testUpsert {
    public static void main(String[]args) throws SQLException {
        MysqlClient mysqlClient = new MysqlClient("jdbc:mysql://localhost:3306/dm?characterEncoding=UTF-8&useUnicode=true&useSSL=false&autoReconnect=true|root|123456");
        int id = 0;
        String name = null;
        Scanner inpputId =new Scanner(System.in);
        System.out.println("请输入名字");
        name = inpputId.nextLine();

        String sql1="select * from student where name=?";

        ResultSet ss = mysqlClient.execute1(sql1,name);

        while(ss.next()){
            id= ss.getInt(1);
            name=ss.getString(2);
        }
        System.out.println(id);
        System.out.println(name);
/*
        String sql2 = "update student set age = 500 where id = ? and name = ?";

        mysqlClient.execute(sql2,id,name);*/
    }
}



