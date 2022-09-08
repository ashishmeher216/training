package com.employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Scanner;

//import org.graalvm.compiler.lir.alloc.SaveCalleeSaveRegisters;

public class App {

	public static void main(String[] args) throws SQLException {
		Scanner s = new Scanner(System.in);
		try {
			while(true) {
				int option;	
				System.out.println("--------------------------------\n");
				System.out.println("SELECT FROM THE OPTIONS BELOW!!");
				System.out.println("1. Add Employee");
				System.out.println("2. Update Employee Salary");
				System.out.println("3. Delete Employee");
				System.out.println("4. Get Employee by ID");
				System.out.println("5. Get All Employee");
				System.out.println("6. EXIT");
				
				option = s.nextInt();
				
				switch (option) {
					case 1:
						save();
						break;
					case 2:
						update();
						break;
					case 3:
						delete();
						break;
					case 4:
						getEmpById();
						break;
					case 5:
						getAllEmp();
						break;
					case 6:
						return;
					default:
						System.out.println("Please enter a valid option!");
						break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("```````````````````````````");
			if(Utility.conn!=null) {
				Utility.closeConnection();
				System.out.println("Connection Closed");
			}
			s.close();
		}
	}

	private static void save() throws SQLException, ParseException {
		Scanner scanner = new Scanner(System.in);

		Employee emp = new Employee();
		System.out.println("Emp ID: ");
		emp.setEid(scanner.nextInt());
		System.out.println("Emp Name: ");
		emp.setEname(scanner.next());
		System.out.println("Emp DOB: ");
		String dob = scanner.next();
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//	    Date date = formatter.parse(dob);
//		emp.setDob(date);
		emp.setDob(dob);
		System.out.println("Emp Age: ");
		emp.setAge(scanner.nextInt());
		System.out.println("Emp Salary: ");
		emp.setSalary(scanner.nextInt());
		scanner.close();
		DAO.saveEmp(emp);

	}

	private static void getEmpById() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		Employee emp = new Employee();
		System.out.println("Emp ID: ");
		emp.setEid(scanner.nextInt());

		scanner.close();
		DAO.getEmpById(emp);

	}

	private static void getAllEmp() throws SQLException {
		DAO.getAllEmp();
	}

	private static void update() throws SQLException {

		Scanner scanner = new Scanner(System.in);
		Employee emp = new Employee();
		System.out.println("Emp ID: ");
		emp.setEid(scanner.nextInt());
		System.out.println("Emp Salary: ");
		emp.setSalary(scanner.nextInt());

		scanner.close();
		DAO.updateEmp(emp);
	}

	private static void delete() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		Employee emp = new Employee();
		System.out.println("Emp ID: ");
		emp.setEid(scanner.nextInt());

		scanner.close();
		DAO.deleteEmp(emp);

	}
}
