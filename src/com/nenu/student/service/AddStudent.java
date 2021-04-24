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
 * @Description: ����ѧ����Ϣ
 * @Date: 16:37 2020/4/20
 */
public class AddStudent extends JFrame implements ActionListener {



	JLabel numberLabel = new JLabel("ѧ         ��");
	JTextField numberTextField = new JTextField();

	JLabel nameLabel = new JLabel("��         ��");
	JTextField nameTextField = new JTextField();

	JLabel birthLabel = new JLabel("��������");
	JTextField birthTextField = new JTextField();


	JLabel sexLabel = new JLabel("��         ��");

	ButtonGroup btnGroup = new ButtonGroup();

	JRadioButton radioBtn01 = new JRadioButton("��");
	JRadioButton radioBtn02 = new JRadioButton("Ů");

	JButton addBtn = new JButton("���");
	JButton readBtn = new JButton("����");
	JButton cancelBtn = new JButton("ȡ��");

	public AddStudent() {

		this.setTitle("���ѧ����Ϣ");

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
				JOptionPane.showMessageDialog(null, "��ѧ��ѧ���Ѵ��ڣ�", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
			} else {

				sql = "insert into t_student values('" + studentId + "','" + studentName + "','" + studentBirth + "','" + studentSex + "')";

				int i = stm.executeUpdate(sql);
				if(i > 0) {
					JOptionPane.showMessageDialog(null, "��ӳɹ���", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "���ʧ�ܣ�", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
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
			String sSex = "Ů";
			String sBirth = birthTextField.getText();


			if(radioBtn01.isSelected()) {
				sSex = "��";
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