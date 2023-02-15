//package com.example.Student_Library_.Management_System.Repositories;
//
//import com.example.Student_Library_.Management_System.Model.Book;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface BookRepository extends JpaRepository<Book,Integer> {
//
//
//}
package com.example.Student_Library_.Management_System.Repositories;

import com.example.Student_Library_.Management_System.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}