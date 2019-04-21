package org.dreamtech.o2o.dao;

import java.util.List;

import org.dreamtech.o2o.entity.ProductImg;

/**
 * 商品图片DAO
 * 
 * @author Xu Yiqing
 *
 */
public interface ProductImgDao {

	/**
	 * 根据商品ID查询商品图片
	 * 
	 * @param productId
	 *            商品ID
	 * @return List<ProductImg>
	 */
	List<ProductImg> queryProductImgList(long productId);

	/**
	 * 批量插入商品图片
	 * 
	 * @param productImgList
	 *            商品图片集合
	 * @return int
	 */
	int batchInsertProductImg(List<ProductImg> productImgList);

	/**
	 * 根据商品ID删除商品图片
	 * 
	 * @param productId
	 *            商品ID
	 * @return int
	 */
	int deleteProductImgByProductId(long productId);
}
