package com.example.week6d1.servis;

import com.example.week6d1.ApiExipion.ApiExiception;
import com.example.week6d1.MPDEL.Todo;
import com.example.week6d1.Repostry.TodoRepostry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TOdoservis {
    private final TodoRepostry todoRepostry;

    public List<Todo> getTodo() {
        return todoRepostry.findAll();
    }

    public void addTodo(Integer myuser, Todo todo) {
        todo.setId(todo.getId());

    }

    public void updateTodo(Integer userId, Todo todo , Integer TodoId) {
        Todo oldtodo=todoRepostry.findTodosById(TodoId);
        if (oldtodo==null){
            throw new ApiExiception("todo not fuond");
        }
        if (oldtodo.getId()!=userId){
            throw new ApiExiception("error, ");
        }
        oldtodo.setMassege(todo.getMassege());
        todoRepostry.save(oldtodo);
    }

    public void deleteTodo(Integer userId, Integer TodoId) {
        Todo oldtodo=todoRepostry.findTodosById(TodoId);
        if (oldtodo==null){
            throw new ApiExiception("todo not fuond");
        }
        if (oldtodo.getId()!=userId){
            throw new ApiExiception("error, ");
        }
        todoRepostry.save(oldtodo);
    }


}
