package org.dreamtech.o2o.service;

import java.util.List;

import org.dreamtech.o2o.dto.ImageHolder;
import org.dreamtech.o2o.dto.ProductExecution;
import org.dreamtech.o2o.entity.Product;
import org.dreamtech.o2o.exceptions.ProductOperationException;

/**
 * 商品服务接口
 * 
 * @author Xu Yiqing
 *
 */
public interface ProductService {

	/**
	 * 新增商品
	 * 
	 * @param product
	 *            商品
	 * @param thumbnail
	 *            图片封装对象
	 * @param productImgList
	 *            商品图片集合
	 * @return ProductExecution
	 * @throws ProductOperationException
	 *             自定义异常
	 */
	ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList)
			throws ProductOperationException;

	/**
	 * 修改商品
	 * 
	 * @param product
	 *            商品
	 * @param thumbnail
	 *            图片封装对象
	 * @param productImgList
	 *            商品图片集合
	 * @return ProductExecution
	 * @throws ProductOperationException
	 *             自定义异常
	 */
	ProductExecution modifyProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList)
			throws ProductOperationException;

	/**
	 * 根据商品ID获得商品信息
	 * 
	 * @param productId
	 *            商品ID
	 * @return Product
	 */
	Product getProductById(long productId);

	/**
	 * 查询商品列表
	 * 
	 * @param productCondition
	 *            查询条件
	 * @param pageIndex
	 *            分页索引
	 * @param pageSize
	 *            每页大小
	 * @return ProductExecution
	 */
	ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);
}
