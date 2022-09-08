package com.loginregistration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/registration")
public class Registration extends HttpServlet {
	public static String vowelsChecker(String str) {
		String r = "";
		for (int i = 0; i < str.length(); i++) {
			if ("AEIOUaeiou".contains(String.valueOf(str.charAt(i)))) {
				r = r + str.charAt(i);
			}
		}
		return r;
	}

	public static int sumOfIntegers(String str) {
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				sum += Character.getNumericValue(str.charAt(i));
			}
		}
		return sum;
	}

	public static String createPwd(String fname, String lname, String mobile, String idproof, String dob) {
		String res = "";
		char firstChar = lname.charAt(0);
		char lastChar = fname.charAt(fname.length() - 1);
		String mobileOdd = "";
		for (int i = 0; i < mobile.length(); i = i + 2) {
			mobileOdd += mobile.charAt(i);
		}

		String vowels = vowelsChecker(idproof);
		int sumOfIdProof = sumOfIntegers(idproof) % 9;
		int sumOfDob = sumOfIntegers(dob) % 9;
		res = String.valueOf(firstChar) + String.valueOf(lastChar) + mobileOdd + vowels + Integer.toString(sumOfIdProof)
				+ Integer.toString(sumOfDob);

		return res;
	}

	public static String createUname(String fname, String idproof) {
		String uname = fname + idproof.substring(idproof.length() - 4, idproof.length());
		System.out.println(uname);
		return uname;
	}

	public static String removeSpecialCharacterFromDate(String input) {
		String str;
		str = input.replaceAll("[^a-zA-Z0-9]", "");
		return str;
	}

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		String username = request.getParameter("name");
		String password = request.getParameter("password");
		boolean isLogin = false;

		String url = "jdbc:mysql://localhost/Ecommerce";
		String db_uname = "root";
		String db_pass = "Askme216lovec++@helloworld";
		Connection con;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, db_uname, db_pass);

			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String mobile = request.getParameter("mobile");
			String idproof = request.getParameter("idproof");
			String dob = request.getParameter("dob");
			String email = request.getParameter("email");

			String uname = createUname(fname, idproof);
			String pwd = createPwd(fname, lname, mobile, idproof, dob);

			PreparedStatement ps = con.prepareStatement(
					"insert into users(fname,lname,mobile,idproof,dob,email,uname,pwd) values(?,?,?,?,?,?,?,?)");
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, mobile);
			ps.setString(4, idproof);
			ps.setString(5, dob);
			ps.setString(6, email);
			ps.setString(7, uname);
			ps.setString(8, pwd);
			int c = ps.executeUpdate();
//			HttpSession session=request.getSession();
//			session.setAttribute("newUname", newuName);
//			session.setAttribute("newPass", newPass);
//			response.sendRedirect("NewUserCredentials.html");
			out.println("Congratulations, your registration is successful!");
			out.println("Your credentials are");
			out.println("Username  " + uname);
			out.println("Password  " + pwd);
//			response.setContentType("text/html");
//			out.println("<a href=\"http://localhost:8080/E-commerse/registration.html\" >You can LogIn now</a>");

		} catch (SQLException e1) {
			if (e1 instanceof SQLIntegrityConstraintViolationException) {
				out.println("Email is already registered!");
			} else {
				out.println("Database error! Please contact the suport team.");
			}
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			out.println("Class Not Found Exception! Please contact the suuport team.");
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
