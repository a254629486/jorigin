package com.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.ssq.po.TotalBallPO;

public class SsqFileUtils {
	
	public static ArrayList<TotalBallPO> tblist = new ArrayList<TotalBallPO>();
	
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

}
