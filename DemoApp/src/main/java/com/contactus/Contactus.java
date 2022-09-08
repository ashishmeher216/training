package com.contactus;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Contactus extends HttpServlet {
    public Connection connectDb() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","Helloworld@c++loveyou3000");
        return con;
    }
            
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
    {
        String name=req.getParameter("yourname");
        String mail=req.getParameter("yourmail");
        String message=req.getParameter("yourmessage");
        System.out.println(name+" "+mail+" "+message);
        
        PrintWriter ans=res.getWriter();
        
            Connection con;
            try {
                con = connectDb();
                PreparedStatement ps = con.prepareStatement("insert into feedback values(?,?,?)");
                ps.setString(1,name);
                ps.setString(2,mail);
                ps.setString(3,message);
                int c = ps.executeUpdate();
                if(c==1)
                {
                	ans.println("your response has been recorded");
                	System.out.println(c + " record updated");
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
            	ans.println("Something Went Wrong!");
                e.printStackTrace();
            }
    
    }
    
}