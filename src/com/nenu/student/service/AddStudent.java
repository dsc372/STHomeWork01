package com.nenu.student.service;

import com.nenu.student.database.DatabaseConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: Liangll
 * @Description: 增加学生信息
 * @Date: 16:37 2020/4/20
 */
public class AddStudent extends JFrame implements ActionListener {



	JLabel numberLabel = new JLabel("学         号");
	JTextField numberTextField = new JTextField();

	JLabel nameLabel = new JLabel("姓         名");
	JTextField nameTextField = new JTextField();

	JLabel birthLabel = new JLabel("出生日期");
	JTextField birthTextField = new JTextField();


	JLabel sexLabel = new JLabel("性         别");

	ButtonGroup btnGroup = new ButtonGroup();

	JRadioButton radioBtn01 = new JRadioButton("男");
	JRadioButton radioBtn02 = new JRadioButton("女");

	JButton addBtn = new JButton("添加");
	JButton readBtn = new JButton("重置");
	JButton cancelBtn = new JButton("取消");

	public AddStudent() {

		this.setTitle("添加学生信息");

		this.setLayout(null);


		numberLabel.setBounds(90, 60, 60, 25);
		numberTextField.setBounds(150, 60, 120, 25);
		this.add(numberLabel);
		this.add(numberTextField);


		nameLabel.setBounds(90, 100, 60, 20);
		nameTextField.setBounds(150, 100, 120, 25);
		this.add(nameLabel);
		this.add(nameTextField);

		sexLabel.setBounds(90,140,60,20);

		radioBtn01.setBounds(150, 140, 65, 20);

		radioBtn02.setBounds(215, 140, 65, 20);

		btnGroup.add(radioBtn01);
		btnGroup.add(radioBtn02);
		this.add(sexLabel);
		this.add(radioBtn01);
		this.add(radioBtn02);


		birthLabel.setBounds(90, 180, 60, 20);
		birthTextField.setBounds(150, 180, 120, 25);
		this.add(birthLabel);
		this.add(birthTextField);
		

		addBtn.setBounds(90, 250, 60, 25);
		readBtn.setBounds(160, 250, 60, 25);
		cancelBtn.setBounds(230, 250, 60, 25);


		addBtn.addActionListener(this);
		readBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		
		this.add(addBtn);
		this.add(readBtn);
		this.add(cancelBtn);

		this.setVisible(true);

		this.setSize(380, 380);

		this.setLocationRelativeTo(null);
	}


	public void addStudentInfo(int studentId, String studentName, String studentBirth, String studentSex){

		String sql = "select * from t_student where id='" + studentId + "'";

		try {

			Statement stm = DatabaseConnection.getCon().createStatement();

			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "该学号学生已存在！", "提示信息", JOptionPane.WARNING_MESSAGE);
			} else {

				sql = "insert into t_student values('" + studentId + "','" + studentName + "','" + studentBirth + "','" + studentSex + "')";

				int i = stm.executeUpdate(sql);
				if(i > 0) {
					JOptionPane.showMessageDialog(null, "添加成功！", "提示信息", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "添加失败！", "提示信息", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			stm.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addBtn) {

			int sId = Integer.parseInt(numberTextField.getText());
			String sName = nameTextField.getText();
			String sSex = "女";
			String sBirth = birthTextField.getText();


			if(radioBtn01.isSelected()) {
				sSex = "男";
			}

			try {
				addStudentInfo(sId, sName, sBirth, sSex);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		if(e.getSource() == readBtn) {
			numberTextField.setText(null);
			nameTextField .setText(null);
			birthTextField.setText(null);
		}

		if(e.getSource() == cancelBtn) {
			setVisible(false);
		}
	}
}