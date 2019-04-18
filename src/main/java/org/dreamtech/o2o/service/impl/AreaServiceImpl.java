package org.dreamtech.o2o.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dreamtech.o2o.cache.JedisUtil;
import org.dreamtech.o2o.dao.AreaDao;
import org.dreamtech.o2o.entity.Area;
import org.dreamtech.o2o.exceptions.AreaOperationException;
import org.dreamtech.o2o.service.AreaService;
import org.dreamtech.o2o.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * 区域服务实现
 * 
 * @author Xu Yiqing
 *
 */
@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaDao areaDao;

	@Autowired
	private JedisUtil.Keys jedisKeys;

	@Autowired
	private JedisUtil.Strings jedisStrings;

	/**
	 * 获取所有区域列表
	 * 
	 * @return List<Area>
	 */
	@Override
	@Transactional
	public List<Area> getAreaList() {

		String key = AREA_LIST_KEY;
		List<Area> areaList = null;
		ObjectMapper mapper = new ObjectMapper();

		// 如果Redis不存在缓存，先生成缓存
		if (!jedisKeys.exists(key)) {
			areaList = areaDao.queryArea();
			String jsonString = null;

			try {
				jsonString = mapper.writeValueAsString(areaList);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				throw new AreaOperationException(e.toString());
			}

			jedisStrings.set(key, jsonString);

		} else {
			// 如果Redis存在缓存，直接调用缓存
			String jsonString = jedisStrings.get(key);

			JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, Area.class);

			try {
				areaList = mapper.readValue(jsonString, javaType);

				if (areaList != null) {
					LogUtil.log("areaList调用Redis缓存");
				}

			} catch (JsonParseException e) {
				e.printStackTrace();
				throw new AreaOperationException(e.toString());
			} catch (JsonMappingException e) {
				e.printStackTrace();
				throw new AreaOperationException(e.toString());
			} catch (IOException e) {
				e.printStackTrace();
				throw new AreaOperationException(e.toString());
			}
		}
		return areaList;
	}
}
