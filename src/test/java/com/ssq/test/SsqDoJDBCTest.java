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
			//������������
			Class.forName("com.mysql.jdbc.Driver");
			//ͨ�������������ȡ���ݿ�����
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssq?characterEncoding=utf-8","root","root");
			
			String sql = "select * from totalball where id = ?";
			
			//��ȡԤ�����statement
			preparedStatement = connection.prepareStatement(sql);
			
			// ���ò���
			preparedStatement.setString(1, "1");
			
			//�����ݿⷢ��sqlִ�в�ѯ����ѯ�����
			resultSet = preparedStatement.executeQuery();
			
			//������ѯ�����
			while(resultSet.next()){
				System.out.println(resultSet.getString("id") + " " + resultSet.getString("opendate"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//�ͷ���Դ
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
