package org.dreamtech.o2o.web.local;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户路由模块处理
 * 
 * @author Xu Yiqing
 *
 */
@Controller
@RequestMapping("local")
public class LocalController {

	/**
	 * 注册
	 * 
	 * @return String
	 */
	@RequestMapping(value = "register", method = RequestMethod.GET)
	private String accountbind() {
		return "local/register";
	}

	/**
	 * 更改密码
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/changepsw", method = RequestMethod.GET)
	private String changepsw() {
		return "local/changepsw";
	}

	/**
	 * 登陆
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	private String login() {
		return "local/login";
	}
}
