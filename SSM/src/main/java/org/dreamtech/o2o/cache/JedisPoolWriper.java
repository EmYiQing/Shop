package org.dreamtech.o2o.cache;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 指定Redis的JedisPool接口构造函数
 * 
 * @author Xu Yiqing
 *
 */
public class JedisPoolWriper {

	private JedisPool jedisPool;

	/**
	 * 构造
	 * 
	 * @param poolConfig
	 *            Redis连接池配置
	 * @param host
	 *            主机
	 * @param port
	 *            端口
	 */
	public JedisPoolWriper(final JedisPoolConfig poolConfig, final String host, final int port) {
		try {
			jedisPool = new JedisPool(poolConfig, host, port);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取Redis连接池对象
	 * 
	 * @return JedisPool
	 */
	public JedisPool getJedisPool() {
		return jedisPool;
	}

	/**
	 * 注入Redis连接池对象
	 * 
	 * @param JedisPool
	 */
	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

}
