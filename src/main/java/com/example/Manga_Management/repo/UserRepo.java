package com.example.Manga_Management.repo;
import com.example.Manga_Management.Entity.User;
//import com.example.educa.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {


    @Query(value = "select * from users where email=?1", nativeQuery = true)
    Optional<User> findByEmail(String email);

    @Query(value = "select * from users where fullname=?1", nativeQuery = true)
    Optional<User> findUserByFullName(String fullname);
}