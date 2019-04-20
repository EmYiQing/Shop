package org.dreamtech.o2o.exceptions;

/**
 * 个人信息操作异常
 * 
 * @author Xu Yiqing
 *
 */
public class PersonInfoOperationException extends RuntimeException {

	private static final long serialVersionUID = -8260236137099919700L;

	public PersonInfoOperationException(String msg) {
		super(msg);
	}
}
