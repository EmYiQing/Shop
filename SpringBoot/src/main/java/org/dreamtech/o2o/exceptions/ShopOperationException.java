package org.dreamtech.o2o.exceptions;

/**
 * 店铺操作异常
 * 
 * @author Xu Yiqing
 *
 */
public class ShopOperationException extends RuntimeException {

	private static final long serialVersionUID = 3409806460370244928L;

	public ShopOperationException(String msg) {
		super(msg);
	}
}
