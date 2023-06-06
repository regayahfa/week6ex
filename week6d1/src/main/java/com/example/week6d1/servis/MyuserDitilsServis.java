package com.example.week6d1.servis;

import com.example.week6d1.MPDEL.Myuser;
import com.example.week6d1.Repostry.Myuserrespostry;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyuserDitilsServis implements UserDetailsService {

private final Myuserrespostry myuserrespostry;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Myuser myuser=myuserrespostry.findMyuserByusername(username);


        if(myuser==null){
            throw new UsernameNotFoundException("Wrong username or password");
        }

        return myuser;
    }

}
