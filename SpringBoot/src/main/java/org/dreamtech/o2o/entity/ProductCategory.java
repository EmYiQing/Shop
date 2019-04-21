package org.dreamtech.o2o.entity;

import java.util.Date;

/**
 * 商品分类实体类
 * 
 * @author Xu Yiqing
 *
 */
public class ProductCategory {
	// ID
	private Long productCategoryId;
	// 店铺ID
	private Long shopId;
	// 商品分类名
	private String productCategoryName;
	// 分类权重
	private Integer priority;
	// 分类创建时间
	private Date createTime;

	public Long getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(Long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getProductCategoryName() {
		return productCategoryName;
	}

	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
