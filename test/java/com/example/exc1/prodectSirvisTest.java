package com.example.exc1;

import com.example.exc1.Model.Order;
import com.example.exc1.Model.Prodect;
import com.example.exc1.Repostry.OrderRepostry;
import com.example.exc1.Repostry.ProductRepostry;
import com.example.exc1.Servis.OrderServis;
import com.example.exc1.Servis.ProductServis;
import org.junit.jupiter.api.Assertions;
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
public class prodectSirvisTest {

@InjectMocks
    ProductServis productServis;
@Mock
  ProductRepostry productRepostry;
@Mock
    OrderRepostry orderRepostry;

    Order order;

    Prodect ptodect1,prodect2;
    List<Prodect> prodects;

    @BeforeEach
    void setUp() {
        order = new Order(null, 2, 10, "213_88", "new", null, null);
        ptodect1 = new Prodect(null, "reem", 12, order);
        prodect2 = new Prodect(null, "reem", 10, order);

   prodects=new ArrayList<>();
   prodects.add(ptodect1);
   prodects.add(prodect2);

    }

    @Test
    public void addprodect(){
        when(orderRepostry.findOrderById(order.getId())).thenReturn(order);
        productServis.addprodect(order.getId(),prodect2);
        verify(orderRepostry,times(1)).findOrderById(order.getId());
        verify(productRepostry,times(1)).save(prodect2);
    }

    @Test
    public void updateProdect(){
    when(orderRepostry.findOrderById(order.getId())).thenReturn(order);
    when(productRepostry.findAll().thenReturn(prodects));
    productServis.updateProdect(prodect2.getId(),order,order.getId());
        verify(orderRepostry,times(1)).findOrderById(order.getId());
        verify(productRepostry, times(1)).findProdectById(prodect2.getId());
    }

    @Test
    public void deleteprodect(){
    when(orderRepostry.findOrderById(order.getId())).thenReturn(order);

    when(productRepostry.findProdectById(prodect2.getId())).thenReturn(prodect2);

    productServis.deleteprodect(prodect2.getId(),order.getId());

    verify(orderRepostry,times(1)).delete(order);
    verify(productRepostry,times(1)).delete(prodect2);

}
    @Test
    public void getProdectById(){
    when(orderRepostry.findOrderById(order.getId()).getId()).thenReturn(order);
    when(productRepostry.findProdectById(prodects)).thenReturn(prodect2);
    List<Prodect>prodectList=productServis.getProdect(order.getId());
       Assertions.assertEquals(prodectList.get(0).getOrder().getId(),order.getId());
        verify(orderRepostry,times(1)).findAll();
        verify(productRepostry,times(1)).findProdectById(prodect2.getId());

    }

}
