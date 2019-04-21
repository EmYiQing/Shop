package org.dreamtech.o2o.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.dreamtech.o2o.dto.PersonInfoExecution;
import org.dreamtech.o2o.entity.Area;
import org.dreamtech.o2o.entity.PersonInfo;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
	@Autowired
	private AreaService areaService;
	@Autowired
	private CacheService cacheService;
	@Autowired
	private PersonInfoService personInfoService;

	@Ignore
	@Test
	public void testService() {
		PersonInfo personInfo = new PersonInfo();
		personInfo.setCreateTime(new Date());
		personInfo.setEnableStatus(PersonInfo.ENABLED);
		personInfo.setLastEditTime(new Date());
		personInfo.setUsername("test");
		personInfo.setPassword("test");
		personInfo.setUserType(PersonInfo.CUSTOMER);
		PersonInfoExecution person = personInfoService.register(personInfo);
		assertEquals(person.getPersonInfo().getUsername(), "test");
	}

	@SuppressWarnings("static-access")
	@Test
	public void testRedis() {
		List<Area> areaList=areaService.getAreaList();
		assertEquals(areaList.size(), 5);
		cacheService.removeFromCache(areaService.AREA_LIST_KEY);
		areaList=areaService.getAreaList();
	}

}
