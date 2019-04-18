package org.dreamtech.o2o.service;

import java.util.List;

import org.dreamtech.o2o.entity.HeadLine;

/**
 * 头条服务接口
 * 
 * @author Xu Yiqing
 *
 */
public interface HeadLineService {
	// 用于Redis缓存的KEY
	public static final String HEAD_LINE_LIST_KEY = "headlinelist";

	/**
	 * 获得头条列表
	 * 
	 * @param headLineCondition
	 *            查询条件
	 * @return List<HeadLine>
	 */
	List<HeadLine> getHeadLineList(HeadLine headLineCondition);
}
