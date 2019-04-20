package org.dreamtech.o2o.service.impl;

import java.util.Date;
import java.util.List;

import org.dreamtech.o2o.dao.ShopDao;
import org.dreamtech.o2o.dto.ImageHolder;
import org.dreamtech.o2o.dto.ShopExecution;
import org.dreamtech.o2o.entity.Shop;
import org.dreamtech.o2o.enums.ShopStateEnum;
import org.dreamtech.o2o.exceptions.ShopOperationException;
import org.dreamtech.o2o.service.ShopService;
import org.dreamtech.o2o.util.ImageUtil;
import org.dreamtech.o2o.util.PageCalculator;
import org.dreamtech.o2o.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 店铺服务实现
 * 
 * @author Xu Yiqing
 *
 */
@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao shopDao;

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
	@Override
	@Transactional
	public ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException {
		if (shop == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}
		try {
			// 暂时未做审核系统，所以直接通过
			shop.setEnableStatus(Shop.ENABLED);

			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());

			int effectedNum = shopDao.insertShop(shop);

			if (effectedNum <= 0) {
				throw new ShopOperationException("店铺创建失败");
			} else {
				if (thumbnail.getImage() != null) {
					try {
						// 处理图片
						addShopImg(shop, thumbnail);
					} catch (Exception e) {
						throw new ShopOperationException("addShopImg error:" + e.getMessage());
					}
					effectedNum = shopDao.updateShop(shop);
					if (effectedNum <= 0) {
						throw new ShopOperationException("更新图片地址失败");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ShopOperationException("addShop error:" + e.getMessage());
		}
		return new ShopExecution(ShopStateEnum.CHECK, shop);
	}

	/**
	 * 处理图片
	 * 
	 * @param shop
	 *            店铺
	 * @param thumbnail
	 *            图片封装
	 */
	private void addShopImg(Shop shop, ImageHolder thumbnail) {
		String dest = PathUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr = ImageUtil.generateThumbnail(thumbnail, dest);
		shop.setShopImg(shopImgAddr);
	}

	/**
	 * 根据店铺ID获得店铺信息
	 * 
	 * @param shopId
	 *            店铺ID
	 * @return Shop
	 */
	@Override
	public Shop getByShopId(long shopId) {
		return shopDao.queryByShopId(shopId);
	}

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
	@Override
	public ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException {
		try {
			// 判空
			if (shop == null || shop.getShopId() == null) {
				return new ShopExecution(ShopStateEnum.NULL_SHOP);
			} else {
				if (thumbnail.getImage() != null && thumbnail.getImageName() != null
						&& !"".equals(thumbnail.getImageName())) {
					Shop tempShop = shopDao.queryByShopId(shop.getShopId());
					if (tempShop.getShopImg() != null) {
						// 先删除旧的图片
						ImageUtil.deleteFileOrPath(tempShop.getShopImg());
					}
					// 处理图片
					addShopImg(shop, thumbnail);
				}
				shop.setLastEditTime(new Date());

				int effectedNum = shopDao.updateShop(shop);

				if (effectedNum <= 0) {
					return new ShopExecution(ShopStateEnum.INNER_ERROR);
				} else {

					shop = shopDao.queryByShopId(shop.getShopId());

					return new ShopExecution(ShopStateEnum.SUCCESS, shop);
				}
			}
		} catch (Exception e) {
			throw new ShopOperationException("modifyShop err:" + e.getMessage());
		}
	}

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
	@Override
	public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize) {
		// 分页计算
		int rowIndex = PageCalculator.calculatorRowIndex(pageIndex, pageSize);

		List<Shop> shopList = shopDao.queryShopList(shopCondition, rowIndex, pageSize);
		int count = shopDao.queryShopCount(shopCondition);

		ShopExecution se = new ShopExecution();
		if (shopList != null) {
			se.setShopList(shopList);
			se.setCount(count);
		} else {
			se.setState(ShopStateEnum.INNER_ERROR.getState());
		}
		return se;
	}

}
