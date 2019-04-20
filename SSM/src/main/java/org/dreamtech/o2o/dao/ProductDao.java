package org.dreamtech.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.dreamtech.o2o.entity.Product;

/**
 * 商品DAO
 * 
 * @author Xu Yiqing
 *
 */
public interface ProductDao {

	/**
	 * 插入商品
	 * 
	 * @param product
	 *            商品封装
	 * @return int
	 */
	int insertProduct(Product product);

	/**
	 * 根据商品ID查询商品
	 * 
	 * @param productId
	 *            商品ID
	 * @return Product
	 */
	Product queryProductById(long productId);

	/**
	 * 更新商品
	 * 
	 * @param product
	 *            商品封装
	 * @return int
	 */
	int updateProduct(Product product);

	/**
	 * 分页查询商品列表
	 * 
	 * @param productCondition
	 *            查询条件
	 * @param rowIndex
	 *            查询索引
	 * @param pageSize
	 *            每页显示数
	 * @return List<Product>
	 */
	List<Product> queryProductList(@Param("productCondition") Product productCondition, @Param("rowIndex") int rowIndex,
			@Param("pageSize") int pageSize);

	/**
	 * 查询商品数量
	 * 
	 * @param productCondition
	 *            查询条件
	 * @return int
	 */
	int queryProductCount(@Param("productCondition") Product productCondition);

	/**
	 * 更新设置商品分类为空
	 * 
	 * @param productCategoryId
	 *            商品分类ID
	 * @return int
	 */
	int updateProductCategoryToNull(long productCategoryId);
}
