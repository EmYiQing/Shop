package org.dreamtech.o2o.dto;

import java.util.List;

import org.dreamtech.o2o.entity.ProductCategory;
import org.dreamtech.o2o.enums.ProductCategoryStateEnum;

/**
 * 封装商品分类操作结果
 * 
 * @author Xu Yiqing
 *
 */
public class ProductCategoryExecution {
	// 状态
	private int state;
	// 状态信息
	private String stateInfo;
	// 操作结果
	private List<ProductCategory> productCategoryList;

	public ProductCategoryExecution() {
	}

	/**
	 * 操作失败调用的方法
	 * 
	 * @param stateEnum
	 *            状态枚举
	 */
	public ProductCategoryExecution(ProductCategoryStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	/**
	 * 操作成功调用的方法
	 * 
	 * @param stateEnum
	 *            状态枚举
	 * @param productCategoryList
	 *            结果集合
	 */
	public ProductCategoryExecution(ProductCategoryStateEnum stateEnum, List<ProductCategory> productCategoryList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.productCategoryList = productCategoryList;
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

	public List<ProductCategory> getProductCategoryList() {
		return productCategoryList;
	}

	public void setProductCategoryList(List<ProductCategory> productCategoryList) {
		this.productCategoryList = productCategoryList;
	}
}
