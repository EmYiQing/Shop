package org.dreamtech.o2o.enums;

/**
 * 商品分类枚举
 * 
 * @author Xu Yiqing
 *
 */
public enum ProductCategoryStateEnum {
	SUCCESS(1, "创建成功"), INNER_ERROR(-1001, "操作失败"), EMPTY_LIST(-1002, "添加数少于1");
	// 状态
	private int state;
	// 状态信息
	private String stateInfo;

	private ProductCategoryStateEnum(int state, String stateInfo) {
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
	public static ProductCategoryStateEnum stateOf(int state) {
		for (ProductCategoryStateEnum stateEnum : values()) {
			if (stateEnum.getState() == state) {
				return stateEnum;
			}
		}
		return null;
	}
}
