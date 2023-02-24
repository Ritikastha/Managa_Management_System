package com.example.Manga_Management.repo;

import com.example.Manga_Management.Entity.Menu;


import com.example.Manga_Management.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    @Query(value = "select * from menu where name=?1", nativeQuery = true)
    Optional<Menu> findBookByName(String name);
}
