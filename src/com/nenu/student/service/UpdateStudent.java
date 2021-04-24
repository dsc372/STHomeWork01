package com.nenu.student.service;

import com.nenu.student.database.DatabaseConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UpdateStudent extends JFrame implements ActionListener {


	JLabel jlnumber = new JLabel("ѧ         ��");
	JTextField jtnumber = new JTextField();

	JLabel jlname = new JLabel("��         ��");
	JTextField jtname = new JTextField();

	JLabel jlbirth = new JLabel("��������");
	JTextField jtbirth = new JTextField();


	JLabel jlsex = new JLabel("��         ��");

	ButtonGroup btnGroup = new ButtonGroup();

	JRadioButton radioBtn01 = new JRadioButton("��");
	JRadioButton radioBtn02 = new JRadioButton("Ů");

	JButton ensureBtn = new JButton("ȷ��");
	JButton readBtn = new JButton("����");
	JButton cancelBtn = new JButton("ȡ��");

	public UpdateStudent() {
		this.setTitle("�޸�ѧ����Ϣ");
		this.setLayout(null);


		jlnumber.setBounds(90, 60, 60, 25);
		jtnumber.setBounds(150, 60, 120, 25);
		this.add(jlnumber);
		this.add(jtnumber);


		jlname.setBounds(90, 100, 60, 20);
		jtname.setBounds(150, 100, 120, 25);
		this.add(jlname);
		this.add(jtname);


		jlsex.setBounds(90,140,60,20);

		radioBtn01.setBounds(150, 140, 65, 20);

		radioBtn02.setBounds(215, 140, 65, 20);

		btnGroup.add(radioBtn01);
		btnGroup.add(radioBtn02);
		this.add(jlsex);
		this.add(radioBtn01);
		this.add(radioBtn02);


		jlbirth.setBounds(90, 180, 60, 20);
		jtbirth.setBounds(150, 180, 120, 25);
		this.add(jlbirth);
		this.add(jtbirth);


		ensureBtn.setBounds(90, 250, 60, 25);
		readBtn.setBounds(160, 250, 60, 25);
		cancelBtn.setBounds(230, 250, 60, 25);


		ensureBtn.addActionListener(this);
		readBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		this.add(ensureBtn);
		this.add(readBtn);
		this.add(cancelBtn);

		this.setVisible(true);

		this.setSize(380, 380);

		this.setLocationRelativeTo(null);
	}


	public void updateStudentInfo(int studentId, String studentName,
								  String studentBirth, String studentSex){


		String sql = "select * from t_student where id='" + studentId + "'";


		try {
			Statement stm = DatabaseConnection.getCon().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()) {

				sql = "update t_student set name ='" + studentName + "',birDate='" + studentBirth + "',gender='"
						+ studentSex + "'where id=" + studentId;

				int i = stm.executeUpdate(sql);
				if(i > 0) {

					JOptionPane.showMessageDialog(null, "�޸ĳɹ���",
							"��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
				}else {

					JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�",
							"��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {

				JOptionPane.showMessageDialog(null, "��ѧ��ѧ�������ڣ�",
						"��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
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
			String sName = jtname.getText();
			String sSex = "Ů";
			String sBirth = jtbirth.getText();

			if(radioBtn01.isSelected()) {
				sSex = "��";
			}

			try {
				updateStudentInfo(sId, sName, sBirth, sSex);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		if(e.getSource() == readBtn) {
			jtnumber.setText(null);
			jtname.setText(null);
			jtbirth.setText(null);
		}

		if(e.getSource() == cancelBtn) {
			setVisible(false);
		}
	}
}