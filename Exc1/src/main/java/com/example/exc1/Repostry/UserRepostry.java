package com.example.exc1.Repostry;

import com.example.exc1.Model.myUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepostry extends JpaRepository<myUser, Integer> {

    myUser findmyUserById(Integer id);

    myUser findAllByOrder();
}
