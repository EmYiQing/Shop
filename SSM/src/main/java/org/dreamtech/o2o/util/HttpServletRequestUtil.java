package org.dreamtech.o2o.util;

import javax.servlet.http.HttpServletRequest;

/**
 * HTTP请求参数处理工具
 * 
 * @author Xu Yiqing
 *
 */
public class HttpServletRequestUtil {

	/**
	 * 获得INT型参数
	 * 
	 * @param request
	 *            请求
	 * @param name
	 *            参数名
	 * @return int
	 */
	public static int getInt(HttpServletRequest request, String name) {

		try {
			return Integer.decode(request.getParameter(name));
		} catch (Exception e) {
			return -1;
		}

	}

	/**
	 * 获得long型参数
	 * 
	 * @param request
	 *            请求
	 * @param name
	 *            参数名
	 * @return long
	 */
	public static long getLong(HttpServletRequest request, String name) {

		try {
			return Long.valueOf(request.getParameter(name));
		} catch (Exception e) {
			return -1;
		}

	}

	/**
	 * 获得Double型参数
	 * 
	 * @param request
	 *            请求
	 * @param name
	 *            参数名
	 * @return double
	 */
	public static Double getDouble(HttpServletRequest request, String name) {

		try {
			return Double.valueOf(request.getParameter(name));
		} catch (Exception e) {
			return -1d;
		}

	}

	/**
	 * 获得boolean型参数
	 * 
	 * @param request
	 *            请求
	 * @param name
	 *            参数名
	 * @return boolean
	 */
	public static Boolean getBoolean(HttpServletRequest request, String name) {

		try {
			return Boolean.valueOf(request.getParameter(name));
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * 获得String型参数
	 * 
	 * @param request
	 *            请求
	 * @param name
	 *            参数名
	 * @return String
	 */
	public static String getString(HttpServletRequest request, String name) {

		try {
			String result = request.getParameter(name);
			if (result != null) {
				result = result.trim();
			}
			if ("".equals(result))
				result = null;
			return result;
		} catch (Exception e) {
			return null;
		}
		
	}
}