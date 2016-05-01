package com.ssq.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.ssq.po.TotalBallPO;

public class SsqDoMybatisTest {

	@Test
	public void findTotalBallTest() throws IOException{
		
		//mybatis 配置文件
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		//创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过工厂得到sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//通过sqlsession 操作数据库
		//第一个参数：映射文件中statement的id，等于=namespace+"."+statement的id
		//第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		TotalBallPO totalBall = sqlSession.selectOne("test.selectTotalball", 1);
		
		System.out.println(totalBall);
		
		//释放资源
		sqlSession.close();
		
	}
	

}
