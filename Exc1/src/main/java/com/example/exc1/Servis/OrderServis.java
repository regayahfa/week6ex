package com.example.exc1.Servis;

import com.example.exc1.ApiExcepion.ApiExption;
import com.example.exc1.Model.Order;
import com.example.exc1.Model.Prodect;
import com.example.exc1.Model.MyUser;
import com.example.exc1.Repostry.OrderRepostry;
import com.example.exc1.Repostry.ProductRepostry;
import com.example.exc1.Repostry.UserRepostry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServis {
    private final OrderRepostry orderRepostry;
    private final UserRepostry userRepostry;
    private final ProductRepostry productRepostry;


    public List<Order> getOrder() {
        return orderRepostry.findAll();
    }
    public void addOrder(Order order,  Integer prodectId , Integer userId) {
        MyUser myUser =userRepostry.findmyUserById(userId);
        Prodect prodect1=productRepostry.findProdectById(prodectId);
        if (myUser ==null||prodect1==null)
            throw new ApiExption("not fuond");
        order.setTotalPrice(prodect1.getPrice()*order.getQuantity());
        order.setStatus("new");
        order.setMyUser(myUser);

        orderRepostry.save(order);
    }
    public void updateOrder( Integer userId, Order order, Integer orderId) {
        Order order1=orderRepostry.findOrderById(orderId);
        MyUser myUser =userRepostry.findmyUserById(userId);
        if (order1==null|| myUser ==null){
            throw new ApiExption("order not fuond");
        }
        if (order1.getId()!=orderId){
            throw new ApiExption("error ");
        }
        order1.setId(order.getId());
        order1.setTotalPrice(order.getTotalPrice());
        order1.setDateReceived(order.getDateReceived());
        orderRepostry.save(order1);
    }
    public void deleteOrder( Integer userId, Integer OrderId  ) {
        MyUser myUser =userRepostry.findmyUserById(userId);
        Order oldorder=orderRepostry.findOrderById(OrderId);
        if (oldorder==null || oldorder.getStatus().equals("inProgress")|| oldorder.getStatus().equals("completed")){
            throw new ApiExption("can not deleded");
        }
        if (myUser.getId()!=userId){
            throw new ApiExption("error, ");
        }
        orderRepostry.save(oldorder);

    }

    public Order getOrderById(Integer id){
        Order order=orderRepostry.findOrderById(id);
        if (order==null){
            throw new ApiExption("not found");
        }
        return order;
    }

    public Order getOrderByStatus(){
        Order order=orderRepostry.findOrderByStatus();
        if (order==null){
            throw new ApiExption("not found");
        }
        return order;
    }
}
