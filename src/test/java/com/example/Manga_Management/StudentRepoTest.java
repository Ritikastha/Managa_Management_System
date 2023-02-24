package com.example.Manga_Management;

import com.example.Manga_Management.Entity.Student;
import com.example.Manga_Management.Entity.User;
import com.example.Manga_Management.repo.StudentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class StudentRepoTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveStudentTest(){
        Student student= Student.builder()
                .firstName("Ritika")
                .lastName(" Shrestha")
                .email("ritika@gmail.com")
                .build();

        studentRepository.save(student);
        Assertions.assertThat(student.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getStudentTest(){

        Student studentGet=studentRepository.findById(1L).get();
        Assertions.assertThat(studentGet.getId()).isGreaterThan(0);
    }


    @Test
    @Order(3)
    public void getListOfStudentTest(){
        List<Student> students=studentRepository.findAll();
        Assertions.assertThat(students.size()).isGreaterThan(0);
    }


    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateStudentTest(){
        Student student=studentRepository.findById(1L).get();
        student.setFirstName("Ritika");
        Student StudentUpdated=studentRepository.save(student);
        Assertions.assertThat(StudentUpdated.getFirstName()).isEqualTo("Ritika");
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteStudentTest(){
        Student student=studentRepository.findById(1L).get();
        studentRepository.delete(student);
        Student student1=null;
        Optional<Student> opStudent= studentRepository.findStudentByFirstName("Ritika Shrestha");
        if(opStudent.isPresent()){
            student1=opStudent.get();
        }
        Assertions.assertThat(student1).isNull();
    }
}

