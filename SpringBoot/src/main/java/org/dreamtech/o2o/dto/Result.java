package org.dreamtech.o2o.dto;

/**
 * 封装JSON对象 数据库的返回结果
 * 
 * @author Xu Yiqing
 *
 * @param <T>
 *            很多返回结果类型可通用此类
 */
public class Result<T> {
	// 成功标记
	private boolean success;
	// 数据
	private T data;
	// 错误信息
	private String errMsg;
	// 错误码
	private int errorCode;

	public Result() {

	}

	/**
	 * 成功构造器
	 * 
	 * @param success
	 *            是否成功
	 * @param data
	 *            返回数据
	 */
	public Result(boolean success, T data) {
		this.success = success;
		this.data = data;
	}

	/**
	 * 失败构造器
	 * 
	 * @param success
	 *            是否成功
	 * @param errorCode
	 *            错误码
	 * @param errMsg
	 *            错误信息
	 */
	public Result(boolean success, int errorCode, String errMsg) {
		super();
		this.success = success;
		this.errMsg = errMsg;
		this.errorCode = errorCode;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}
