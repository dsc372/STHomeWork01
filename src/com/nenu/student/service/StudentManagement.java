package com.nenu.student.service;

import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StudentManagement extends JFrame implements ActionListener{


	JMenuBar menubar = new JMenuBar();

	JMenu addInformationMenu = new JMenu("插入学生");
	JMenu searchInformationMenu = new JMenu("查找学生");
	JMenu delInformationMenu = new JMenu("删除学生");
	JMenu updateInformationMenu = new JMenu("修改学生信息");
	JMenu listInformationMenu = new JMenu("输出全部学生信息");
	JMenu otherMenu = new JMenu("退出");

	JMenuItem listMenu = new JMenuItem("输出学生信息");
	JMenuItem addMenu = new JMenuItem("增加学生信息");
	JMenuItem deleteMenu = new JMenuItem("删除学生信息");
	JMenuItem alterMenu = new JMenuItem("修改学生信息");
	JMenuItem searchInforMenu = new JMenuItem("查询学生信息");
	JMenuItem quitMenu = new JMenuItem("退出");


	JLabel label = new JLabel();

	public StudentManagement() {

		super();


		this.setTitle("东北师范大学信息科学与技术学院学生信息管理系统");

		this.setLayout(new BorderLayout());

		this.setJMenuBar(menubar);

		this.setResizable(true);




		Font font2 = new Font("宋体", Font.PLAIN, 14);
		listInformationMenu.setFont(font2);
		addInformationMenu.setFont(font2);
		delInformationMenu.setFont(font2);
		updateInformationMenu.setFont(font2);
		searchInformationMenu.setFont(font2);
		otherMenu.setFont(font2);


		menubar.add(listInformationMenu);
		menubar.add(addInformationMenu);
		menubar.add(delInformationMenu);
		menubar.add(updateInformationMenu);
		menubar.add(searchInformationMenu);
		menubar.add(otherMenu);
		listInformationMenu.addActionListener(this);
		addInformationMenu.addActionListener(this);
		delInformationMenu.addActionListener(this);
		updateInformationMenu.addActionListener(this);
		searchInformationMenu.addActionListener(this);
		otherMenu.addActionListener(this);


		listInformationMenu.add(listMenu);
		addInformationMenu.add(addMenu);
		delInformationMenu.add(deleteMenu);
		updateInformationMenu.add(alterMenu);
		searchInformationMenu.add(searchInforMenu);
		otherMenu.add(quitMenu);
		listMenu.addActionListener(this);
		addMenu.addActionListener(this);
		deleteMenu.addActionListener(this);
		alterMenu.addActionListener(this);
		searchInforMenu.addActionListener(this);
		quitMenu.addActionListener(this);


		label.setIcon(new ImageIcon("src/com/nenu/student/resources/timg.jpg"));


		this.add(label);

		this.setVisible(true);

		this.setSize(550, 550);

		this.setLocationRelativeTo(null);


		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				System.exit(0);
			}
		});
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == listMenu) {
			new ListAllStudent();
		}

		if(e.getSource() == addMenu) {
			new AddStudent();
		}

		if(e.getSource() == deleteMenu) {
			new DelStudent();
		}

		if(e.getSource() == alterMenu) {
			new UpdateStudent();
		}

		if(e.getSource() == searchInforMenu) {
			new SelectStudent();
		}

		if(e.getSource() == quitMenu) {
			System.exit(0);
		}
	}
}