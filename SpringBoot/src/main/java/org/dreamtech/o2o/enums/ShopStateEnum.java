package org.dreamtech.o2o.enums;

/**
 * 店铺状态枚举
 * 
 * @author Xu Yiqing
 *
 */
public enum ShopStateEnum {
	CHECK(0, "审核中"), OFFLINE(-1, "非法店铺"), SUCCESS(1, "操作成功"), PASS(2, "通过认证"), INNER_ERROR(-1001,
			"内部系统错误"), NULL_SHOPID(-1002, "ShopId为空"), NULL_SHOP(-1003, "Shop不存在");
	// 状态
	private int state;
	// 状态信息
	private String stateInfo;

	private ShopStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	/**
	 * 得到指定的状态枚举
	 * 
	 * @param index
	 *            传入状态
	 * @return 对应状态枚举
	 */
	public static ShopStateEnum stateOf(int state) {
		for (ShopStateEnum stateEnum : values()) {
			if (stateEnum.getState() == state) {
				return stateEnum;
			}
		}
		return null;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}
}
