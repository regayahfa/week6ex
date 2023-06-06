package com.example.week6d1.Repostry;

import com.example.week6d1.MPDEL.Myuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Myuserrespostry extends JpaRepository<Myuser, Integer> {
Myuser findMyuserByusername(String username);
}
