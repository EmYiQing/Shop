package org.dreamtech.o2o.dto;

import java.util.List;

import org.dreamtech.o2o.entity.Product;
import org.dreamtech.o2o.enums.ProductStateEnum;

/**
 * 封装商品操作结果
 * 
 * @author Xu Yiqing
 *
 */
public class ProductExecution {
	// 状态
	private int state;
	// 状态信息
	private String stateInfo;
	// 得到数量
	private int count;
	// 结果对象
	private Product product;
	// 结果集合
	private List<Product> productList;

	public ProductExecution() {
	}

	/**
	 * 操作失败调用的方法
	 * 
	 * @param stateEnum
	 *            商品枚举
	 */
	public ProductExecution(ProductStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	/**
	 * 操作成功调用的方法
	 * 
	 * @param stateEnum
	 *            商品枚举
	 * @param product
	 *            结果对象
	 */
	public ProductExecution(ProductStateEnum stateEnum, Product product) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.product = product;
	}

	/**
	 * 操作成功调用的方法
	 * 
	 * @param stateEnum
	 *            商品枚举
	 * @param productList
	 *            结果集合
	 */
	public ProductExecution(ProductStateEnum stateEnum, List<Product> productList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.productList = productList;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
}
