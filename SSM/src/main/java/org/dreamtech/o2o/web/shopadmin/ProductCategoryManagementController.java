package org.dreamtech.o2o.web.shopadmin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dreamtech.o2o.dto.ProductCategoryExecution;
import org.dreamtech.o2o.dto.Result;
import org.dreamtech.o2o.entity.ProductCategory;
import org.dreamtech.o2o.entity.Shop;
import org.dreamtech.o2o.enums.ProductCategoryStateEnum;
import org.dreamtech.o2o.exceptions.ProductCategoryOperationException;
import org.dreamtech.o2o.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品分类控制器
 * 
 * @author Xu Yiqing
 *
 */
@Controller
@RequestMapping("shopadmin")
public class ProductCategoryManagementController {

	@Autowired
	private ProductCategoryService productCategoryService;

	/**
	 * 获得商品分类列表
	 * 
	 * @param request
	 *            请求
	 * @return Result<List<ProductCategory>>
	 */
	@RequestMapping(value = "getproductcategorylist", method = RequestMethod.GET)
	@ResponseBody
	private Result<List<ProductCategory>> getProductCategoryList(HttpServletRequest request) {
		Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
		List<ProductCategory> list = null;

		if (currentShop != null && currentShop.getShopId() > 0) {
			list = productCategoryService.getProductCategoryList(currentShop.getShopId());
			return new Result<List<ProductCategory>>(true, list);
		} else {
			ProductCategoryStateEnum ps = ProductCategoryStateEnum.INNER_ERROR;
			return new Result<List<ProductCategory>>(false, ps.getState(), ps.getStateInfo());
		}
	}

	/**
	 * 添加商品分类
	 * 
	 * @param productCategoryList
	 *            商品分类列表
	 * @param request
	 *            请求
	 * @return Map<String, Object>
	 */
	@RequestMapping(value = "addproductcategorys", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> addProductCategorys(@RequestBody List<ProductCategory> productCategoryList,
			HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");

		for (ProductCategory pc : productCategoryList) {
			pc.setShopId(currentShop.getShopId());
		}

		if (productCategoryList != null && productCategoryList.size() > 0) {

			try {
				ProductCategoryExecution pe = productCategoryService.batchAddProductCategory(productCategoryList);
				if (pe.getState() == ProductCategoryStateEnum.SUCCESS.getState()) {
					modelMap.put("success", true);
				} else {
					modelMap.put("success", false);
					modelMap.put("errorMsg", pe.getStateInfo());
				}
			} catch (ProductCategoryOperationException e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.getMessage());
			}

		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "商品类别集合为空");
		}
		return modelMap;
	}

	/**
	 * 移除商品分类
	 * 
	 * @param productCategoryId
	 *            商品分类ID
	 * @param request
	 *            请求
	 * @return Map<String, Object>
	 */
	@RequestMapping(value = "removeproductcategory", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> removeProductCategory(Long productCategoryId, HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();

		if (productCategoryId != null && productCategoryId >= 0) {
			try {
				Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");

				ProductCategoryExecution pe = productCategoryService.deleteProductCategory(productCategoryId,
						currentShop.getShopId());

				if (pe.getState() == ProductCategoryStateEnum.SUCCESS.getState()) {
					modelMap.put("success", true);
				} else {
					modelMap.put("success", false);
					modelMap.put("errMsg", pe.getStateInfo());
				}
			} catch (ProductCategoryOperationException e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.getMessage());
			}
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "请选择分类");
		}
		return modelMap;
	}
}
