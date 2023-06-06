package com.example.exc1.Controller;

import com.example.exc1.Model.Order;
import com.example.exc1.Model.myUser;
import com.example.exc1.Servis.OrderServis;
import com.example.exc1.Servis.UserServis;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserControllar {
    private final UserServis userServis;
private final OrderServis orderServis;
    @PostMapping("/reggister")
    public ResponseEntity reggister(@RequestBody myUser myUser){
        userServis.reggister(myUser);
        return ResponseEntity.status(200).body("user reggister");
    }

    @PostMapping("/admin")
    public ResponseEntity admin(){
        return ResponseEntity.status(200).body("welcome admin");
    }

    @PostMapping("/user")
    public ResponseEntity user(){
        return ResponseEntity.status(200).body("welcome user");
    }
    @PostMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.status(200).body("login");
    }
    @PostMapping("/logout")
    public ResponseEntity logout(){
        return ResponseEntity.status(200).body("logout");
    }

    @PostMapping("/add")
    public ResponseEntity adduser(@AuthenticationPrincipal myUser myUser){
        userServis.adduser(myUser);

        return ResponseEntity.status(200).body("user added");
    }

    @PutMapping("/updateUser/{OrderId}")
    public ResponseEntity updateuser(@AuthenticationPrincipal myUser myUser, @RequestBody Order order, @PathVariable Integer OrderId ){

        userServis.updateuser(myUser.getId(),order,OrderId);

        return ResponseEntity.status(200).body("user UPDATE");
    }

    @DeleteMapping("/deleteuser/{userId}")
    public ResponseEntity daleteuser(@AuthenticationPrincipal myUser myUser, @PathVariable Integer userId){

        userServis.deleteuser(myUser.getId(),userId);
        return ResponseEntity.status(200).body("user is deleted");
    }
    @GetMapping("/getByuser")
    public ResponseEntity getUsersById(Integer id){
        userServis.getUsersById(id);
        return ResponseEntity.status(200).body(id);
    }
@GetMapping("/getByOrder")
    public ResponseEntity getAllByOrder(){
        userServis.getAllByOrder();
//        orderServis.getOrderById();
    return ResponseEntity.status(200).body("order list");
}

}
