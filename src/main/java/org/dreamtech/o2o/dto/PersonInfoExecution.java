package org.dreamtech.o2o.dto;

import org.dreamtech.o2o.entity.PersonInfo;
import org.dreamtech.o2o.enums.PersonInfoStateEnum;

/**
 * 封装个人信息操作结果
 * 
 * @author Xu Yiqing
 *
 */
public class PersonInfoExecution {
	// 结果状态
	private int state;
	// 状态信息
	private String stateInfo;
	// 操作结果
	private PersonInfo personInfo;

	public PersonInfoExecution() {
	}

	/**
	 * 操作失败调用的方法
	 * 
	 * @param stateEnum
	 *            个人信息枚举
	 */
	public PersonInfoExecution(PersonInfoStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	/**
	 * 操作成功调用的方法
	 * 
	 * @param stateEnum
	 *            个人信息枚举
	 * @param personInfo
	 *            操作结果
	 */
	public PersonInfoExecution(PersonInfoStateEnum stateEnum, PersonInfo personInfo) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.personInfo = personInfo;
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

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

}
