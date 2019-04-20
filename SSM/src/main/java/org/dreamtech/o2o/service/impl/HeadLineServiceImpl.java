package org.dreamtech.o2o.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dreamtech.o2o.cache.JedisUtil;
import org.dreamtech.o2o.dao.HeadLineDao;
import org.dreamtech.o2o.entity.HeadLine;
import org.dreamtech.o2o.exceptions.HeadLineOperationException;
import org.dreamtech.o2o.service.HeadLineService;
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
 * 头条服务实现
 * 
 * @author Xu Yiqing
 *
 */
@Service
public class HeadLineServiceImpl implements HeadLineService {

	@Autowired
	private HeadLineDao headLineDao;

	@Autowired
	private JedisUtil.Keys jedisKeys;

	@Autowired
	private JedisUtil.Strings jedisStrings;

	/**
	 * 获得头条列表
	 * 
	 * @param headLineCondition
	 *            查询条件
	 * @return List<HeadLine>
	 */
	@Override
	@Transactional
	public List<HeadLine> getHeadLineList(HeadLine headLineCondition) {

		String key = HEAD_LINE_LIST_KEY;
		List<HeadLine> headLineList = null;
		ObjectMapper mapper = new ObjectMapper();

		// 生成特定的Redis的KEY
		if (headLineCondition != null && headLineCondition.getEnableStatus() != null) {
			key = key + "_" + headLineCondition.getEnableStatus();
		}

		// Redis不存在缓存，先生成缓存
		if (!jedisKeys.exists(key)) {

			headLineList = headLineDao.queryHeadLine(headLineCondition);
			String jsonString;

			try {
				jsonString = mapper.writeValueAsString(headLineList);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				throw new HeadLineOperationException(e.getMessage());
			}

			jedisStrings.set(key, jsonString);

		} else {
			// 存在Redis缓存，直接调用
			String jsonString = jedisStrings.get(key);
			JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, HeadLine.class);

			try {
				headLineList = mapper.readValue(jsonString, javaType);

				if (headLineList != null) {
					LogUtil.log("headLineList调用Redis缓存");
				}

			} catch (JsonParseException e) {
				e.printStackTrace();
				throw new HeadLineOperationException(e.getMessage());
			} catch (JsonMappingException e) {
				e.printStackTrace();
				throw new HeadLineOperationException(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
				throw new HeadLineOperationException(e.getMessage());
			}
		}
		return headLineList;
	}

}
