package in.com.rays.Ctl;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Firstctl")
public class FirstCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("do get");

		String fname = req.getParameter("FirstName");
		String lname = req.getParameter("LastName");

		System.out.println(fname);
		System.out.println(lname);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println(" do post ");

		String fname = req.getParameter("FirstName");
		String lname = req.getParameter("LastName");

		System.out.println(fname);
		System.out.println(lname);


		RequestDispatcher rd = req.getRequestDispatcher("SecondCtl");
		req.setAttribute("Hello", "How are you ");
		rd.forward(req, resp);
	}

}
