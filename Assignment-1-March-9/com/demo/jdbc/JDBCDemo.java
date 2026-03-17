package com.demo.jdbc;


import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/EmployeeDB", "postgres", "suyash");
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery("select * from employee");


//        prepared stmt:
        PreparedStatement pstmt = conn.prepareStatement("select * from Employee");
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()) {
            System.out.println(rs.getInt("id") + "\t" + rs.getString("name"));
        }
        rs.close();
//        int id = 1;
//        String name = "Bob";
//        stmt.executeUpdate("delete from Employee where id = " + id);
//        PreparedStatement pstmt1 = conn.prepareStatement("delete from Employee where name = '"+name+"' ");
//        int rowsAffected = pstmt1.executeUpdate();
//        if(rowsAffected >= 1) System.out.println("Deleted successfully for name = " + name);
//        else System.err.println("Deletion Error!");
//        pstmt1.close();

        int id = 12;
        String name = "Ronit";
        int salary = 15000;
        String department = "Testing";
        int phoneno = 2299473;
        PreparedStatement pstmt1 = conn.prepareStatement("insert into Employee values (?, ?, ?, ?, ?)");
        pstmt1.setInt(1, id);
        pstmt1.setString(2, name);
        pstmt1.setInt(3, salary);
        pstmt1.setString(4, department);
        pstmt1.setInt(5, phoneno);
        int rowAffected = pstmt1.executeUpdate();
        if(rowAffected >= 1) System.out.println("Insert successfull");
        else System.err.println("Insertion error");
        int newid = 12;
        int newSalary = 20000;
        String newDepartment = "Development";

        PreparedStatement pstmt2 = conn.prepareStatement("update Employee set salary = ?, department = ? where id = ?");

        pstmt2.setInt(1, newSalary);
        pstmt2.setString(2, newDepartment);
        pstmt2.setInt(3, newid);

        int rowsAffected = pstmt2.executeUpdate();

        if(rowsAffected >= 1) System.out.println("Employee updated successfully for id = " + id);
        else System.out.println("No employee found with id = " + id);

        pstmt2.close();


        conn.close();

        /*
        * make this program modular
        * recieve values dynamically
        * perform a partivular operation from user input regarding input
        * perform all operations based on user input
        * crate one data members in a class in EMployee class
        * inseet method should reciev emplyee type of object
        *
        *
        * */
    }
}
