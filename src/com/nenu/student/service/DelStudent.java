package com.nenu.student.service;

import com.nenu.student.database.DatabaseConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DelStudent extends JFrame implements ActionListener {


	JLabel jlnumber = new JLabel("学号");
	JTextField jtnumber = new JTextField();

	JButton ensureBtn = new JButton("确定");
	JButton nextBtn = new JButton("重置");
	JButton cancelBtn = new JButton("取消");

	public DelStudent() {
		this.setTitle("删除学生信息");
		this.setLayout(null);


		jlnumber.setBounds(120, 100, 30, 20);
		jtnumber.setBounds(150, 100, 120, 25);
		this.add(jlnumber);
		this.add(jtnumber);

		ensureBtn.setBounds(100, 250, 60, 25);
		nextBtn.setBounds(170, 250, 60, 25);
		cancelBtn.setBounds(240, 250, 60, 25);


		ensureBtn.addActionListener(this);
		nextBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		this.add(ensureBtn);
		this.add(nextBtn);
		this.add(cancelBtn);
		this.setVisible(true);

		this.setSize(380, 380);

		this.setLocationRelativeTo(null);
	}


	public void delStudentInfo(int studentNumber){


		int sId = studentNumber;


		String sql = "select * from t_student where id='" + sId + "'";


		try {
			Statement stm = DatabaseConnection.getCon().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()) {
				sql = "delete from t_student where id ='" + sId + "'";
				int i = stm.executeUpdate(sql);
				if(i > 0) {
					JOptionPane.showMessageDialog(null, "删除成功！", "提示信息", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "删除失败！", "提示信息", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			stm.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ensureBtn) {

			int sId = Integer.parseInt(jtnumber.getText());

			try {
				delStudentInfo(sId);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		if(e.getSource() == nextBtn) {
			jtnumber.setText(null);
		}
		if(e.getSource() == cancelBtn) {
			setVisible(false);
		}
	}
}