package com.example.week6d1.Controller;

import com.example.week6d1.MPDEL.Myuser;
import com.example.week6d1.servis.MyuserDitilsServis;
import com.example.week6d1.servis.Myuserservis;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class Myusercontroller {

    private final Myuserservis myuserservis;


@GetMapping("/get")
    public ResponseEntity getAllUser() {
        List<Myuser> myuserList = myuserservis.getAllUser();
        return ResponseEntity.status(200).body(myuserList);

    }

@PostMapping("/reggister")
    public ResponseEntity reggister(@RequestBody Myuser myuser){
    myuserservis.reggister(myuser);
    return ResponseEntity.status(200).body("user reggister");
}

@PostMapping("/admin")
    public ResponseEntity admin(){
        return ResponseEntity.status(200).body("welcome admin");
    }

    @PostMapping("/user")
    public ResponseEntity user(){
        return ResponseEntity.status(200).body("welcome user");
    }
    @PostMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.status(200).body("login");
    }
    @PostMapping("/logout")
    public ResponseEntity logout(){
        return ResponseEntity.status(200).body("logout");
    }

}