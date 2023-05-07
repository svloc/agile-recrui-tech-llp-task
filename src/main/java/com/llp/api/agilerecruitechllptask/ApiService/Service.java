package com.llp.api.agilerecruitechllptask.ApiService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.llp.api.agilerecruitechllptask.ApiModel.Student;

@Component
public class Service {
    private final String welcomeMessage = "1]Add Student:add-student \n2]View all Student: view-students \n3]Update Student: update-student/{rollNumber} \4]Delete Student by rollNumber /delete-student/{rollNumber} \5]Find Student by Rollnumber /find-student/{rollNumber}" ;

    private List<Student> studentDataList = new ArrayList<>();

    public List<Student> getStudentDataList() {
        return studentDataList;
    }

    public String showWelcomMessage() {
        return welcomeMessage;
    }

    public void setStudentDataList(List<Student> studentDataList) {
        this.studentDataList = studentDataList;
    }
    public List<Student> showAllStudentList() {
        return getStudentDataList();
    }

    public boolean addStudent(Student studentObj) {
        studentDataList.add(studentObj);
        if (studentDataList.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean deleteStudentByRollNumber(int rollNumber) {
        boolean deleteStatus=false;
        for(Student stObj: studentDataList){
            if(stObj.getRollNumber()==rollNumber){
                studentDataList.remove(stObj);
                deleteStatus=true;
            }
        }
        return deleteStatus;
    }

    public List<Student> findStudentByRollNumber(int rollNumber) {
        List<Student>tempList=new ArrayList<>();
        for(Student stObj: studentDataList){
            if(stObj.getRollNumber()==rollNumber){
                tempList.add(stObj);
            }
        }
        return tempList;
    }
    
    public boolean updateStudentByRollNumber(int rollNumber,String name) {
        for(Student stObj: studentDataList){
            if(stObj.getRollNumber()==rollNumber){
                stObj.setName(name);
                return true;
            }
        }
        return false;

    }

}
