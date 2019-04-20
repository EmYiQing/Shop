package org.dreamtech.o2o.dao.split;

/**
 * 辅助进行读写分离操作
 * 
 * @author Xu Yiqing
 *
 */
public class DynamicDataSourceHolder {
	private static ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	public static final String DB_MASTER = "master";
	public static final String DB_SLAVE = "slave";

	/**
	 * 获取dbType
	 * 
	 * @return dbType
	 */
	public static String getDbType() {
		String db = contextHolder.get();
		if (db == null) {
			db = DB_MASTER;
		}
		return db;
	}

	/**
	 * 设置线程的dbType
	 * 
	 * @param str
	 *            类型
	 */
	public static void setDbType(String str) {
		contextHolder.set(str);
	}

	/**
	 * 清理连接类型
	 */
	public static void clearDBType() {
		contextHolder.remove();
	}

}
