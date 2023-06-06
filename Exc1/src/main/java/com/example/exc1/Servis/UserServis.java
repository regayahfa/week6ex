package com.example.exc1.Servis;

import com.example.exc1.ApiExcepion.ApiExption;
import com.example.exc1.Model.Order;
import com.example.exc1.Model.myUser;
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
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public void reggister(myUser myUser) {
        userRepostry.save(myUser);
    }




    public void adduser(myUser myUser) {
        myUser.setId(myUser.getId());
    }

    public void updateuser(Integer userId, Order order, Integer orderId) {
        myUser myUser =userRepostry.findmyUserById(orderId);
        if (myUser ==null){
            throw new ApiExption("user not fuond");
        }
        if (myUser.getId()!=userId){
            throw new ApiExption("error, ");
        }
        myUser.setOrders(myUser.getOrders());
        userRepostry.save(myUser);
    }
    public void deleteuser(Integer userId, Integer orderId) {
        myUser olduser =userRepostry.findmyUserById(userId);
        if (olduser ==null){
            throw new ApiExption("todo not fuond");
        }
        if (olduser.getId()!=userId){
            throw new ApiExption("error, ");
        }
        userRepostry.save(olduser);
    }
    public myUser getUsersById(Integer id){
        myUser myUser =userRepostry.findmyUserById(id);
        if (myUser ==null){
            throw new ApiExption(" not fuond");
        }
        return myUser;
    }
public myUser getAllByOrder(){
        myUser myUser =userRepostry.findAllByOrder();
        if (myUser ==null){
            throw new ApiExption("USER not fuond");
        }
        return myUser;
}
}
