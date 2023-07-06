package in.com.rays.Ctl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.com.rays.bean.UserBean;
import in.com.rays.model.UserModel;

@WebServlet("/UserCtl.do")
public class UserCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String Id = req.getParameter("Id");

		UserModel model = new UserModel();
		try {
			UserBean bean = model.findByPK(Integer.parseInt(Id));
			req.setAttribute("bean", bean);

			RequestDispatcher rd = req.getRequestDispatcher("Update.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("Opertion");
		String id = req.getParameter("Id");
		String fname = req.getParameter("firstName");
		String lname = req.getParameter("lastName");
		String loginid = req.getParameter("loginId");
		String pass = req.getParameter("password");
		String address = req.getParameter("address");

		UserBean bean = new UserBean();

		bean.setId(Integer.parseInt(id));
		bean.setFirstname(fname);
		bean.setLastname(lname);
		bean.setLoginid(loginid);
		bean.setPassword(pass);
		bean.setAddress(address);

		UserModel m = new UserModel();
		if (op.equals("Registration")) {

			try {
				m.add(bean);

			} catch (Exception e) {

				e.printStackTrace();

			}
		}

		if (op.equals("Update")) {

			try {
				m.Update(bean);
				resp.sendRedirect("UserListCtl.do");

			} catch (Exception e) {
				e.printStackTrace();

			}

		}

	}

}
