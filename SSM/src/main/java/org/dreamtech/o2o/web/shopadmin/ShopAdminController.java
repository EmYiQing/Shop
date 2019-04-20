package org.dreamtech.o2o.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 店铺管理员路由处理
 * 
 * @author Xu Yiqing
 *
 */
@Controller
@RequestMapping(value = "shopadmin", method = RequestMethod.GET)
public class ShopAdminController {

	/**
	 * 店铺操作页面
	 * 
	 * @return String
	 */
	@RequestMapping(value = "shopoperation")
	public String shopOperation() {
		return "shop/shopoperation";
	}

	/**
	 * 店铺列表页面
	 * 
	 * @return String
	 */
	@RequestMapping(value = "shoplist")
	public String shopList() {
		return "shop/shoplist";
	}

	/**
	 * 店铺管理页面
	 * 
	 * @return String
	 */
	@RequestMapping(value = "shopmanagement")
	public String shopManagement() {
		return "shop/shopmanagement";
	}

	/**
	 * 商品分类管理页面
	 * 
	 * @return String
	 */
	@RequestMapping(value = "productcategorymanagement")
	public String productCategoryManagement() {
		return "shop/productcategorymanagement";
	}

	/**
	 * 商品操作页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "productoperation")
	public String productOperation() {
		return "shop/productoperation";
	}

	/**
	 * 商品管理页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "productmanagement")
	public String productManagement() {
		return "shop/productmanagement";
	}
}
