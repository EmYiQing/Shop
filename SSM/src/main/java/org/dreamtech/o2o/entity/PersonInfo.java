package org.dreamtech.o2o.entity;

import java.util.Date;

/**
 * 个人信息实体类
 * 
 * @author Xu Yiqing
 *
 */
public class PersonInfo {
	// 店铺管理员角色
	public static final Integer SHOP_ADMIN = 2;
	// 超级管理员角色
	public static final Integer SUPER_ADMIN = 3;
	// 顾客角色
	public static final Integer CUSTOMER = 1;
	// 可使用状态
	public static final Integer ENABLED = 1;
	// 不可使用状态
	public static final Integer DISABLED = 0;
	// ID
	private Long userId;
	// 0:不可使用 1:已激活
	private Integer enableStatus;
	// 1:顾客 2:店家 3:超级管理员
	private Integer userType;
	// 创建时间
	private Date createTime;
	// 最后修改时间
	private Date lastEditTime;
	// 用户名
	private String username;
	// 密码
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getEnableStatus() {
		return enableStatus;
	}

	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
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
}
