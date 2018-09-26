

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class change extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		String cemailid,caddress,cpassword1,user1,ps1;
		long cmobno;
        PrintWriter pw = response.getWriter(); 
    
        String url="jdbc:mysql://10.11.1.113:3306";
        String dbName="/testdb";
        String driver="com.mysql.jdbc.Driver";
        Connection conn;
		try {
			conn = (Connection) DriverManager.getConnection(url+dbName,"root", "root");
			HttpSession session=request.getSession();
			String  s=(String) session.getAttribute("user");
			 cemailid=request.getParameter("cemailid");
			 cmobno=Long.parseLong(request.getParameter("cmobno"));
			 caddress=request.getParameter("caddress");
			 cpassword1=request.getParameter("cpassword1");
			
			 
			
	        String query2 = "UPDATE registertable SET emailid=?,mobno=?,addres=?,password1=?where  uname=?";
	        
	        PreparedStatement st = (PreparedStatement) conn.prepareStatement(query2);
	        st.setString(1,cemailid); 
	        st.setLong(2,cmobno);
	        st.setString(3,caddress);
	        st.setString(4,cpassword1); 
	        st.setString(5,s);
	       
	             
	        st.executeUpdate();
	        
pw.println("Succesessfully updated your data...");
response.sendRedirect("view.jsp");
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
