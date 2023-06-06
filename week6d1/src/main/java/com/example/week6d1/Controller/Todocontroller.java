package com.example.week6d1.Controller;

import com.example.week6d1.MPDEL.Myuser;
import com.example.week6d1.MPDEL.Todo;
import com.example.week6d1.servis.TOdoservis;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
@RequiredArgsConstructor
public class Todocontroller {
    private final TOdoservis todoservis;

    @GetMapping("/get")
    public ResponseEntity getTodo(@AuthenticationPrincipal Myuser myuser){

        List<Todo>todos=todoservis.getTodo();

        return ResponseEntity.status(200).body(todos);
    }

    @PostMapping("/add")
    public ResponseEntity addTodo(@AuthenticationPrincipal Myuser myuser, @RequestBody Todo todo){
        todoservis.addTodo(myuser.getId(), todo);

        return ResponseEntity.status(200).body("todo added");
    }
 @PutMapping ("/updateTODO/{TodoId}")
    public ResponseEntity updateTodo(@AuthenticationPrincipal Myuser myuser,@RequestBody Todo todo, @PathVariable Integer TodoId ){

todoservis.updateTodo(myuser.getId(),todo,TodoId);

return ResponseEntity.status(200).body("TODO UPDATE");
    }

    @DeleteMapping("/deleteTODO/{TodoId}")
    public ResponseEntity daleteTodo(@AuthenticationPrincipal Myuser myuser,@PathVariable Integer TodoId){

        todoservis.deleteTodo(myuser.getId(),TodoId);
        return ResponseEntity.status(200).body("todo is deleted");
    }
}
