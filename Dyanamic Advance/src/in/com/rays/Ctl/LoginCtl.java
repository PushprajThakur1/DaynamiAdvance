package in.com.rays.Ctl;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import in.com.rays.bean.UserBean;
import in.com.rays.model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");
		if (op != null && op.equalsIgnoreCase("logout")) {
			HttpSession session = req.getSession();
			session.invalidate();
		}

		RequestDispatcher rd = req.getRequestDispatcher("rd");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String login = req.getParameter("LoginId");
			String pass = req.getParameter("password");
			String uri = req.getParameter("uri");

			UserModel model = new UserModel();

			UserBean bean = model.authenticate(login, pass);

			if (bean != null) {

				HttpSession session = req.getSession();

				session.setAttribute("fname", bean.getFirstname());

				if (uri.equalsIgnoreCase("null")) {
					resp.sendRedirect("Welcom.jsp");

				} else {
					resp.sendRedirect(uri);
				}

			} else {
				//System.out.println("Invalid details");

				req.setAttribute("msg", " Invalid login id  and  password ");

				RequestDispatcher rd = req.getRequestDispatcher("LoginRegistration.jsp");
				rd.forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
