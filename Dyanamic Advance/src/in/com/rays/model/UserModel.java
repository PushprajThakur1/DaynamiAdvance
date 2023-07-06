package in.com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;

import in.com.rays.bean.UserBean;
import in.com.rays.util.JDBCDataSource;

public class UserModel {

	public Integer nextPk() throws Exception {

		int Pk = 0;

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("Select max(id) from user ");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			Pk = rs.getInt(1);

		}

		return Pk + 1;

	}

	public void add(UserBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement("insert into user values (? , ? , ? , ? , ? , ?) ");

		ps.setInt(1, nextPk());
		ps.setString(2, bean.getFirstname());
		ps.setString(3, bean.getLastname());
		ps.setString(4, bean.getLoginid());
		ps.setString(5, bean.getPassword());
		ps.setString(6, bean.getAddress());

		int i = ps.executeUpdate();
		// System.out.println("Data inserted" + i );

		conn.commit();
		conn.close();

		System.out.println("data inserted = " + 1);

	}

	public void Update(UserBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(
				"Update user set firstname = ? , lastname =? ,login_id =  ? , password = ? , address = ? where id = ?");

		ps.setString(1, bean.getFirstname());
		ps.setString(2, bean.getLastname());
		ps.setString(3, bean.getLoginid());
		ps.setString(4, bean.getPassword());
		ps.setString(5, bean.getAddress());
		ps.setInt(6, bean.getId());

		int i = ps.executeUpdate();
		System.out.println("data update = " + i);

	}

	public UserBean authenticate(String LoginId, String password) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("select * from user where login_id = ? and password = ?");

		ps.setString(1, LoginId);
		ps.setString(2, password);

		ResultSet rs = ps.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLoginid(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));

		}
		return bean;

	}

	public ArrayList Search(UserBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		StringBuffer sbf = new StringBuffer("select * from user where 1=1");

		if (bean != null) {
			if (bean.getId() > 0) {
				sbf.append(" and id = " + bean.getId());
			}
			if (bean.getFirstname() != null && bean.getFirstname().length() > 0) {
				sbf.append("and name like " + bean.getFirstname());

			}
			if (bean.getLastname() != null && bean.getLastname().length() > 0) {
				sbf.append("and name like" + bean.getLastname() + "%");

			}

		}

		PreparedStatement ps = conn.prepareStatement(sbf.toString());
		ResultSet rs = ps.executeQuery();

		ArrayList list = new ArrayList();
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLoginid(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));

			list.add(bean);
		}

		return list;

	}

	public List Search() throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("select * from user");

		ResultSet rs = ps.executeQuery();

		ArrayList list = new ArrayList();

		while (rs.next()) {
			UserBean Bean = new UserBean();
			Bean.setId(rs.getInt(1));
			Bean.setFirstname(rs.getString(2));
			Bean.setLastname(rs.getString(3));
			Bean.setLoginid(rs.getString(4));
			Bean.setPassword(rs.getString(5));
			Bean.setAddress(rs.getString(6));

			list.add(Bean);
		}

		return list;

	}

	public UserBean findByPK(int id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("Select * from user where id = ?");
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();
		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLoginid(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));

		}

		return bean;

	}
}
