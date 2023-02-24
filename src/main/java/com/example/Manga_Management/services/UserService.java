package com.example.Manga_Management.services;

import com.example.Manga_Management.Entity.User;
import com.example.Manga_Management.pojo.UserPojo;

import java.io.IOException;
import java.util.List;

public interface UserService {
    com.example.Manga_Management.pojo.UserPojo save(com.example.Manga_Management.pojo.UserPojo userPojo) throws IOException;
    com.example.Manga_Management.Entity.User findById(long id);

    void login(String username, String password);

    User fetchById(Integer id);

    List<User> fetchAll();

    void deleteById(Integer id);
}

