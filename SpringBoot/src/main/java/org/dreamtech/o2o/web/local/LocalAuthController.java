package org.dreamtech.o2o.web.local;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dreamtech.o2o.dto.PersonInfoExecution;
import org.dreamtech.o2o.entity.PersonInfo;
import org.dreamtech.o2o.enums.PersonInfoStateEnum;
import org.dreamtech.o2o.exceptions.PersonInfoOperationException;
import org.dreamtech.o2o.service.PersonInfoService;
import org.dreamtech.o2o.util.CodeUtil;
import org.dreamtech.o2o.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户控制层
 * 
 * @author Xu Yiqing
 *
 */
@Controller
@RequestMapping("local")
public class LocalAuthController {

	@Autowired
	private PersonInfoService personInfoService;

	/**
	 * 注册用户
	 * 
	 * @param request
	 *            请求
	 * @return Map<String, Object>
	 */
	@RequestMapping(value = "registerpersonInfo", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> registerpersonInfo(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 验证码校验
		if (!CodeUtil.checkVerifyCode(request)) {
			modelMap.put("success", false);
			modelMap.put("errMsg", "输入了错误的验证码");
			return modelMap;
		}

		String userName = HttpServletRequestUtil.getString(request, "userName");
		String password = HttpServletRequestUtil.getString(request, "password");
		String userType = HttpServletRequestUtil.getString(request, "userType");
		// 判空
		if (userName != null && password != null) {
			PersonInfo personInfo = new PersonInfo();

			personInfo.setUsername(userName);
			personInfo.setPassword(password);

			if (userType.equals(String.valueOf(PersonInfo.CUSTOMER.toString()))) {
				personInfo.setUserType(PersonInfo.CUSTOMER);
			}
			if (userType.equals(String.valueOf(PersonInfo.SHOP_ADMIN.toString()))) {
				personInfo.setUserType(PersonInfo.SHOP_ADMIN);
			}

			personInfo.setEnableStatus(PersonInfo.ENABLED);
			PersonInfoExecution pe = personInfoService.register(personInfo);
			if (pe.getState() == PersonInfoStateEnum.SUCCESS.getState()) {
				modelMap.put("success", true);
			} else {
				modelMap.put("success", false);
				modelMap.put("errMsg", pe.getStateInfo());
			}
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "用户名和密码均不能为空");
		}
		return modelMap;
	}

	/**
	 * 更改密码
	 * 
	 * @param request
	 *            请求
	 * @return Map<String, Object>
	 */
	@RequestMapping(value = "changelocalpwd", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> changeLocalPwd(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();

		if (!CodeUtil.checkVerifyCode(request)) {
			modelMap.put("success", false);
			modelMap.put("errMsg", "输入了错误的验证码");
			return modelMap;
		}

		String userName = HttpServletRequestUtil.getString(request, "userName");
		String password = HttpServletRequestUtil.getString(request, "password");
		String newPassword = HttpServletRequestUtil.getString(request, "newPassword");
		PersonInfo user = (PersonInfo) request.getSession().getAttribute("user");

		if (userName != null && password != null && newPassword != null && user != null && user.getUserId() != null
				&& !password.equals(newPassword)) {
			try {
				PersonInfo personInfo = personInfoService.getPersonInfoByUserId(user.getUserId());

				if (personInfo == null || !personInfo.getUsername().equals(userName)) {
					modelMap.put("success", false);
					modelMap.put("errMsg", "输入的帐号非本次登录的帐号");
					return modelMap;
				}

				PersonInfoExecution le = personInfoService.modifyPersonInfo(user.getUserId(), userName, password,
						newPassword);

				if (le.getState() == PersonInfoStateEnum.SUCCESS.getState()) {
					modelMap.put("success", true);
				} else {
					modelMap.put("success", false);
					modelMap.put("errMsg", le.getStateInfo());
				}

			} catch (PersonInfoOperationException e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.toString());
				return modelMap;
			}

		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "请输入密码");
		}
		return modelMap;
	}

	/**
	 * 登陆
	 * 
	 * @param request
	 *            请求
	 * @return Map<String, Object>
	 */
	@RequestMapping(value = "logincheck", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> logincheck(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		boolean needVerify = HttpServletRequestUtil.getBoolean(request, "needVerify");

		if (needVerify && !CodeUtil.checkVerifyCode(request)) {
			modelMap.put("success", false);
			modelMap.put("errMsg", "输入了错误的验证码");
			return modelMap;
		}

		String userName = HttpServletRequestUtil.getString(request, "userName");
		String password = HttpServletRequestUtil.getString(request, "password");

		if (userName != null && password != null) {
			PersonInfo personInfo = personInfoService.getPersonInfoByUsernameAndPwd(userName, password);
			if (personInfo != null) {
				modelMap.put("success", true);
				request.getSession().setAttribute("user", personInfo);
			} else {
				modelMap.put("success", false);
				modelMap.put("errMsg", "用户名或密码错误");
			}
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "用户名和密码均不能为空");
		}
		return modelMap;
	}

	/**
	 * 当用户点击登出按钮的时候注销session
	 * 
	 * @param request
	 *            请求
	 * @return Map<String, Object>
	 */
	@RequestMapping(value = "logout", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> logout(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		request.getSession().setAttribute("user", null);
		modelMap.put("success", true);
		return modelMap;
	}
}
