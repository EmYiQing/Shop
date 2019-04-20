package org.dreamtech.o2o.service;

import org.dreamtech.o2o.dto.PersonInfoExecution;
import org.dreamtech.o2o.entity.PersonInfo;

/**
 * 个人信息接口
 * 
 * @author Xu Yiqing
 *
 */
public interface PersonInfoService {

	/**
	 * 注册用户
	 * 
	 * @param personInfo
	 *            用户
	 * @return PersonInfoExecution
	 */
	PersonInfoExecution register(PersonInfo personInfo);

	/**
	 * 修改用户
	 * 
	 * @param userId
	 *            用户ID
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @param newPassword
	 *            新密码
	 * @return PersonInfoExecution
	 */
	PersonInfoExecution modifyPersonInfo(Long userId, String username, String password, String newPassword);

	/**
	 * 根据用户名和密码查询用户
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return PersonInfo
	 */
	PersonInfo getPersonInfoByUsernameAndPwd(String username, String password);

	/**
	 * 根据用户ID获得用户
	 * 
	 * @param userId
	 *            用户ID
	 * @return PersonInfo
	 */
	PersonInfo getPersonInfoByUserId(long userId);
}
