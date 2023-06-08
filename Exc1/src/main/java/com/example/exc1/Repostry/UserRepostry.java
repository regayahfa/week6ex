package com.example.exc1.Repostry;

import com.example.exc1.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepostry extends JpaRepository<MyUser, Integer> {

    MyUser findmyUserById(Integer id);

    MyUser findAllByOrder();
}
