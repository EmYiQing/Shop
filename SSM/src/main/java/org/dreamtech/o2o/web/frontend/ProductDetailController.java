package org.dreamtech.o2o.web.frontend;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dreamtech.o2o.entity.Product;
import org.dreamtech.o2o.service.ProductService;
import org.dreamtech.o2o.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品详情控制层
 * @author Xu Yiqing
 *
 */
@Controller
@RequestMapping("frontend")
public class ProductDetailController {
	
	@Autowired
	private ProductService productService;
	
	/**
	 * 获得商品详细信息
	 * @param request 请求
	 * @return Map<String, Object>
	 */
	@RequestMapping(value="listproductdetailpageinfo",method=RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> listProductDetailPageInfo(HttpServletRequest request){
		
		Map<String, Object> modelMap=new HashMap<String,Object>();
		long productId=HttpServletRequestUtil.getLong(request, "productId");
		Product product=null;
		
		if(productId!=-1){
			//根据ID查询
			product=productService.getProductById(productId);
			modelMap.put("success", true);
			modelMap.put("product", product);
		}else{
			modelMap.put("success", false);
			modelMap.put("errMsg", "empty productId");
		}
		return modelMap;
	}
}
