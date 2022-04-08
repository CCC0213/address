package mysql;

import java.sql.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class MysqlClient {

    private Connection connection;
    private String jdbcUrl;
    private String driver = "com.mysql.jdbc.Driver";

    public MysqlClient(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
        this.init();
    }

    public void init() {
        try {
            if (connection == null || connection.isClosed()) {
                String[] split = jdbcUrl.split("\\|");
                Class.forName(driver);
                connection = DriverManager.getConnection(split[0], split[1], split[2]);
                if(connection!=null){
                    System.out.println(true);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void upsert(String table, Query query, Update update) {
        List<String> names = new ArrayList<String>();
        List<Object> params = new ArrayList<Object>();
        names.addAll(query.getValues().keySet().stream().map(item -> String.format("`%s`", item)).collect(Collectors.toList()));
        names.addAll(update.getSets().keySet().stream().map(item -> String.format("`%s`", item)).collect(Collectors.toList()));
        names.addAll(update.getIncs().keySet().stream().map(item -> String.format("`%s`", item)).collect(Collectors.toList()));

        List<String> values = new ArrayList<>();
        values.addAll(query.getValues().values().stream().map(item -> " ? ").collect(Collectors.toList()));
        params.addAll(query.getValues().values());

        values.addAll(update.getSets().values().stream().map(item -> " ? ").collect(Collectors.toList()));
        params.addAll(update.getSets().values());

        values.addAll(update.getIncs().values().stream().map(item -> " ? ").collect(Collectors.toList()));
        params.addAll(update.getIncs().values());

        List<String> updates = new ArrayList<>();
        update.getSets().forEach((key, value) -> {
            updates.add(String.format(" `%s` = ? ", key));
            params.add(value);
        });
        update.getIncs().forEach((key, value) -> {
            updates.add(String.format(" `%s` = `%s` + %s", key, key, value));
        });

        String sql = String.format("INSERT INTO `%s` (%s) VALUES(%s) ON DUPLICATE KEY UPDATE %s",
                table,
                String.join(",", names),
                String.join(",", values),
                String.join(",", updates)
        );
        this.execute(sql, params.toArray());
    }

    private void fillStatement(PreparedStatement statement, Object... params) throws SQLException {
        for (int i = 1, len = params.length; i <= len; i++) {
            Object value = params[i - 1];
            if (value instanceof String) {
                statement.setString(i, value.toString());
            } else if (value instanceof Integer) {
                statement.setInt(i, Integer.parseInt(value.toString()));
            } else if (value instanceof Boolean) {
                statement.setBoolean(i, Boolean.parseBoolean(value.toString()));
            } else if (value instanceof LocalDate || value instanceof LocalDateTime) {
                statement.setString(i, value.toString());
            } else if (value instanceof Long) {
                statement.setLong(i, Long.parseLong(value.toString()));
            } else if (value instanceof Double) {
                statement.setDouble(i, Double.parseDouble(value.toString()));
            } else if (value instanceof Float) {
                statement.setDouble(i, Float.parseFloat(value.toString()));
            } else {
                statement.setString(i, value.toString());
            }
        }
    }

    public void execute(String sql, Object... params) {
        try {
            int flag ;
            PreparedStatement statement = connection.prepareStatement(sql);
            this.fillStatement(statement, params);
            flag= statement.executeUpdate();
            if(flag!=0){
                System.out.println("执行成"+flag+"行");
            } else {
                System.out.println("执行失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public  ResultSet execute1(String sql, Object... params) {
        ResultSet sss ;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            this.fillStatement(statement, params);
             sss =statement.executeQuery();
            return sss;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}