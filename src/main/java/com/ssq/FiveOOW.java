package com.ssq;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.ssq.po.TotalBallPO;

public class FiveOOW {
	
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
	 * ����ת����
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
   * ����TXT
   * @param filePath
   */
  public static void readTxtFile(String filePath){
        try {
                String encoding="UTF-8";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ����
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//���ǵ������ʽ
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                    	if(lineTxt.startsWith("20"))
                        tblist.add(stringToObject(lineTxt));
                    }
                    read.close();
        }else{
            System.out.println("�Ҳ���ָ�����ļ�");
        }
        } catch (Exception e) {
            System.out.println("��ȡ�ļ����ݳ���");
            e.printStackTrace();
        }
     
    }
	public static void main(String[] args) {

		String filePath = "D:\\2015-2008.txt";
		
        readTxtFile(filePath);
        for (TotalBallPO tb : tblist) {
			System.out.println(tb.toString());
		}

	}

}
