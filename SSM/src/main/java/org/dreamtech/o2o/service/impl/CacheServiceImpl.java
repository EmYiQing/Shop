package org.dreamtech.o2o.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.dreamtech.o2o.cache.JedisUtil;
import org.dreamtech.o2o.service.CacheService;

/**
 * 缓存服务实现
 * 
 * @author Xu Yiqing
 *
 */
@Service
public class CacheServiceImpl implements CacheService {

	@Autowired
	private JedisUtil.Keys jedisKeys;

	/**
	 * 根据传入的KEY清除Redis缓存
	 * 
	 * @param keyPrefix
	 */
	@Override
	public void removeFromCache(String keyPrefix) {
		Set<String> keySet = jedisKeys.keys(keyPrefix + "*");
		for (String key : keySet) {
			jedisKeys.del(key);
		}
	}
}
