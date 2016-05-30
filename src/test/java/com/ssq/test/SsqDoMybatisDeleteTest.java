package com.ssq.test;

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
	
	  //随机生成5个1至100之间的整数。显示这5个数的和以及平均值，然后从大到小显示。
    public static void main(String[] args) {
        int[] arr = new int[1000];
        int pingjun = 0;
        for(int i = 0; i < arr.length; i++){
            arr[i] = new java.util.Random().nextInt(9)+1;
            pingjun += arr[i];
        }
//        java.util.Arrays.sort(arr);
        System.out.println("这五个数是：" + java.util.Arrays.toString(arr));
        System.out.println("平均的值是：" + (pingjun / 5));
    }

}
