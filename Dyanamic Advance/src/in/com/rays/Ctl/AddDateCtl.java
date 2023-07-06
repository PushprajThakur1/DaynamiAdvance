package in.com.rays.Ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.com.rays.bean.AddDateBean;
import in.com.rays.model.AddDateModel;

@WebServlet("/AddDateCtl")
public class AddDateCtl extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		AddDateBean bean = new AddDateBean();
		String dob = req.getParameter("dob");

		System.out.println(dob);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date d = sdf.parse(dob);
			bean.setDob(d);
			AddDateModel.AddDate(bean);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
