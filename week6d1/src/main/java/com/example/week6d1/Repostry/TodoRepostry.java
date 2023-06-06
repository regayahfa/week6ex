package com.example.week6d1.Repostry;

import com.example.week6d1.MPDEL.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepostry extends JpaRepository<Todo,Integer> {
Todo findTodosById(Integer id);
//    List<Todo>findTodosByUserId(Integer user);
}
