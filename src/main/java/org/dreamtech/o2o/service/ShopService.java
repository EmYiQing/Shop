package org.dreamtech.o2o.service;

import org.dreamtech.o2o.dto.ImageHolder;
import org.dreamtech.o2o.dto.ShopExecution;
import org.dreamtech.o2o.entity.Shop;
import org.dreamtech.o2o.exceptions.ShopOperationException;

/**
 * 店铺服务接口
 * 
 * @author Xu Yiqing
 *
 */
public interface ShopService {

	/**
	 * 获得店铺列表
	 * 
	 * @param shopCondition
	 *            查询条件
	 * @param pageIndex
	 *            分页索引
	 * @param pageSize
	 *            每页大小
	 * @return ShopExecution
	 */
	ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);

	/**
	 * 根据店铺ID获得店铺信息
	 * 
	 * @param shopId
	 *            店铺ID
	 * @return Shop
	 */
	Shop getByShopId(long shopId);

	/**
	 * 修改店铺
	 * 
	 * @param shop
	 *            店铺
	 * @param thumbnail
	 *            图片封装对象
	 * @return ShopExecution
	 * @throws ShopOperationException
	 *             自定义异常
	 */
	ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;

	/**
	 * 添加店铺
	 * 
	 * @param shop
	 *            店铺
	 * @param thumbnail
	 *            图片封装对象
	 * @return ShopExecution
	 * @throws ShopOperationException
	 *             自定义异常
	 */
	ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
}
