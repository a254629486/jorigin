package com.ssq.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.common.SsqFileUtils;
import com.ssq.po.TotalBallPO;

public class TotalBallDaoTest {

	ApplicationContext applicationContext = null;

	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring-base.xml");
	}

//	@Test
	public void testSelectTotalBall() {
		
		TotalBallDao totalBallDao = (TotalBallDao) applicationContext.getBean("totalBallDao");
		TotalBallPO tbpo =  totalBallDao.selectTotalBall(1);
		System.out.println(">>>>>>>>>>"+tbpo.getOpendate());
	}

	@Test
	public void testInsertTotalBall() {

		String filePath = "D:\\2015-2008.txt";

		SsqFileUtils.readTxtFile(filePath);

		TotalBallDao totalBallDao = (TotalBallDao) applicationContext.getBean("totalBallDao");
		System.out.println("条数：" + SsqFileUtils.tblist.size());

		for (TotalBallPO totalBallPO : SsqFileUtils.tblist) {
			totalBallDao.insertTotalBall(totalBallPO);
			System.out.println("id>>>>>" + totalBallPO.getId());
		}

		System.out.println(">>>>>>>>>>" + SsqFileUtils.tblist.size());
	}

}
