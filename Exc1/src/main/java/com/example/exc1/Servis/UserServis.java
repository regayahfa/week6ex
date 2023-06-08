package com.example.exc1.Servis;

import com.example.exc1.ApiExcepion.ApiExption;
import com.example.exc1.Model.Order;
import com.example.exc1.Model.MyUser;
import com.example.exc1.Repostry.OrderRepostry;
import com.example.exc1.Repostry.UserRepostry;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServis implements UserDetailsService {
    private final UserRepostry userRepostry;
    private final OrderRepostry orderRepostry;
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return null;
    }

    public void reggister(MyUser myUser) {
        userRepostry.save(myUser);
    }




    public void adduser(Integer orderId, MyUser myUser) {
        Order order=orderRepostry.findOrderById(orderId);
        myUser.setId(myUser.getId());
        userRepostry.save(myUser);
    }

    public void updateuser(Integer userId, Order neworder, Integer orderId) {
        MyUser myUser =userRepostry.findmyUserById(orderId);
        Order order1=orderRepostry.findOrderById(orderId);
        if (myUser ==null){
            throw new ApiExption("user not fuond");
        }
       else if (myUser.getId()!=orderId){
            throw new ApiExption("error, ");
        }
        myUser.setOrders(myUser.getOrders());
        myUser.setId(userId);
        userRepostry.save(myUser);
    }
    public void deleteuser(Integer userId, Integer orderId) {
        MyUser olduser =userRepostry.findmyUserById(userId);
        if (olduser.getId()!=userId){
            throw new ApiExption("error, ");
        }
        userRepostry.delete(olduser);
    }
    public MyUser getUsersById(Integer id){
        MyUser myUser =userRepostry.findmyUserById(id);
        if (myUser ==null){
            throw new ApiExption(" not fuond");
        }
        return myUser;
    }
public MyUser getAllByOrder(){
        MyUser myUser =userRepostry.findAllByOrder();
        if (myUser ==null){
            throw new ApiExption("USER not fuond");
        }
        return myUser;
}
}
