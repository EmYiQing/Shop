package org.dreamtech.o2o.util;

import javax.servlet.http.HttpServletRequest;

import com.google.code.kaptcha.Constants;

/**
 * 验证码校验工具
 * 
 * @author Xu Yiqing
 *
 */
public class CodeUtil {
	/**
	 * 验证码校验
	 * 
	 * @param request
	 *            请求
	 * @return boolean
	 */
	public static boolean checkVerifyCode(HttpServletRequest request) {
		// 获取正确的验证码
		String verifyCodeExpected = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		// 获取请求的验证码
		String verifyCodeActual = HttpServletRequestUtil.getString(request, "verifyCodeActual");
		// 比较
		if (verifyCodeActual == null || !verifyCodeActual.equals(verifyCodeExpected)) {
			return false;
		}
		return true;
	}
}
