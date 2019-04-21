package org.dreamtech.o2o.exceptions;

/**
 * 店铺分类操作异常
 * 
 * @author Xu Yiqing
 *
 */
public class ShopCategoryOperationException extends RuntimeException {

	private static final long serialVersionUID = 5423986306645291467L;

	public ShopCategoryOperationException(String msg) {
		super(msg);
	}
}
