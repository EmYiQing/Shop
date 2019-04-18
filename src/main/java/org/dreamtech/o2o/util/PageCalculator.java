package org.dreamtech.o2o.util;

/**
 * 分页计算工具
 * 
 * @author Xu Yiqing
 *
 */
public class PageCalculator {

	/**
	 * 分页计算
	 * 
	 * @param pageIndex
	 *            分页索引
	 * @param pageSize
	 *            每页大小
	 * @return int
	 */
	public static int calculatorRowIndex(int pageIndex, int pageSize) {
		return (pageIndex > 0) ? (pageIndex - 1) * pageSize : 0;
	}
}
