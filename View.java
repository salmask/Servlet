

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;


public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p=response.getWriter();
		response.setContentType("text/html");  
		String url="jdbc:mysql://10.11.1.113:3306";
        String dbName="/testdb";
        String driver="com.mysql.jdbc.Driver";
        String user1;
        String ps1;
        try {
			Class.forName(driver).newInstance();
			
			 Connection conn = (Connection) DriverManager.getConnection(url+dbName,"root", "root");
			 HttpSession session=request.getSession();
			String name=(String)session.getAttribute("sname"); 
			
				if(name.equals("see")) {
					
			 user1=request.getParameter("user1");
			 ps1=request.getParameter("ps1");
								String query="select * from registertable where uname=? and password1=?";
				PreparedStatement st=(PreparedStatement) conn.prepareStatement(query);
				
			     st.setString(1, user1);
			     st.setString(2,ps1);
			     ResultSet r=(ResultSet) st.executeQuery();  
			 
			     if(r.next()) {
			    			   
			     p.print("<body><table align='center'><tr>First Name :"+r.getString(1));
			     
			     p.print("<br><br>Last Name :"+r.getString(2));
			     
			     p.println("<br>User Name :"+r.getString(3));
			     p.println("<br>Gender :"+r.getString(4));
			     p.println("<br><br>UID Number :"+r.getString(5));
			     p.println("<br><br>Email ID :"+r.getString(6));
			     p.println("<br><br>Mobile Number :"+r.getString(7));
			     p.println("<br><br>Adress :"+r.getString(8));
			    			 
			     }
			     
				}
				else if(name.equals("delete"))
				{
					 user1=request.getParameter("user1");
					 ps1=request.getParameter("ps1");
										String query1="delete from registertable where uname = ? and password1=?";
						PreparedStatement st=(PreparedStatement) conn.prepareStatement(query1);
						 st.setString(1, user1);
					     st.setString(2,ps1);
					     System.out.println("hai");
					     st.executeUpdate();
					     System.out.println("deleted");
					
				}
				else if(name.equals("update"))
				{
					user1=request.getParameter("user1");
					 ps1=request.getParameter("ps1");
					
					  session.setAttribute("user",user1); 
					  session.setAttribute("pwd",ps1); 
					response.sendRedirect("update.jsp");
				}
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}

}
