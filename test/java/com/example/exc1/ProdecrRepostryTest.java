package com.example.exc1;

import com.example.exc1.Model.MyUser;
import com.example.exc1.Model.Order;
import com.example.exc1.Model.Prodect;
import com.example.exc1.Repostry.ProductRepostry;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProdecrRepostryTest {

    @Autowired
    ProductRepostry productRepostry;

    Order order;

    Prodect ptodect1,prodect2;
    List<Prodect>prodects;

    @BeforeEach
    void setUp(){
        order=new Order(null,2,10,"213_88","new",null,null);
    ptodect1=new Prodect(null,"reem",12,order);
        prodect2=new Prodect(null,"reem",10,order);

    }
    @Test
    public void findProdectById(){
        productRepostry.save(prodect2);
        Prodect prodect=productRepostry.findProdectById(prodect2.getId());
        Assertions.assertThat(prodects).isEqualTo(prodect2);
    }


}
