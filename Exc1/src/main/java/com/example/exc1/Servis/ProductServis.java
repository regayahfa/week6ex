package com.example.exc1.Servis;

import com.example.exc1.ApiExcepion.ApiExption;
import com.example.exc1.Model.Order;
import com.example.exc1.Model.Prodect;
import com.example.exc1.Repostry.OrderRepostry;
import com.example.exc1.Repostry.ProductRepostry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServis {
    private final ProductRepostry productRepostry;
    private final OrderRepostry orderRepostry;

    public List<Prodect> getProdect() {
//        Order order=orderRepostry.findOrderById(orderId);
        return productRepostry.findAll();
    }
    public void addprodect(Integer orderId,Prodect prodect) {
        Order order=orderRepostry.findOrderById(orderId);
        prodect.setId(prodect.getId());
    }

    public void updateProdect(Integer ProdectId, Order order, Integer Order) {
        Prodect prodect=productRepostry.findProdectById(ProdectId);
        Order order1=orderRepostry.findOrderById(Order);
        if (prodect==null){
            throw new ApiExption("user not fuond");
        }
        else if (prodect.getOrder().getId()!=Order){
            throw new ApiExption("error, ");
        }
        prodect.setId(prodect.getId());
        prodect.setOrder(order);
        productRepostry.save(prodect);
    }

    public void deleteprodect( Integer orderId, Integer prodectId) {
       Prodect prodect=productRepostry.findProdectById(orderId);

        if (prodect.getId()!=orderId){
            throw new ApiExption("error, ");
        }
        productRepostry.save(prodect);
    }
public Prodect getProdectById(Integer id){
        Prodect prodect=productRepostry.findProdectById(id);
        if(prodect==null){
            throw new ApiExption("not found");
        }
        return prodect;
}

}
