package org.dreamtech.o2o.service;

/**
 * 缓存服务接口
 * 
 * @author Xu Yiqing
 *
 */
public interface CacheService {

	/**
	 * 根据传入的KEY清除Redis缓存
	 * 
	 * @param keyPrefix
	 */
	void removeFromCache(String keyPrefix);
}
