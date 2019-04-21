package org.dreamtech.o2o.config.redis;

import org.dreamtech.o2o.cache.JedisPoolWriper;
import org.dreamtech.o2o.cache.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfiguration {
	@Value("${redis.hostname}")
	private String hostname;
	@Value("${redis.port}")
	private int port;
	@Value("${redis.pool.maxActive}")
	private int maxTotal;
	@Value("${redis.pool.maxIdle}")
	private int maxIdle;
	@Value("${redis.pool.maxWait}")
	private long maxWaitMillis;
	@Value("${redis.pool.testOnBorrow}")
	private boolean testOnBorrow;

	@Autowired
	private JedisPoolConfig jedisPoolConfig;
	@Autowired
	private JedisPoolWriper jedisWritePool;
	@Autowired
	private JedisUtil jedisUtil;

	@Bean(name = "jedisPoolConfig")
	public JedisPoolConfig createJedisPoolConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxTotal(maxTotal);
		jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
		jedisPoolConfig.setTestOnBorrow(testOnBorrow);
		return jedisPoolConfig;
	}

	@Bean(name = "jedisWritePool")
	public JedisPoolWriper createJedisPoolWriper() {
		JedisPoolWriper jedisPoolWriper = new JedisPoolWriper(jedisPoolConfig, hostname, port);
		return jedisPoolWriper;
	}

	@Bean(name = "jedisUtil")
	public JedisUtil createJedisUtil() {
		JedisUtil jedisUtil = new JedisUtil();
		jedisUtil.setJedisPool(jedisWritePool);
		return jedisUtil;
	}

	@Bean(name = "jedisKeys")
	public JedisUtil.Keys createJedisKeys() {
		JedisUtil.Keys jedisKeys = jedisUtil.new Keys();
		return jedisKeys;
	}

	@Bean(name = "jedisStrings")
	public JedisUtil.Strings createJedisStrings() {
		JedisUtil.Strings jedisStrings = jedisUtil.new Strings();
		return jedisStrings;
	}
}
