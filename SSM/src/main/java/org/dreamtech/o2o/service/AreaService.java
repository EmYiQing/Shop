package org.dreamtech.o2o.service;

import java.util.List;

import org.dreamtech.o2o.entity.Area;

/**
 * 区域服务接口
 * 
 * @author Xu Yiqing
 *
 */
public interface AreaService {
	// 用于Redis缓存的KEY
	public static final String AREA_LIST_KEY = "arealist";

	/**
	 * 获取所有区域列表
	 * 
	 * @return List<Area>
	 */
	List<Area> getAreaList();
}
