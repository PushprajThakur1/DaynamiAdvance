package in.com.rays.Ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ThirdCtl")
public class ThirdCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("in do get");

		String fname = req.getParameter("firstName");
		String lname = req.getParameter("lastName");

		System.out.println("pushpraj");
		System.out.println("thakur");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("in do post of FirstCtl");
		
		String fname = req.getParameter("firstName");
		String lname = req.getParameter("lastName");
		
		String txt = (String) req.getAttribute("Hello");
		System.out.println(txt);
		
		
		System.out.println(fname);
		System.out.println(lname);
	}

}
