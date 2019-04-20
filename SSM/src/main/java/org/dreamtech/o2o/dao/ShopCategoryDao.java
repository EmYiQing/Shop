package org.dreamtech.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.dreamtech.o2o.entity.ShopCategory;

/**
 * 店铺分类DAO
 * 
 * @author Xu Yiqing
 *
 */
public interface ShopCategoryDao {

	/**
	 * 查询店铺分类
	 * 
	 * @param shopCategoryCondition
	 *            查询条件
	 * @return List<ShopCategory>
	 */
	List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategoryCondition);
}
