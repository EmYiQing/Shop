package org.dreamtech.o2o.service.impl;

import java.util.List;

import org.dreamtech.o2o.dao.ProductCategoryDao;
import org.dreamtech.o2o.dao.ProductDao;
import org.dreamtech.o2o.dto.ProductCategoryExecution;
import org.dreamtech.o2o.entity.ProductCategory;
import org.dreamtech.o2o.enums.ProductCategoryStateEnum;
import org.dreamtech.o2o.exceptions.ProductCategoryOperationException;
import org.dreamtech.o2o.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品分类服务实现
 * @author Xu Yiqing
 *
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryDao productCategoryDao;

	@Autowired
	private ProductDao productDao;

	/**
	 * 获得商品分类集合
	 * 
	 * @param shopId
	 *            店铺ID
	 * @return List<ProductCategory>
	 */
	@Override
	public List<ProductCategory> getProductCategoryList(long shopId) {
		return productCategoryDao.queryProductCategoryList(shopId);
	}

	/**
	 * 批量增加商品分类
	 * 
	 * @param productCategoryList
	 *            商品分类集合
	 * @return ProductCategoryExecution
	 * @throws ProductCategoryOperationException
	 *             自定义异常
	 */
	@Override
	@Transactional
	public ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
			throws ProductCategoryOperationException {
		//判空
		if (productCategoryList != null && productCategoryList.size() > 0) {
			try {
				
				int effectedNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
				
				if (effectedNum <= 0) {
					throw new ProductCategoryOperationException("批量添加店铺失败");
				} else {
					return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
				}
			} catch (Exception e) {
				throw new ProductCategoryOperationException("batchAddProductCategory error:" + e.getMessage());
			}
		} else {
			return new ProductCategoryExecution(ProductCategoryStateEnum.EMPTY_LIST);
		}
	}

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
	@Override
	@Transactional
	public ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId)
			throws ProductCategoryOperationException {
		try {
			//先要将商品分类置空
			int effectedNum = productDao.updateProductCategoryToNull(productCategoryId);
			
			if (effectedNum <= 0) {
				throw new ProductCategoryOperationException("商品类别更新失败");
			}
		} catch (Exception e) {
			throw new ProductCategoryOperationException("deleteProductCategory error:" + e.getMessage());
		}
		
		try {
			
			int effectedNum = productCategoryDao.deleteProductCategory(productCategoryId, shopId);
			
			if (effectedNum <= 0) {
				throw new ProductCategoryOperationException("商品类别删除失败");
			} else {
				return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
			}
		} catch (Exception e) {
			throw new ProductCategoryOperationException("deleteProductCategory error:" + e.getMessage());
		}
	}

}
