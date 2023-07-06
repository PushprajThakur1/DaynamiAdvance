
package in.com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.com.rays.bean.AddDateBean;
import in.com.rays.util.JDBCDataSource;

public class AddDateModel {

	public static void AddDate(AddDateBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("insert into person values(?)");
		ps.setDate(1, new java.sql.Date(bean.getDob().getTime()));

		int i = ps.executeUpdate();
		System.out.println("Data inserted = " + 1);
		conn.close();
	}

}
