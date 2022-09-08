package com.employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Date;
import java.sql.PreparedStatement;

public class DAO {
	private static final String INSERT_EMP_SQL = "INSERT INTO employee" +
	        "  (eid, ename, dob, age, salary) VALUES " +
	        " (?, ?, ?, ?, ?);";
	private static final String UPDATE_EMP_SQL = "UPDATE employee SET salary=? WHERE eid=?";
	private static final String DELETE_EMP_SQL = "DELETE FROM employee WHERE " +
	        "eid=?;";
	private static final String GET_EMP_BY_ID_SQL = "SELECT * FROM employee WHERE " +
	        " eid=?;";
	private static final String GET_ALL_EMP_SQL = "SELECT * FROM employee;";
	static Connection conn = null;

	static void saveEmp(Employee emp) throws SQLException {
		conn=Utility.createConnection();
		PreparedStatement ps = conn.prepareStatement(INSERT_EMP_SQL);
        ps.setInt(1, emp.getEid());
        ps.setString(2, emp.getEname());
        ps.setString(3, emp.getDob());
        ps.setInt(4, emp.getAge());
        ps.setInt(5, emp.getSalary());

        System.out.println(ps);
        ps.executeUpdate();
	}

	static void getAllEmp() throws SQLException {
		ResultSet rs = null;
		conn=Utility.createConnection();
		PreparedStatement ps = conn.prepareStatement(GET_ALL_EMP_SQL);
		rs = ps.executeQuery();
		while (rs.next()) {
            int eid = rs.getInt("eid");
            String ename = rs.getString("ename");
            String dob = rs.getString("dob");
            int age = rs.getInt("age");
            int salary= rs.getInt("salary");
            System.out.println(eid + "\t" + ename + "\t" + dob + "\t" + age + "\t" + salary);
        }
	}

	static void updateEmp(Employee emp) throws SQLException {
		conn=Utility.createConnection();
		PreparedStatement ps = conn.prepareStatement(UPDATE_EMP_SQL);
		
		ps.setInt(1, emp.getSalary());
		ps.setInt(2, emp.getEid());
		System.out.println(ps);
		ps.executeUpdate();
	}

	public static void deleteEmp(Employee emp) throws SQLException {
		conn=Utility.createConnection();
		PreparedStatement ps = conn.prepareStatement(DELETE_EMP_SQL);
		ps.setInt(1, emp.getEid());
		ps.executeUpdate();
	}
	public static void getEmpById(Employee emp) throws SQLException {
		conn=Utility.createConnection();
		PreparedStatement ps = conn.prepareStatement(GET_EMP_BY_ID_SQL);
		ps.setInt(1, emp.getEid());
		ResultSet rs = null;
		rs = ps.executeQuery();
		while (rs.next()) {
            int eid = rs.getInt("eid");
            String ename = rs.getString("ename");
            String dob = rs.getString("dob");
            int age = rs.getInt("age");
            int salary= rs.getInt("salary");
            System.out.println(eid + "\t" + ename + "\t" + dob + "\t" + age + "\t" + salary);
        }
	}

}