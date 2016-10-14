package org.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.concurrent.atomic.AtomicLong;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.impl.NewProxyPreparedStatement;

/**
 * hejinbin , QQ 107966750, C3P0的测试用例 2016-10-13
 */
public class C3P0Test {
	public static AtomicLong id = new AtomicLong(1000000);
	private static ComboPooledDataSource cpds = new ComboPooledDataSource();

	public static Long queryTest() throws Exception {
		Long aid = null;
		Connection con = null;
		try {
			// 从C3P0获取连接
			con = cpds.getConnection();
			NewProxyPreparedStatement prepare = (NewProxyPreparedStatement) con
					.prepareStatement("select * from tbl_account_info where account_id = ?");
			prepare.setLong(1, 1001203);
			ResultSet result = prepare.executeQuery();
			if (result.next()) {
				aid = (result.getLong("aid"));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			// 此处关闭已经被C3P0重写， 只是返还连接池
			con.close();
		}

		return aid;
	}

	public static void insertTest() throws Exception {

		Connection con = null;
		try {
			// 从C3P0获取连接
			con = cpds.getConnection();
			NewProxyPreparedStatement prepare = (NewProxyPreparedStatement) con.prepareStatement(
					"INSERT INTO `tbl_account_info` VALUES (?, '1000000', '充值中心', '12312312', '15018711111', 'hejinbin@qq.com', '1', 'hjb_recharge', 'yid:12312312', '1', '', '', '', '1399882974', '1429785062', '183.60.177.229', '1464658277', '14.29.83.74', '0', '0', '1', '0', '2', '1', '0', '1', '1', '1', '1', '1', '1', '1', '', '', '2000', '0', '0', '0', '2000', '6', '0', '0', '1', '0', '1456308697', '658', null, '广东广州', '0', '0', '0', '0', '20', null, null, '1', null, '');");
			prepare.setLong(1, id.incrementAndGet());
			prepare.execute();
		} catch (Exception e) {
			throw e;
		} finally {
			// 此处关闭已经被C3P0重写， 只是返还连接池

			con.close();
		}

	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 100000; i++)
			insertTest();
	}
}
