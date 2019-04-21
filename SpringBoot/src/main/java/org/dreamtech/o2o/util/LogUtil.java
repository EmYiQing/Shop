package org.dreamtech.o2o.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义日志工具
 * 
 * @author Xu Yiqing
 *
 */
public class LogUtil {

	public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 打印日志
	 * 
	 * @param log 日志信息
	 */
	public static void log(String log) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_PATTERN);
		System.out.println("[---" + sdf.format(new Date()) + " : " + log + "---]");
	}
}
