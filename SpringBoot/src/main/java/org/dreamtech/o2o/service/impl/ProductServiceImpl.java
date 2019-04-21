package org.dreamtech.o2o.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dreamtech.o2o.dao.ProductDao;
import org.dreamtech.o2o.dao.ProductImgDao;
import org.dreamtech.o2o.dto.ImageHolder;
import org.dreamtech.o2o.dto.ProductExecution;
import org.dreamtech.o2o.entity.Product;
import org.dreamtech.o2o.entity.ProductImg;
import org.dreamtech.o2o.enums.ProductStateEnum;
import org.dreamtech.o2o.exceptions.ProductOperationException;
import org.dreamtech.o2o.service.ProductService;
import org.dreamtech.o2o.util.ImageUtil;
import org.dreamtech.o2o.util.PageCalculator;
import org.dreamtech.o2o.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品服务实现
 * 
 * @author Xu Yiqing
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private ProductImgDao productImgDao;

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
	@Override
	@Transactional
	public ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList)
			throws ProductOperationException {
		// 判空
		if (product != null && product.getShop() != null && product.getShop().getShopId() != null) {
			product.setCreateTime(new Date());
			product.setLastEditTime(new Date());
			product.setEnableStatus(1);
			if (thumbnail != null) {
				// 商品图片处理
				addThumbnail(product, thumbnail);
			}
			try {

				int effectedNum = productDao.insertProduct(product);

				if (effectedNum <= 0) {
					throw new ProductOperationException("创建商品失败");
				}
			} catch (Exception e) {
				throw new ProductOperationException("addProduct error:" + e.getMessage());
			}
			if (productImgList != null && productImgList.size() > 0) {
				// 商品详情图片处理
				addProductImgList(product, productImgList);

			}
			return new ProductExecution(ProductStateEnum.SUCCESS, product);
		} else {
			return new ProductExecution(ProductStateEnum.EMPTY);
		}
	}

	/**
	 * 商品详情图片处理
	 * 
	 * @param product
	 *            商品
	 * @param productImgHolderList
	 *            图片封装集合
	 */
	private void addProductImgList(Product product, List<ImageHolder> productImgHolderList) {
		// 指定路径
		String dest = PathUtil.getShopImagePath(product.getShop().getShopId());
		List<ProductImg> productImgList = new ArrayList<ProductImg>();

		for (ImageHolder productImgHolder : productImgHolderList) {
			// 生成图片
			String imgAddr = ImageUtil.generateNormalImg(productImgHolder, dest);
			// 封装
			ProductImg productImg = new ProductImg();
			productImg.setImgAddr(imgAddr);
			productImg.setProductId(product.getProductId());
			productImg.setCreateTime(new Date());
			productImgList.add(productImg);
		}

		if (productImgList.size() > 0) {
			try {
				int effectedNum = productImgDao.batchInsertProductImg(productImgList);
				if (effectedNum <= 0) {
					throw new ProductOperationException("创建商品详情图片失败");
				}
			} catch (Exception e) {
				throw new ProductOperationException("addProductImgList error:" + e.getMessage());
			}
		}
	}

	/**
	 * 商品图片处理
	 * 
	 * @param product
	 *            商品
	 * @param thumbnail
	 *            图片封装
	 */
	private void addThumbnail(Product product, ImageHolder thumbnail) {
		String dest = PathUtil.getShopImagePath(product.getShop().getShopId());
		String thumbnailAddr = ImageUtil.generateThumbnail(thumbnail, dest);
		product.setImgAddr(thumbnailAddr);
	}

	/**
	 * 根据商品ID获得商品信息
	 * 
	 * @param productId
	 *            商品ID
	 * @return Product
	 */
	@Override
	public Product getProductById(long productId) {
		return productDao.queryProductById(productId);
	}

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
	@Override
	@Transactional
	public ProductExecution modifyProduct(Product product, ImageHolder thumbnail,
			List<ImageHolder> productImgHolderList) throws ProductOperationException {
		// 判空
		if (product != null && product.getShop() != null && product.getShop().getShopId() != null) {
			// 更新时间
			product.setLastEditTime(new Date());

			if (thumbnail != null) {
				Product tempProduct = productDao.queryProductById(product.getProductId());
				if (tempProduct.getImgAddr() != null) {
					// 删除修改前的图片
					ImageUtil.deleteFileOrPath(tempProduct.getImgAddr());
				}
				// 处理新图片
				addThumbnail(tempProduct, thumbnail);
				product.setImgAddr(tempProduct.getImgAddr());
			}
			// 判空
			if (productImgHolderList != null && productImgHolderList.size() > 0) {
				// 处理商品详情图片
				deleteProductImgList(product.getProductId());
				addProductImgList(product, productImgHolderList);
			}
			try {

				int effectedNum = productDao.updateProduct(product);

				if (effectedNum <= 0) {
					throw new ProductOperationException("商品信息更新失败");
				}
				return new ProductExecution(ProductStateEnum.SUCCESS, product);
			} catch (Exception e) {
				throw new ProductOperationException("modifyProduct error:" + e.getMessage());
			}
		} else {
			return new ProductExecution(ProductStateEnum.EMPTY);
		}
	}

	/**
	 * 根据商品ID删除图片
	 * 
	 * @param productId
	 */
	private void deleteProductImgList(Long productId) {

		List<ProductImg> productImgList = productImgDao.queryProductImgList(productId);

		for (ProductImg productImg : productImgList) {
			ImageUtil.deleteFileOrPath(productImg.getImgAddr());
		}
		productImgDao.deleteProductImgByProductId(productId);
	}

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
	@Override
	@Transactional
	public ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize) {
		// 分页计算
		int rowIndex = PageCalculator.calculatorRowIndex(pageIndex, pageSize);

		List<Product> productList = productDao.queryProductList(productCondition, rowIndex, pageSize);

		int count = productDao.queryProductCount(productCondition);
		// 封装
		ProductExecution pe = new ProductExecution();
		pe.setProductList(productList);
		pe.setCount(count);

		return pe;
	}
}