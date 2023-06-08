package com.example.exc1.Repostry;

import com.example.exc1.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepostry extends JpaRepository<Order, Integer> {
    Order findOrderById(Integer Id);
    Order findOrderByStatus();


}

