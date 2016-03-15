package com.mss.app.entity;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BillingAddressList
 */
@WebServlet("/BillingListDetails")
public class BillingAddressList extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  		String addressLine1 = request.getParameter("billLine");
  		System.out.println(addressLine1 + "address line 1 from ajax");
  		List<Address> list = new ArrayList<>();
  		Address address = new Address();
  		
  		try{
			
			Class.forName("org.gjt.mm.mysql.Driver");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/miraclestore_dev","root", "mani@1492");
			
			Statement statement = connection.createStatement();
			
			String selectQuery = "select * from miraclestore_dev.tbl_address where address_line1 like '"+addressLine1+"'";
			
			ResultSet resultSet = statement.executeQuery(selectQuery);
			
			while(resultSet.next()){
				System.out.println(resultSet.getString("state") + "addresslist");		
			
				response.getWriter().write(resultSet.getString("address_id"));
				response.getWriter().write("-");
				response.getWriter().write(resultSet.getString("address_line1"));
				response.getWriter().write("-");
				response.getWriter().write(resultSet.getString("address_line2"));
				response.getWriter().write("-");
				response.getWriter().write(resultSet.getString("city"));
				response.getWriter().write("-");
				response.getWriter().write(resultSet.getString("state"));
				response.getWriter().write("-");
				response.getWriter().write(resultSet.getString("zipcode"));
				
			}	

			response.setContentType("text/html");
			/*response.getWriter().write(address.toString());*/
			
			connection.close();
			return;
						
		
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

  		
	}

	
}
