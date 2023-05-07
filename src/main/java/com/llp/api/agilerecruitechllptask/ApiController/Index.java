package com.llp.api.agilerecruitechllptask.ApiController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.llp.api.agilerecruitechllptask.ApiModel.Student;
import com.llp.api.agilerecruitechllptask.ApiService.Service;
import java.util.List;

@RestController
public class Index {

    @Autowired
    Service serviceobj;
    
    @GetMapping("/")
    public String showWelcomMessage(){
      return serviceobj.showWelcomMessage();
    }

    @PostMapping("/add-student")
    public boolean addStudent(@RequestBody Student studentObj){
        return serviceobj.addStudent(studentObj);
    }

    @GetMapping("/view-students")
    public List<Student> showAllStudentList(){
      return serviceobj.showAllStudentList();
    }

    @DeleteMapping("/delete-student/{rollNumber}")
    public boolean deleteStudentById(@PathVariable int rollNumber) {
      return serviceobj.deleteStudentByRollNumber(rollNumber);
    }
    
    @GetMapping("/find-student/{rollNumber}")
    public List<Student> findStudentByRollNumber(@PathVariable int rollNumber) {
      return serviceobj.findStudentByRollNumber(rollNumber);
    }
    
    @PutMapping("/update-student/{rollNumber}")
    public boolean updateStudentByRollNumber(@PathVariable int rollNumber, String name) {
      return serviceobj.updateStudentByRollNumber(rollNumber, name);
    }

}
