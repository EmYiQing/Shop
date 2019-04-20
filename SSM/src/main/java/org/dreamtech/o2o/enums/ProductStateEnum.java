package org.dreamtech.o2o.enums;

/**
 * 商品状态枚举
 * 
 * @author Xu Yiqing
 *
 */
public enum ProductStateEnum {
	OFFLINE(-1, "非法商品"), DOWN(0, "下架"), SUCCESS(1, "操作成功"), INNER_ERROR(-1001, "操作失败"), EMPTY(-1002, "商品为空");
	// 状态
	private int state;
	// 状态信息
	private String stateInfo;

	private ProductStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	/**
	 * 得到指定的状态枚举
	 * 
	 * @param index
	 *            传入状态
	 * @return 对应状态枚举
	 */
	public static ProductStateEnum stateOf(int index) {
		for (ProductStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}
}
