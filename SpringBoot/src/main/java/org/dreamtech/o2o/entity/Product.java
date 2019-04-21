package org.dreamtech.o2o.entity;

import java.util.Date;
import java.util.List;

/**
 * 商品实体类
 * 
 * @author Xu Yiqing
 *
 */
public class Product {
	// 不可用状态
	public static final Integer DISABLED = -1;
	// 展示状态
	public static final Integer SHOW = 1;
	// 下架状态
	public static final Integer UNDERCARRIAGE = 0;
	// ID
	private Long productId;
	// 商品名
	private String productName;
	// 商品描述
	private String productDesc;
	// 商品图片地址
	private String imgAddr;
	// 原价
	private String normalPrice;
	// 现价
	private String promotionPrice;
	// 权重
	private Integer priority;
	// 创造时间
	private Date createTime;
	// 最后修改时间
	private Date lastEditTime;
	// 状态
	private Integer enableStatus;
	// 商品图片集合
	private List<ProductImg> productImgList;
	// 商品分类
	private ProductCategory productCategory;
	// 店铺对象
	private Shop shop;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getImgAddr() {
		return imgAddr;
	}

	public void setImgAddr(String imgAddr) {
		this.imgAddr = imgAddr;
	}

	public String getNormalPrice() {
		return normalPrice;
	}

	public void setNormalPrice(String normalPrice) {
		this.normalPrice = normalPrice;
	}

	public String getPromotionPrice() {
		return promotionPrice;
	}

	public void setPromotionPrice(String promotionPrice) {
		this.promotionPrice = promotionPrice;
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

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

	public Integer getEnableStatus() {
		return enableStatus;
	}

	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
	}

	public List<ProductImg> getProductImgList() {
		return productImgList;
	}

	public void setProductImgList(List<ProductImg> productImgList) {
		this.productImgList = productImgList;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
}
