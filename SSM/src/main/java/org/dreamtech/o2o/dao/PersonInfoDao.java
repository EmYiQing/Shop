package org.dreamtech.o2o.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.dreamtech.o2o.entity.PersonInfo;

/**
 * 个人信息DAO
 * 
 * @author Xu Yiqing
 *
 */
public interface PersonInfoDao {

	/**
	 * 查询个人信息
	 * 
	 * @param userId
	 *            个人ID
	 * @return PersonInfo
	 */
	PersonInfo queryPersonInfoById(long userId);

	/**
	 * 插入个人信息
	 * 
	 * @param personInfo
	 *            个人信息封装
	 * @return int
	 */
	int insertPersonInfo(PersonInfo personInfo);

	/**
	 * 更新个人信息，用于更改密码
	 * 
	 * @param userId
	 *            个人ID
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @param newPassword
	 *            新密码
	 * @param lastEditTime
	 *            最后编辑时间
	 * @return int
	 */
	int updatePersonInfo(@Param("userId") Long userId, @Param("username") String username,
			@Param("password") String password, @Param("newPassword") String newPassword,
			@Param("lastEditTime") Date lastEditTime);

	/**
	 * 根据用户名密码查询，用于登陆
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return
	 */
	PersonInfo queryLocalByUserNameAndPwd(@Param("username") String username, @Param("password") String password);
}