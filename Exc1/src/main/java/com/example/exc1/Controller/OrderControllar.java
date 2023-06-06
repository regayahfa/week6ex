package com.example.exc1.Controller;

import com.example.exc1.Model.Order;
import com.example.exc1.Model.myUser;
import com.example.exc1.Servis.OrderServis;
import com.example.exc1.Servis.UserServis;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RequestMapping("/Api/v1/order")
@RestController
@RequiredArgsConstructor
public class OrderControllar {
    private final OrderServis orderServis;
    private final UserServis userServis;

    @GetMapping("/get")
    public ResponseEntity getOrder(){
        List<Order> orderList = orderServis.getOrder();
        return ResponseEntity.status(200).body(orderList);
    }

    @PostMapping("/add")
    public ResponseEntity addOrder(@AuthenticationPrincipal Order order,Integer prodectId, @PathVariable Integer userId){
        orderServis.addOrder(order,prodectId,userId);
        return ResponseEntity.status(200).body("order added");
    }

    @PutMapping("/updateorder/{orderId}")
    public ResponseEntity updateOrder(@AuthenticationPrincipal myUser myUser, @RequestBody Order order, @PathVariable Integer orderId ){
userServis.updateuser(myUser.getId(),order,orderId);
        return ResponseEntity.status(200).body("order UPDATE");
    }

    @DeleteMapping("/deleteOrder/{userId}")
    public ResponseEntity daleteOrder(@PathVariable Integer OrderId, @PathVariable Integer userId){

        orderServis.deleteOrder(OrderId,userId);
        return ResponseEntity.status(200).body("order is deleted");
    }
@GetMapping("/getById")
public ResponseEntity getOrderById(Integer id){
        orderServis.getOrderById(id);
        return ResponseEntity.status(200).body(id);
}

}
