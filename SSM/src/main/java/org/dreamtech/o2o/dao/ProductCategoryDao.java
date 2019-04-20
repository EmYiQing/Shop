package org.dreamtech.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.dreamtech.o2o.entity.ProductCategory;

/**
 * 商品分类DAO
 * 
 * @author Xu Yiqing
 *
 */
public interface ProductCategoryDao {

	/**
	 * 根据店铺ID查询商品分类
	 * 
	 * @param shopId
	 *            店铺ID
	 * @return List<ProductCategory>
	 */
	List<ProductCategory> queryProductCategoryList(long shopId);

	/**
	 * 批量插入商品分类
	 * 
	 * @param productCategoryList
	 *            商品分类集合
	 * @return int
	 */
	int batchInsertProductCategory(List<ProductCategory> productCategoryList);

	/**
	 * 删除商品分类
	 * 
	 * @param productCategoryId
	 *            商品分类ID
	 * @param shopId
	 *            商品ID
	 * @return int
	 */
	int deleteProductCategory(@Param("productCategoryId") long productCategoryId, @Param("shopId") long shopId);
}
