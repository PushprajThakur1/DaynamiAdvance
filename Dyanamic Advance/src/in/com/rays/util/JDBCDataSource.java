package in.com.rays.util;

import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCDataSource {

	private ComboPooledDataSource ds = null;
	private static JDBCDataSource jds = null;

	private JDBCDataSource() {

		try {

			ds = new ComboPooledDataSource();
			ds.setDriverClass("com.mysql.cj.jdbc.Driver");
			ds.setJdbcUrl("jdbc:mysql://localhost:3306/advance");
			ds.setUser("root");
			ds.setPassword("root");
			ds.setInitialPoolSize(5);
			ds.setAcquireIncrement(5);
			ds.setMaxPoolSize(50);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static JDBCDataSource getInsatance() {

		if (jds == null) {
			jds = new JDBCDataSource();

		}
		return jds;

	}

	public static Connection getConnection() {

		try {

			return getInsatance().ds.getConnection();

		} catch (Exception e) {
			return null;

		}
		
	}
}
