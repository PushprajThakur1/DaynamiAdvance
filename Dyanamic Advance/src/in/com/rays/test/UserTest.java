package in.com.rays.test;

import in.com.rays.bean.UserBean;
import in.com.rays.model.UserModel;

public class UserTest {

	public static void main(String[] args) throws Exception {

		testadd();

	}

	private static void testadd() throws Exception {

		UserBean bean = new UserBean();

		bean.setFirstname("Pushpraj");
		bean.setLastname("Thakur");
		bean.setLoginid("pushprajt115@gamil.com");
		bean.setPassword("pushpraj@123");
		bean.setAddress("Indore");

		UserModel M = new UserModel();
		M.add(bean);

	}

}
