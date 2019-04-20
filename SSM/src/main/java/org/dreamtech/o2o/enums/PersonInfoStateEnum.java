package org.dreamtech.o2o.enums;

/**
 * 个人信息枚举
 * 
 * @author Xu Yiqing
 *
 */
public enum PersonInfoStateEnum {
	LOGINFAIL(-1, "密码或帐号输入有误"), SUCCESS(0, "操作成功"), NULL_AUTH_INFO(-1006, "注册信息为空"), ONLY_ONE_ACCOUNT(-1007,
			"最多只能绑定一个本地帐号");
	// 状态
	private int state;
	// 状态信息
	private String stateInfo;

	private PersonInfoStateEnum(int state, String stateInfo) {
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
	public static PersonInfoStateEnum stateOf(int index) {
		for (PersonInfoStateEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}
}
