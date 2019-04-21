package org.dreamtech.o2o.web.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 前端路由处理控制层
 * 
 * @author Xu Yiqing
 *
 */
@Controller
@RequestMapping(value = "frontend", method = RequestMethod.GET)
public class FrontendController {

	/**
	 * 首页
	 * 
	 * @return String
	 */
	@RequestMapping("index")
	private String index() {
		return "frontend/index";
	}

	/**
	 * 店铺列表
	 * 
	 * @return String
	 */
	@RequestMapping(value = "shoplist", method = RequestMethod.GET)
	private String shopList() {
		return "frontend/shoplist";
	}

	/**
	 * 店铺详情
	 * 
	 * @return String
	 */
	@RequestMapping(value = "shopdetail", method = RequestMethod.GET)
	private String shopDetail() {
		return "frontend/shopdetail";
	}

	/**
	 * 商品详情
	 * 
	 * @return String
	 */
	@RequestMapping(value = "productdetail", method = RequestMethod.GET)
	private String productDetail() {
		return "frontend/productdetail";
	}
}
