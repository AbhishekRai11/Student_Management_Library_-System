package com.example.Student_Library_.Management_System.Repositories;

import com.example.Student_Library_.Management_System.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

}
