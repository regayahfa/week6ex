package com.example.exc1.Controller;

import com.example.exc1.Model.Order;
import com.example.exc1.Model.Prodect;
import com.example.exc1.Servis.ProductServis;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class ProductControllar {
private final ProductServis productServis;

    @GetMapping("/get")
    public ResponseEntity getProduct(){
        List<Prodect> prodects = productServis.getProdect();
        return ResponseEntity.status(200).body(prodects);
    }
    @PostMapping("/add")
    public ResponseEntity addprodect(@AuthenticationPrincipal Order order,@RequestBody Prodect prodect){
        productServis.addprodect(order.getId(),prodect);

        return ResponseEntity.status(200).body("prodect added");
    }

    @PutMapping("/updateprodect/{prodectId}")
    public ResponseEntity updateProdect(@AuthenticationPrincipal Prodect prodect, @RequestBody Order order, @PathVariable Integer prodectId  ){

        productServis.updateProdect(prodect.getId(),order,prodectId);

        return ResponseEntity.status(200).body("prodect UPDATE");
    }

    @DeleteMapping("/deleteTODO/{TodoId}")
    public ResponseEntity daleteprodect(@AuthenticationPrincipal Prodect prodect,@PathVariable Integer OrderId){

        productServis.deleteprodect(OrderId, prodect.getId());
        return ResponseEntity.status(200).body("prodect is deleted");
    }
    @GetMapping("/getByProdect")
    public ResponseEntity getProdectById(Integer id){
        productServis.getProdectById(id);
        return ResponseEntity.status(200).body(id);
    }


}
