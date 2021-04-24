package com.nenu.student.service;

import com.nenu.student.database.DatabaseConnection;
import com.nenu.student.entity.Student;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ListAllStudent extends JFrame {

    private Object [][]rowData;
    private final Object []column = {"学号", "姓名", "出生日期", "性别"};


    JTextField jtname = new JTextField(16);

    public ListAllStudent() {
        jtname.setText(null);
        setTable(" ");
    }


    public void setTable(String name) {
        this.setVisible(false);

        JFrame jf = new JFrame("学生全部信息");
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


        table.setPreferredScrollableViewportSize(new Dimension(550,400));


        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        jf.add(panel);
        jf.pack();
        jf.setContentPane(panel);
        jf.setVisible(true);
    }

    public java.util.List<Student> queryAllUser(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from t_student";
        java.util.List<Student> list = new ArrayList<Student>();

        try {
            conn = DatabaseConnection.getCon();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setBirDate(rs.getString(3));
                student.setGender(rs.getString(4));
                list.add(student);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public Object[][] queryData(String name){
        if (" ".equals(name)) {
            List<Student> list = queryAllUser();
            if(list.size() >= 20){

                JOptionPane.showMessageDialog(null, "学生信息已超过20条！",
                        "提示信息", JOptionPane.WARNING_MESSAGE);
            }
            rowData = new Object[list.size()][column.length];
            for(int i = 0;i < list.size();i++){
                for(int j = 0;j < column.length;j++) {
                    rowData[i][0] = list.get(i).getId();
                    rowData[i][1] = list.get(i).getName();
                    rowData[i][2] = list.get(i).getBirDate();
                    rowData[i][3] = list.get(i).getGender();
                    System.out.print(rowData[i][j] + "    ");
                }
                System.out.println();
            }
        }
        return rowData;
    }
}