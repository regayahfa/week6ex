package com.example.week6d1.servis;

import com.example.week6d1.MPDEL.Myuser;
import com.example.week6d1.Repostry.Myuserrespostry;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class Myuserservis  {
    private final Myuserrespostry myuserrespostry;
    public List<Myuser> getAllUser(){
        return myuserrespostry.findAll();

    }
    public void  reggister(Myuser myuser){

        myuserrespostry.save(myuser);
    }


}
