package org.dreamtech.o2o.service;

import java.util.List;

import org.dreamtech.o2o.entity.ShopCategory;

/**
 * 店铺分类服务接口
 * 
 * @author Xu Yiqing
 *
 */
public interface ShopCategoryService {
	// 用于Redis缓存的KEY
	public static final String SHOP_CATEGORY_LIST_KEY = "shopcategorylist";

	/**
	 * 获得店铺分类集合
	 * 
	 * @param shopCategoryCondition
	 *            查询条件
	 * @return List<ShopCategory>
	 */
	List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
