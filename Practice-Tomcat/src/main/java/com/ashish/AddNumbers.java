package com.ashish;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddNumbers extends HttpServlet{
	
		public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
			int num1 = Integer.parseInt(req.getParameter("num1"));
			int num2 = Integer.parseInt(req.getParameter("num2"));
			
			System.out.println("result is : "+ (num1+num2));
			PrintWriter pw = res.getWriter();
			pw.println("result is : "+ (num1+num2));
		}

}
