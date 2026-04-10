package com.demo.jdbc;

import java.sql.*;
import java.util.*;


public class EmployeeDAO {

    private static Connection conn;
    static {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5433/EmployeeDB",
                    "postgres",
                    "suyash"
            );
        } catch(Exception e) {
            System.out.println("Connection failed! Check output console.");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return conn;
    }

    public static void createTable(Connection conn) throws Exception {

        String sql = """
                CREATE TABLE IF NOT EXISTS employee(
                id INT PRIMARY KEY,
                name VARCHAR(50),
                salary INT,
                department VARCHAR(50),
                phoneno BIGINT)
                """;

        Statement stmt = conn.createStatement();
        stmt.execute(sql);
        stmt.close();
    }


    public static Employee insert(Connection conn, Employee emp) throws Exception {

        PreparedStatement pstmt = conn.prepareStatement(
                "INSERT INTO employee VALUES (?, ?, ?, ?, ?)"
        );

        pstmt.setInt(1, emp.getId());
        pstmt.setString(2, emp.getName());
        pstmt.setInt(3, emp.getSalary());
        pstmt.setString(4, emp.getDepartment());
        pstmt.setString(5, emp.getPhoneNo());

        int rows = pstmt.executeUpdate();
        pstmt.close();

        if (rows > 0)
            return emp;

        return null;
    }


    public static List<Employee> readAll(Connection conn) throws Exception {

        List<Employee> list = new ArrayList<>();

        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employee");

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            Employee emp = new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("salary"),
                    rs.getString("department"),
                    rs.getString("phoneno")
            );

            list.add(emp);
        }

        rs.close();
        pstmt.close();

        return list;
    }


    public static Employee readById(Connection conn, int id) throws Exception {

        PreparedStatement pstmt = conn.prepareStatement(
                "SELECT * FROM employee WHERE id=?"
        );

        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {

            Employee emp = new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("salary"),
                    rs.getString("department"),
                    rs.getString("phoneno")
            );

            rs.close();
            pstmt.close();
            return emp;
        }

        rs.close();
        pstmt.close();
        return null;
    }


    public static Employee update(Connection conn, int id, Employee emp) throws Exception {

        Employee existing = readById(conn, id);

        if (existing == null)
            return null;

        PreparedStatement pstmt = conn.prepareStatement(
                "UPDATE employee SET salary=?, department=? WHERE id=?"
        );

        pstmt.setInt(1, emp.getSalary());
        pstmt.setString(2, emp.getDepartment());
        pstmt.setInt(3, id);

        pstmt.executeUpdate();
        pstmt.close();

        existing.setSalary(emp.getSalary());
        existing.setDepartment(emp.getDepartment());

        return existing;
    }


    public static Employee delete(Connection conn, int id) throws Exception {

        Employee existing = readById(conn, id);

        if (existing == null)
            return null;

        PreparedStatement pstmt = conn.prepareStatement(
                "DELETE FROM employee WHERE id=?"
        );

        pstmt.setInt(1, id);

        pstmt.executeUpdate();
        pstmt.close();

        return existing;
    }


    public static void dropTable(Connection conn) throws Exception {

        Statement stmt = conn.createStatement();

        stmt.execute("DROP TABLE IF EXISTS employee");

        stmt.close();
    }
}