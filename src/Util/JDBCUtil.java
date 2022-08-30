package Util;

import java.sql.*;

/**
 *
 * 功能描述:封装一个jdbc工具类
 *
 * 主要有一个方法：
 * 1、增删改executeUpdate（sql obj）
 * 2、查询executeQuery（sql obj）
 * 这两个方法都要求传入两个参数：
 * 第一个参数：sql--是要操作的sql语句
 * 第二个参数：obj[]--是一个数组，是占位符(取代号)
 *
 * jdbc操作步骤：
 * 1、加载驱动
 * 2、获得链接
 * 3、得到发送sql对象
 * 4、发送sql语句
 * 5、得到结果集
 * 6、关闭资源
 *
 */
public class JDBCUtil {

	private static String drivier = "com.mysql.jdbc.Driver"; //jdbc驱动位置
	private static String url = "jdbc:mysql://localhost:3306/store?useUnicode=true&characterEncoding=UTF-8";// url地址
	private static String user = "root";// 用户名
	private static String password = "kk200088";// 密码.如果没有密码就是""
	private static Connection ct;// 连接对象
	private static ResultSet rs;// 返回数据对象
	private static PreparedStatement ps;// 执行sql语句对象

	// 1.因为加载驱动只需要一次,所以最好放在静态代码块中
	static {

//		 * 1.加载驱动,用反射加载驱动
		try {
			Class.forName(drivier);
		} catch (ClassNotFoundException e) {//处理异常
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 2.单独封装一个方法用来获得连接

	public static Connection getConnection() {
//		 * 2.获得连接:getConnection(String url, String user, String password)
//	        试图建立到给定数据库 URL 的连接。
		try {
			ct = DriverManager.getConnection(url, user, password);// url:url地址,user用户名,password:密码
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ct;
	}

	// 3.封装一个查询的方法
	public static ResultSet executeQuery(String sql, Object... obj) {

		// 获得连接
		getConnection();
		// 得到发送对象
		try {
			ps = ct.prepareStatement(sql);

			// 处理占位符
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i + 1, obj[i]);
				}

			}

			// 发送sql语句
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

	// 4.封装一个增删改的方法

	public static int executeUpdate(String sql, Object... obj) {
		int in = 0;
		// 获得连接
		getConnection();
		// 得到发送对象
		try {
			ps = ct.prepareStatement(sql);

			// 处理占位符
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i + 1, obj[i]);
				}

			}

			// 发送sql语句
			in = ps.executeUpdate();
			//关闭资源
			close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return in;
	}

	// 封装一个关闭资源的方法
	public static void close() {
		try {
			if (rs != null) {
				rs.close();
			}

			if (ps != null) {
				ps.close();
			}

			if (ct != null) {
				ct.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}

			if (ps != null) {
				ps.close();
			}

			if (ct != null) {
				ct.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
