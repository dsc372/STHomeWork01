package com.nenu.student.main;

import com.nenu.student.service.StudentManagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StudentApplication extends Frame implements ActionListener {



    public static void main(String[] args) {
        new StudentManagement();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }
}


