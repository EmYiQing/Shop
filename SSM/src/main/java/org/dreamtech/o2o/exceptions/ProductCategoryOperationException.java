package org.dreamtech.o2o.exceptions;

/**
 * 商品分类操作异常
 * 
 * @author Xu Yiqing
 *
 */
public class ProductCategoryOperationException extends RuntimeException {

	private static final long serialVersionUID = 2491429528244691834L;

	public ProductCategoryOperationException(String msg) {
		super(msg);
	}
}
