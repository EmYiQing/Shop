package org.dreamtech.o2o.dto;

import java.util.List;

import org.dreamtech.o2o.entity.Shop;
import org.dreamtech.o2o.enums.ShopStateEnum;

/**
 * 封装店铺的操作结果
 * 
 * @author Xu Yiqing
 *
 */
public class ShopExecution {
	// 状态
	private int state;
	// 状态信息
	private String stateInfo;
	// 数量
	private int count;
	// 结果
	private Shop shop;
	// 结果集合
	private List<Shop> shopList;

	public ShopExecution() {
	}

	/**
	 * 店铺操作失败
	 * 
	 * @param stateEnum
	 *            店铺枚举
	 */
	public ShopExecution(ShopStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	/**
	 * 店铺操作成功
	 * 
	 * @param stateEnum
	 *            店铺枚举
	 * @param shop
	 *            结果
	 */
	public ShopExecution(ShopStateEnum stateEnum, Shop shop) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.shop = shop;
	}

	/**
	 * 店铺操作成功
	 * 
	 * @param stateEnum
	 *            店铺枚举
	 * @param shops
	 *            结果集合
	 */
	public ShopExecution(ShopStateEnum stateEnum, List<Shop> shops) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.shopList = shops;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public List<Shop> getShopList() {
		return shopList;
	}

	public void setShopList(List<Shop> shopList) {
		this.shopList = shopList;
	}
}
