package org.dreamtech.o2o.service;

import java.util.List;

import org.dreamtech.o2o.dto.ProductCategoryExecution;
import org.dreamtech.o2o.entity.ProductCategory;
import org.dreamtech.o2o.exceptions.ProductCategoryOperationException;

/**
 * 商品分类服务接口
 * 
 * @author Xu Yiqing
 *
 */
public interface ProductCategoryService {

	/**
	 * 获得商品分类集合
	 * 
	 * @param shopId
	 *            店铺ID
	 * @return List<ProductCategory>
	 */
	List<ProductCategory> getProductCategoryList(long shopId);

	/**
	 * 批量增加商品分类
	 * 
	 * @param productCategoryList
	 *            商品分类集合
	 * @return ProductCategoryExecution
	 * @throws ProductCategoryOperationException
	 *             自定义异常
	 */
	ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
			throws ProductCategoryOperationException;

	/**
	 * 删除商品分类
	 * 
	 * @param productCategoryId
	 *            商品分类ID
	 * @param shopId
	 *            店铺ID
	 * @return ProductCategoryExecution
	 * @throws ProductCategoryOperationException
	 *             自定义异常
	 */
	ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId)
			throws ProductCategoryOperationException;
}
