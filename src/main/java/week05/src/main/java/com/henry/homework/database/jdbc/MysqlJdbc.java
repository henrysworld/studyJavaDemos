package com.henry.homework.database.jdbc;

import java.sql.*;
import java.util.*;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/25 20:11
 * @Version: 1.0
 */
public class MysqlJdbc {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    private void createConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mall", "root", "root");
            if (connection != null){
                System.out.println("successful");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean insert(String table, String column, List<Object> values){
        String insertTemplate = buildInsertSqlTemplate(table, column, values.size());
        try {
            preparedStatement = connection.prepareStatement(insertTemplate);
            for (int i = 1; i < values.size(); i++) {
                preparedStatement.setObject(i, values.get(i - 1));
            }

            System.out.println(preparedStatement.toString());

            preparedStatement.execute();

            System.out.println("Insert successfully");
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    private String buildInsertSqlTemplate(String table, String column, int valueAmount){
        return "insert into " + table + " " + column + "values (?" + ",?".repeat(Math.max(0, valueAmount - 1)) +")";
    }

    private List<Map<String, Object>> query(String table, Map<String, Object> values, String condition){
        String sqlTemplate = buildQuerySqlTemplate(table, values, condition);
        try {
            preparedStatement = connection.prepareStatement(sqlTemplate);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Map<String, Object>> list = new ArrayList<>();
            while (resultSet.next()){
                for (String key : values.keySet()){
                    values.put(key, resultSet.getObject(key));
                }

                list.add(new HashMap<>(values));
            }

            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public String buildQuerySqlTemplate(String table, Map<String, Object> values, String condition){
        String sqlTemplate = "select " + values.keySet().toString().substring(1, values.keySet().toString().length() - 1) + " from " + table;
        if (condition != null){
            sqlTemplate += " where " + condition;
        }

        return sqlTemplate;
    }

    private void close(){
        try {
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println("conn close");
    }

    public static void main(String[] args) {
        Map<String, Object> valuesMap = new HashMap<>();
        valuesMap.put("id", 0);
        valuesMap.put("name", "name");
        valuesMap.put("password", "password");
        valuesMap.put("phoneNumber", "phoneNumber");
        valuesMap.put("money", 0);

        System.out.println(valuesMap.keySet().toString().substring(1, valuesMap.keySet().toString().length()-1));

        MysqlJdbc mysqlJdbc = new MysqlJdbc();
        mysqlJdbc.createConnection();
        String table = "users";
        String columns = "(name, password, phoneNumber, money)";
        List<Object> values = Arrays.asList("name", "password", "phoneNumber", 0);

        mysqlJdbc.insert(table, columns, values);

        List<Map<String, Object>> results = mysqlJdbc.query(table, valuesMap, null);

        for (Map r: results)
            System.out.println(r.toString());

        mysqlJdbc.close();
    }
}
