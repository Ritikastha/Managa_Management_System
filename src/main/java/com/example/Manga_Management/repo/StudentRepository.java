package com.example.Manga_Management.repo;

import com.example.Manga_Management.Entity.Student;

import com.example.Manga_Management.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "select * from students where firstname=?1", nativeQuery = true)
    Optional<Student> findStudentByFirstName(String firstname);
}
