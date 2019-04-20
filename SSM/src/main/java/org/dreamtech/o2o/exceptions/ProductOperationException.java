package org.dreamtech.o2o.exceptions;

/**
 * 商品操作异常
 * 
 * @author Xu Yiqing
 *
 */
public class ProductOperationException extends RuntimeException {

	private static final long serialVersionUID = -7648008178223776200L;

	public ProductOperationException(String msg) {
		super(msg);
	}
}
