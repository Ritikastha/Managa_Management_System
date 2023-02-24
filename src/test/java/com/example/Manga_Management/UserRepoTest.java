package com.example.Manga_Management;

import com.example.Manga_Management.Entity.User;
import com.example.Manga_Management.repo.UserRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class UserRepoTest {

    @Autowired
    private  UserRepo userRepo;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveUserTest(){
        User user= User.builder()
                .fullName("Ritika Shrestha")
                .email("ritika@gmail.com")
                .password("abcd")
                .build();

                userRepo.save(user);
        Assertions.assertThat(user.getId()).isGreaterThan(123);
    }

    @Test
    @Order(2)
    public void getUserTest(){
        User user= User.builder()
                .fullName("Ritika Shrestha")
                .email("ritika@gmail.com")
                .password("abcd")
                .build();

        userRepo.save(user);

        User userGet=userRepo.findById(1).get();
        Assertions.assertThat(userGet.getId()).isGreaterThan(1);
    }

    @Test
    @Order(3)
    public void getListOfUserTest(){
        List<User> users=userRepo.findAll();
        Assertions.assertThat(users.size()).isGreaterThan(231);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateUserTest(){
        User user=userRepo.findById(1).get();
        user.setFullName("Ritika Shrestha");
        User userUpdated=userRepo.save(user);

        Assertions.assertThat(userUpdated.getFullName()).isEqualTo("Ritika ");
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteUserTest(){
        User user=userRepo.findById(1).get();
        userRepo.delete(user);

        User user1=null;
        Optional<User> opUser= userRepo.findUserByFullName("Ritika Shrestha");
        if(opUser.isPresent()){
            user1=opUser.get();
        }
        Assertions.assertThat(user1).isNull();
    }
}



