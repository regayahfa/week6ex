package com.example.exc1.Servis;

import com.example.exc1.ApiExcepion.ApiExption;
import com.example.exc1.Model.Order;
import com.example.exc1.Model.Prodect;
import com.example.exc1.Repostry.ProductRepostry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServis {
    private final ProductRepostry productRepostry;
    public List<Prodect> getProdect() {
        return productRepostry.findAll();
    }
    public void addprodect(Prodect prodect) {
        prodect.setId(prodect.getId());
    }

    public void updateProdect(Integer ProdectId, Order order, Integer orderId) {
        Prodect prodect=productRepostry.findProdectById(orderId);
        if (prodect==null){
            throw new ApiExption("user not fuond");
        }
        if (prodect.getId()!=ProdectId){
            throw new ApiExption("error, ");
        }
        prodect.setId(prodect.getId());
        productRepostry.save(prodect);
    }

    public void deleteprodect( Integer orderId) {
       Prodect prodect=productRepostry.findProdectById(orderId);
        if (prodect==null){
            throw new ApiExption("prodect not fuond");
        }
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
