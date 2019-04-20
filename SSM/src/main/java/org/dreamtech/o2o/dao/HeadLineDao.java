package org.dreamtech.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.dreamtech.o2o.entity.HeadLine;

/**
 * 头条信息DAO
 * 
 * @author Xu Yiqing
 *
 */
public interface HeadLineDao {
	
	/**
	 * 查询头条信息
	 * 
	 * @param headLineCondition
	 *            查询条件
	 * @return List<HeadLine>
	 */
	List<HeadLine> queryHeadLine(@Param("headLineCondition") HeadLine headLineCondition);
}
