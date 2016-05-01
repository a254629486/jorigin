package com.ssq.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.ssq.po.TotalBallPO;

public class SsqDoMybatisTest {

	public static ArrayList<TotalBallPO> tblist = new ArrayList<TotalBallPO>();
	
//	@Test
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
		TotalBallPO totalBall = sqlSession.selectOne("test.selectTotalBall", 1);
		
		System.out.println(totalBall);
		
		//释放资源
		sqlSession.close();
		
	}
	
	public static Date parseDate(String dateStr){
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    try {
	        java.util.Date d = sdf.parse(dateStr);
	        return new Date(d.getTime());
	    } catch (ParseException e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	/**
	 * 读行转对象
	 * @param lineTxt
	 * @return
	 */
  public static TotalBallPO stringToObject(String lineTxt){
	  TotalBallPO tb = new TotalBallPO();
	  String[] s1 = lineTxt.split("@");
	  tb.setOpendate(parseDate(s1[0]));
	  String[] s2 = s1[1].split("\\|");
	  tb.setBlue(Integer.parseInt(s2[1]));
	  String[] s3 = s2[0].split(",");
	  tb.setRed1(Integer.parseInt(s3[0]));
	  tb.setRed2(Integer.parseInt(s3[1]));
	  tb.setRed3(Integer.parseInt(s3[2]));
	  tb.setRed4(Integer.parseInt(s3[3]));
	  tb.setRed5(Integer.parseInt(s3[4]));
	  tb.setRed6(Integer.parseInt(s3[5]));
	  return tb;
  }
  /**
   * 解析TXT
   * @param filePath
   */
  public static void readTxtFile(String filePath){
        try {
                String encoding="UTF-8";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                    	if(lineTxt.startsWith("20"))
                        tblist.add(stringToObject(lineTxt));
                    }
                    read.close();
        }else{
            System.out.println("找不到指定的文件");
        }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
     
    }
	@Test
	public void insertTotalBallTest() throws IOException{
		
		
		String filePath = "D:\\2015-2008.txt";
		
        readTxtFile(filePath);
       /* for (TotalBallPO tb : tblist) {
			System.out.println(tb.toString());
		}*/
		
		//mybatis 配置文件
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		//创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过工厂得到sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//通过sqlsession 操作数据库
		//第一个参数：映射文件中statement的id，等于=namespace+"."+statement的id
		//第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		
		System.out.println("条数："+tblist.size());
		
		for (TotalBallPO totalBallPO : tblist) {
			sqlSession.insert("test.insertTotalBall", totalBallPO);
		}
		sqlSession.commit();
		
		//释放资源
		sqlSession.close();
		
	}
	

}
