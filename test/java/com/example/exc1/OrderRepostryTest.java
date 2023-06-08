package com.example.exc1;

import com.example.exc1.Model.MyUser;
import com.example.exc1.Model.Order;
import com.example.exc1.Repostry.OrderRepostry;
import com.example.exc1.Repostry.UserRepostry;
import org.apache.catalina.Group;
import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Iterator;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderRepostryTest {

@Autowired
    OrderRepostry orderRepostry;

MyUser myuser;

Order order1,order2,order3;
List<Order>orderList;


@BeforeEach
   void SetUp(){
    myuser =new MyUser(null,"sara1","12321","Admin",null);
    order1=new Order(null,1,10,"12/111","new",myuser,null);

}
@Test
    public void findOrderById(){
    orderRepostry.save(order1);

    Order order=orderRepostry.findOrderById(myuser.getId());

    Assertions.assertThat(order.getMyUser().getId()).isEqualTo(myuser.getId());
}

@Test
    public void findmyUserById(){

orderRepostry.save(order1);
orderRepostry.save(order2);
orderRepostry.save(order3);

List<Order>orderList1=orderRepostry.findAll();
Assertions.assertThat(orderList1.get(0).getMyUser().getId()).isEqualTo(myuser.getId());

}
@Test
    public void getOrderTest(){
    orderRepostry.findAll();
    List<Order>orders=orderRepostry.findAll();
    Assertions.assertThat(orders).isEqualTo(order2);

}
@Test
    public  void getOrderByStatusTest(){
    orderRepostry.findOrderByStatus();
    List<Order>orders=orderRepostry.findAll();
    Assertions.assertThat(orders).isEqualTo(order1);
}
}
