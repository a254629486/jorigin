package com.ssq.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SsqDoJDBCTest {

	
	
	public static void main(String[] args) {
		
		Connection connection = null ;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			//加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//通过驱动管理类获取数据库连接
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssq?characterEncoding=utf-8","root","root");
			
			String sql = "select * from totalball where id = ?";
			
			//获取预处理的statement
			preparedStatement = connection.prepareStatement(sql);
			
			// 设置参数
			preparedStatement.setString(1, "1");
			
			//向数据库发出sql执行查询，查询结果集
			resultSet = preparedStatement.executeQuery();
			
			//遍历查询结果集
			while(resultSet.next()){
				System.out.println(resultSet.getString("id") + " " + resultSet.getString("opendate"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//释放资源
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(preparedStatement!=null){
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
				
	}

}
