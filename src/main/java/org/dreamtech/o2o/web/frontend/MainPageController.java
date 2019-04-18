package org.dreamtech.o2o.web.frontend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dreamtech.o2o.entity.HeadLine;
import org.dreamtech.o2o.entity.ShopCategory;
import org.dreamtech.o2o.service.HeadLineService;
import org.dreamtech.o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 主页控制层
 * 
 * @author Xu Yiqing
 *
 */
@Controller
@RequestMapping("frontend")
public class MainPageController {

	@Autowired
	private ShopCategoryService shopCategoryService;

	@Autowired
	private HeadLineService headLineService;

	/**
	 * 主页
	 * 
	 * @return
	 */
	@RequestMapping(value = "listmainpageinfo", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> listMainPageInfo() {

		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<ShopCategory> shopCategoryList = new ArrayList<ShopCategory>();

		try {
			// 获得店铺最高分类
			shopCategoryList = shopCategoryService.getShopCategoryList(null);
			modelMap.put("shopCategoryList", shopCategoryList);

		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
			return modelMap;
		}
		
		List<HeadLine> headLineList = new ArrayList<HeadLine>();
		
		try {
			
			HeadLine headLineCondition = new HeadLine();
			headLineCondition.setEnableStatus(HeadLine.ENABLED);
			
			// 获得头条信息，用于显示在
			headLineList = headLineService.getHeadLineList(headLineCondition);
			modelMap.put("headLineList", headLineList);
			
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
			return modelMap;
		}
		modelMap.put("success", true);
		return modelMap;
	}
}
