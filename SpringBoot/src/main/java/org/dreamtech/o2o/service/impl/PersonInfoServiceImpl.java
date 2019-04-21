package org.dreamtech.o2o.service.impl;

import java.util.Date;

import org.dreamtech.o2o.dao.PersonInfoDao;
import org.dreamtech.o2o.dto.PersonInfoExecution;
import org.dreamtech.o2o.entity.PersonInfo;
import org.dreamtech.o2o.enums.PersonInfoStateEnum;
import org.dreamtech.o2o.exceptions.PersonInfoOperationException;
import org.dreamtech.o2o.service.PersonInfoService;
import org.dreamtech.o2o.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 个人信息服务实现
 * 
 * @author Xu Yiqing
 *
 */
@Service
public class PersonInfoServiceImpl implements PersonInfoService {

	@Autowired
	private PersonInfoDao personInfoDao;

	/**
	 * 注册用户
	 * 
	 * @param personInfo
	 *            用户
	 * @return PersonInfoExecution
	 */
	@Override
	@Transactional
	public PersonInfoExecution register(PersonInfo personInfo) {
		// 判空
		if (personInfo == null || personInfo.getPassword() == null || personInfo.getUsername() == null) {
			return new PersonInfoExecution(PersonInfoStateEnum.NULL_AUTH_INFO);
		}
		try {
			personInfo.setCreateTime(new Date());
			personInfo.setLastEditTime(new Date());
			// 对密码进行MD5加密
			personInfo.setPassword(MD5.getMd5(personInfo.getPassword()));

			int effectedNum = personInfoDao.insertPersonInfo(personInfo);

			if (effectedNum <= 0) {
				throw new PersonInfoOperationException("帐号注册失败");
			} else {
				return new PersonInfoExecution(PersonInfoStateEnum.SUCCESS, personInfo);
			}
		} catch (Exception e) {
			throw new PersonInfoOperationException("insertLocalAuth error: " + e.toString());
		}
	}

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
	@Override
	@Transactional
	public PersonInfoExecution modifyPersonInfo(Long userId, String username, String password, String newPassword)
			throws PersonInfoOperationException {
		// 判空
		if (userId != null && username != null && password != null && newPassword != null
				&& !password.equals(newPassword)) {

			try {
				// 注意对新旧密码进行加密
				int effectedNum = personInfoDao.updatePersonInfo(userId, username, MD5.getMd5(password),
						MD5.getMd5(newPassword), new Date());
				if (effectedNum <= 0) {
					throw new PersonInfoOperationException("更新密码失败");
				}
				return new PersonInfoExecution(PersonInfoStateEnum.SUCCESS);
			} catch (Exception e) {
				e.printStackTrace();
				throw new PersonInfoOperationException("更新密码失败:" + e.toString());
			}

		} else {
			return new PersonInfoExecution(PersonInfoStateEnum.NULL_AUTH_INFO);
		}
	}

	/**
	 * 根据用户名和密码查询用户
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return PersonInfo
	 */
	@Override
	public PersonInfo getPersonInfoByUsernameAndPwd(String username, String password) {
		return personInfoDao.queryLocalByUserNameAndPwd(username, MD5.getMd5(password));
	}

	/**
	 * 根据用户ID获得用户
	 * 
	 * @param userId
	 *            用户ID
	 * @return PersonInfo
	 */
	@Override
	public PersonInfo getPersonInfoByUserId(long userId) {
		return personInfoDao.queryPersonInfoById(userId);
	}
}
