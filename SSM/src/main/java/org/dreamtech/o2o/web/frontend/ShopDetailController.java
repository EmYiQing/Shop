package org.dreamtech.o2o.web.frontend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dreamtech.o2o.dto.ProductExecution;
import org.dreamtech.o2o.entity.Product;
import org.dreamtech.o2o.entity.ProductCategory;
import org.dreamtech.o2o.entity.Shop;
import org.dreamtech.o2o.service.ProductCategoryService;
import org.dreamtech.o2o.service.ProductService;
import org.dreamtech.o2o.service.ShopService;
import org.dreamtech.o2o.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 店铺详情控制层
 * 
 * @author Xu Yiqing
 *
 */
@Controller
@RequestMapping("frontend")
public class ShopDetailController {

	@Autowired
	private ShopService shopService;

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductCategoryService productCategoryService;

	/**
	 * 获得店铺详情信息
	 * 
	 * @param request
	 *            请求
	 * @return Map<String, Object>
	 */
	@RequestMapping(value = "listshopdetailpageinfo", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> listShopDetailPageInfo(HttpServletRequest request) {

		Map<String, Object> modelMap = new HashMap<String, Object>();
		long shopId = HttpServletRequestUtil.getLong(request, "shopId");
		Shop shop = null;
		List<ProductCategory> productCategoryList = null;

		if (shopId != -1) {

			// 根据ID查询店铺
			shop = shopService.getByShopId(shopId);
			// 根据ID查询商品分类
			productCategoryList = productCategoryService.getProductCategoryList(shopId);

			modelMap.put("shop", shop);
			modelMap.put("productCategoryList", productCategoryList);
			modelMap.put("success", true);
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "empty shopId");
		}
		return modelMap;
	}

	/**
	 * 根据店铺获得商品集合
	 * 
	 * @param request
	 *            请求
	 * @return Map<String, Object>
	 */
	@RequestMapping(value = "listproductsbyshop", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> listProductsByShop(HttpServletRequest request) {

		Map<String, Object> modelMap = new HashMap<String, Object>();

		int pageIndex = HttpServletRequestUtil.getInt(request, "pageIndex");
		int pageSize = HttpServletRequestUtil.getInt(request, "pageSize");
		long shopId = HttpServletRequestUtil.getLong(request, "shopId");
		// 判空
		if ((pageIndex > -1) && (pageSize > -1) && (shopId > -1)) {

			long productCategoryId = HttpServletRequestUtil.getLong(request, "productCategoryId");
			String productName = HttpServletRequestUtil.getString(request, "productName");
			// 封装
			Product productCondition = compactProductCondition4Search(shopId, productCategoryId, productName);
			// 根据条件查询商品列表
			ProductExecution pe = productService.getProductList(productCondition, pageIndex, pageSize);
			modelMap.put("productList", pe.getProductList());
			modelMap.put("count", pe.getCount());
			modelMap.put("success", true);
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "empty pageIndex or pageSize or shopId");
		}
		return modelMap;
	}

	/**
	 * 封装查询条件
	 * 
	 * @param shopId
	 *            店铺ID
	 * @param productCategoryId
	 *            商品分类ID
	 * @param productName
	 *            商品名
	 * @return Product
	 */
	private Product compactProductCondition4Search(long shopId, long productCategoryId, String productName) {
		Product productCondition = new Product();

		if (productCategoryId != -1L) {
			ProductCategory productCategory = new ProductCategory();
			productCategory.setProductCategoryId(productCategoryId);
			productCondition.setProductCategory(productCategory);
		}

		if (productName != null) {
			productCondition.setProductName(productName);
		}

		productCondition.setEnableStatus(1);
		return productCondition;
	}
}
