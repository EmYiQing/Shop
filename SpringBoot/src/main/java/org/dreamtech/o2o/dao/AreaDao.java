package org.dreamtech.o2o.dao;

import java.util.List;

import org.dreamtech.o2o.entity.Area;

/**
 * 区域DAO
 * 
 * @author Xu Yiqing
 *
 */
public interface AreaDao {

	/**
	 * 查询所有区域
	 * 
	 * @return List<Area>
	 */
	List<Area> queryArea();
}
