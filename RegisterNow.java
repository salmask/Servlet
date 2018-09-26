

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
public class RegisterNow extends HttpServlet {
	String fname;
	String lname;
	String uname;
	String emailid;
	String password1;
	long x;
	String password2;
	int i;
	String gen;
	String addres;
	long uid;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter pw = response.getWriter(); 
    
        String url="jdbc:mysql://10.11.1.113:3306";
        String dbName="/testdb";
        String driver="com.mysql.jdbc.Driver";

				  try {
			  fname=request.getParameter("fname");
			  
				 lname=request.getParameter("lname");
				 
					 uname=request.getParameter("uname");
					 gen=request.getParameter("gen");
					
					uid =Long.parseLong( request.getParameter("uid"));
				 emailid=request.getParameter("emailid");
				
				 x=Long.parseLong(request.getParameter("mobno"));
				 addres = request.getParameter("address");
				
					 password1=request.getParameter("password1");
					
				 password2=request.getParameter("password2");
				 
			Class.forName(driver).newInstance();
Connection conn = (Connection) DriverManager.getConnection(url+dbName,"root", "root");
	 PreparedStatement pst =((java.sql.Connection) conn).prepareStatement("insert into registertable values(?,?,?,?,?,?,?,?,?,?)");  

	          pst.setString(1,fname);  
	          pst.setString(2,lname);        
	          pst.setString(3,uname);
	          pst.setString(4,gen);
	          pst.setLong(5,uid);
	          pst.setString(6,emailid);
	          pst.setLong(7,x);
	          pst.setString(8,addres);
	          pst.setString(9,password1);
	          pst.setString(10,password2);
	     i = pst.executeUpdate();
	     pw.print("Successfully registered with us...");
	     response.sendRedirect("view.jsp");
	     
	     
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  	
	
	
	}

}
