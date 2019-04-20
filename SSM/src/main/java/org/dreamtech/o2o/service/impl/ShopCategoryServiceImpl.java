package org.dreamtech.o2o.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dreamtech.o2o.cache.JedisUtil;
import org.dreamtech.o2o.dao.ShopCategoryDao;
import org.dreamtech.o2o.entity.ShopCategory;
import org.dreamtech.o2o.exceptions.ShopCategoryOperationException;
import org.dreamtech.o2o.service.ShopCategoryService;
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
 * 店铺分类服务实现
 * 
 * @author Xu Yiqing
 *
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

	@Autowired
	private ShopCategoryDao shopCategoryDao;

	@Autowired
	private JedisUtil.Keys jedisKeys;

	@Autowired
	private JedisUtil.Strings jedisStrings;

	/**
	 * 获得店铺分类集合
	 * 
	 * @param shopCategoryCondition
	 *            查询条件
	 * @return List<ShopCategory>
	 */
	@Override
	@Transactional
	public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
		String key = SHOP_CATEGORY_LIST_KEY;
		List<ShopCategory> shopCategoryList = null;
		ObjectMapper mapper = new ObjectMapper();
		// 生产指定的Redis的KEY
		if (shopCategoryCondition == null) {
			key = key + "_allfirstlevel";
		} else if (shopCategoryCondition != null && shopCategoryCondition.getParent() != null
				&& shopCategoryCondition.getParent().getShopCategoryId() != null) {
			key = key + "_parent" + shopCategoryCondition.getParent().getShopCategoryId();
		} else if (shopCategoryCondition != null) {
			key = key + "_allsecondlevel";
		}
		// 如果Redis中不存在缓存，先生成
		if (!jedisKeys.exists(key)) {
			shopCategoryList = shopCategoryDao.queryShopCategory(shopCategoryCondition);
			String jsonString;

			try {
				jsonString = mapper.writeValueAsString(shopCategoryList);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				throw new ShopCategoryOperationException(e.getMessage());
			}

			jedisStrings.set(key, jsonString);
		} else {
			// 直接读取Redis缓存
			String jsonString = jedisStrings.get(key);
			JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, ShopCategory.class);

			try {
				shopCategoryList = mapper.readValue(jsonString, javaType);

				if (shopCategoryList != null) {
					LogUtil.log("shopCategoryList调用Redis缓存");
				}

			} catch (JsonParseException e) {
				e.printStackTrace();
				throw new ShopCategoryOperationException(e.getMessage());
			} catch (JsonMappingException e) {
				e.printStackTrace();
				throw new ShopCategoryOperationException(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
				throw new ShopCategoryOperationException(e.getMessage());
			}
		}
		return shopCategoryDao.queryShopCategory(shopCategoryCondition);
	}

}
