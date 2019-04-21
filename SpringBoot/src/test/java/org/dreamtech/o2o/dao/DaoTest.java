package org.dreamtech.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.dreamtech.o2o.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoTest {
	@Autowired
	private AreaDao areaDao;

	@Test
	public void testAreaDao() {
		List<Area> areaList = areaDao.queryArea();
		assertEquals(5, areaList.size());
	}
}
