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
		
		//mybatis �����ļ�
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		//�����Ự����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//ͨ�������õ�sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//ͨ��sqlsession �������ݿ�
		//��һ��������ӳ���ļ���statement��id������=namespace+"."+statement��id
		//�ڶ���������ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���
		TotalBallPO totalBall = sqlSession.selectOne("test.selectTotalball", 1);
		
		System.out.println(totalBall);
		
		//�ͷ���Դ
		sqlSession.close();
		
	}
	

}
