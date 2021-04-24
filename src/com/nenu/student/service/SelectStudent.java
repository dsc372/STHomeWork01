package com.nenu.student.service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

import com.nenu.student.database.DatabaseConnection;
import com.nenu.student.entity.Student;

public class SelectStudent extends JFrame implements ActionListener {

	private Object [][]rowData;
	private final Object []column = {"学号", "姓名", "出生日期", "性别"};

	JPanel ePanel = new JPanel();
	JPanel wPanel = new JPanel();


	JLabel jlname = new JLabel("姓名");
	JTextField jtname = new JTextField(16);

	JButton searchBtn = new JButton("查询");
	JButton nextBtn = new JButton("重置");
	JButton cancelBtn = new JButton("取消");

	public SelectStudent() {
		this.setTitle("查询学生信息");
		this.setLayout(new BorderLayout());


		wPanel.add(jlname);
		wPanel.add(jtname);


		ePanel.add(searchBtn);
		ePanel.add(nextBtn);
		ePanel.add(cancelBtn);


		searchBtn.addActionListener(this);
		nextBtn.addActionListener(this);
		cancelBtn.addActionListener(this);


		this.add(ePanel, BorderLayout.SOUTH);
		this.add(wPanel, BorderLayout.NORTH);

		this.pack();

		this.setLocationRelativeTo(null);

		this.setSize(400, 150);
		this.setVisible(true);
	}


	public void setTable(String name) {
		this.setVisible(false);
		JFrame jf = new JFrame("查询结果");
		jf.setLocationRelativeTo(null);
		JPanel panel = new JPanel();


		Object [][]rowData = queryData(name);
		JTable table = new JTable(rowData, column);


		table.setForeground(Color.BLACK);

		table.setFont(new Font(null, Font.PLAIN, 14));

		table.setSelectionBackground(Color.DARK_GRAY);

		table.setSelectionForeground(Color.LIGHT_GRAY);

		table.setGridColor(Color.GRAY);


		table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));


		table.getTableHeader().setForeground(Color.BLACK);


		table.getTableHeader().setResizingAllowed(false);


		table.getTableHeader().setReorderingAllowed(false);


		table.setRowHeight(30);


		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);


		table.setPreferredScrollableViewportSize(new Dimension(550,200));


		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane);
		jf.add(panel);
		jf.pack();
		jf.setContentPane(panel);
		jf.setVisible(true);
	}


	public Student queryUser(String name){
		Connection conn = null;

		PreparedStatement ps = null;

		ResultSet rs = null;
		Student student = new Student();
		String sql = "select * from t_student where name='" + name + "'";
		try {
			conn = DatabaseConnection.getCon();

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setBirDate(rs.getString(3));
				student.setGender(rs.getString(4));
			}else {

				JOptionPane.showMessageDialog(null, "该账号不存在！",
						"提示信息", JOptionPane.WARNING_MESSAGE);

			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}


    public Object[][] queryData(String name){
		if(" ".equals(name)) {

			JOptionPane.showMessageDialog(null, "输入为空，请重新输入！", "提示信息", JOptionPane.WARNING_MESSAGE);

		}else {
        	Student student = queryUser(name);

			rowData = new Object[1][column.length];
			rowData[0][0] = student.getId();
			rowData[0][1] = student.getName();
			rowData[0][2] = student.getBirDate();
			rowData[0][3] = student.getGender();
		}
		return rowData;
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == searchBtn) {
			String name = jtname.getText();
			setTable(name);
		}
		if(e.getSource() == nextBtn) {
			jtname.setText(null);
		}
		if(e.getSource() == cancelBtn) {
			this.setVisible(false);
		}
	}
}