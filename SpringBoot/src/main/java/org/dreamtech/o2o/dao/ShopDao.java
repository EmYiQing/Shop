package org.dreamtech.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.dreamtech.o2o.entity.Shop;

/**
 * 店铺DAO
 * 
 * @author Xu Yiqing
 *
 */
public interface ShopDao {

	/**
	 * 查询店铺列表
	 * 
	 * @param shopCondition
	 *            查询条件
	 * @param rowIndex
	 *            查询索引
	 * @param pageSize
	 *            每页最大数量
	 * @return List<Shop>
	 */
	List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition, @Param("rowIndex") int rowIndex,
			@Param("pageSize") int pageSize);

	/**
	 * 查询店铺数量
	 * 
	 * @param shopCondition
	 *            查询条件
	 * @return int
	 */
	int queryShopCount(@Param("shopCondition") Shop shopCondition);

	/**
	 * 根据店铺ID查询店铺
	 * 
	 * @param shopId
	 *            店铺ID
	 * @return Shop
	 */
	Shop queryByShopId(long shopId);

	/**
	 * 插入店铺
	 * 
	 * @param shop
	 *            店铺封装
	 * @return int
	 */
	int insertShop(Shop shop);

	/**
	 * 更新店铺
	 * 
	 * @param shop
	 *            店铺封装
	 * @return int
	 */
	int updateShop(Shop shop);
}
