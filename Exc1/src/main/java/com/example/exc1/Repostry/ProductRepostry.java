package com.example.exc1.Repostry;

import com.example.exc1.Model.Prodect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepostry extends JpaRepository<Prodect, Integer> {
Prodect findProdectById(Integer id);

}
