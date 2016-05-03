package com.ssq.test;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ssq.dao.TotalBallDao;

public class SsqDoMybatisDeleteTest {

	private SqlSessionFactory sqlSessionFactory;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		// mybatis 配置文件
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		// 创建会话工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void test() {
		// 通过工厂得到sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 通过sqlsession 操作数据库
		// 第一个参数：映射文件中statement的id，等于=namespace+"."+statement的id
		// 第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		// selectOne("test.selectTotalBall", 1)
		TotalBallDao totalBallDao = sqlSession.getMapper(TotalBallDao.class);
		totalBallDao.deleteTotalBall();
		sqlSession.commit();
		// 释放资源
		sqlSession.close();

	}

}
