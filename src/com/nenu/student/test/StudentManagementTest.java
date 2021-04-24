package com.nenu.student.test;

import com.nenu.student.entity.Student;
import com.nenu.student.service.*;
import org.junit.Test;

import java.util.List;

public class StudentManagementTest {


    @Test
    public void testQueryAllUser(){
        ListAllStudent listAllStudent = new ListAllStudent();
        try{
            List<Student> list = listAllStudent.queryAllUser();
            System.out.println(list);
            System.out.println("测试查找全部学生成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void testAddStudentInfo(){
        AddStudent addStudent = new AddStudent();


        int sId = 2018000009;
        String sName = "崔丝塔娜";
        String sBirth = "19920101";
        String sSex = "女";
        try{
            addStudent.addStudentInfo(sId, sName, sBirth, sSex);
            System.out.println("测试插入学生成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void testDelStudentInfo(){
        DelStudent delStudent = new DelStudent();

        int sId = 2018000009;
        try{
            delStudent.delStudentInfo(sId);
            System.out.println("测试删除学生成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void testUpdateStudentInfo(){
        UpdateStudent updateStudent = new UpdateStudent();

        int sId = 2018000008;
        String sName = "薇恩";
        String sBirth = "19930102";
        String sSex = "女";
        try{
            updateStudent.updateStudentInfo(sId, sName, sBirth, sSex);
            System.out.println("测试修改学生成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void testQueryUser(){
        SelectStudent selectStudent = new SelectStudent();

        String sName = "薇恩";
        try{
            System.out.println(selectStudent.queryUser(sName));
            System.out.println("测试查找学生成功！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
