package com.nenu.student.database;

import java.sql.*;

public class DatabaseConnection {

	private static Connection con = null;


	private static final String URL = "jdbc:mysql://localhost:3306/db_sthomework01";
	private static final String USER = "root";
	private static final String PASSWORD = "123456dsc";


	public static Connection getCon() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("�������ݿ�����ʧ�ܣ�");
			e.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			if(con != null) {
				System.out.println("���ݿ����ӳɹ���");
			}
		} catch (SQLException e) {
			System.out.println("���ݿ�����ʧ�ܣ�");
			e.printStackTrace();
		}

		return con;
	}
}
