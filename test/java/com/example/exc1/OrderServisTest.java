package com.example.exc1;

import com.example.exc1.Model.MyUser;
import com.example.exc1.Model.Order;
import com.example.exc1.Model.Prodect;
import com.example.exc1.Repostry.OrderRepostry;
import com.example.exc1.Repostry.ProductRepostry;
import com.example.exc1.Repostry.UserRepostry;
import com.example.exc1.Servis.OrderServis;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class OrderServisTest {
    @InjectMocks
    OrderServis orderServis;
    @Mock
    OrderRepostry orderRepostry;

    @Mock
    UserRepostry userRepostry;

    MyUser myuser;

    Order order1, order2;
    List<Order> orderList;


    @BeforeEach
    void SetUp() {
        myuser = new MyUser(null, "sara1", "12321", "Admin", null);
        order1 = new Order(null, 1, 10, "12/111", "new", null, null);
        order2 = new Order(null, 2, 20, "12/121", "completed", null, null);

        orderList=new ArrayList<>();
        orderList.add(order2);
        orderList.add(order1);
    }
@Test
    public void addOrder(){
        when(userRepostry.findmyUserById(myuser.getId())).thenReturn(myuser);
        orderServis.addOrder(myuser.getId(),order2);
        verify(userRepostry,times(1)).findmyUserById(myuser.getId());
        verify(orderRepostry,times(1)).save(order1);
    }
}