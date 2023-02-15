package com.example.Student_Library_.Management_System.Controllers;

import com.example.Student_Library_.Management_System.Model.Student;
import com.example.Student_Library_.Management_System.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return "Student and Card Added";
    }

    @GetMapping("/get_user")
    public String getNameByEmail(@RequestParam("email") String email){
         return studentService.getNameByUser(email);
    }

    @PutMapping("/update_mob")
    public String updateMob(@RequestBody Student student){
        return studentService.updateMob(student);
    }

}
