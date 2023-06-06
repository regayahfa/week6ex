package com.example.exc1.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Prodect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(20)")
    private String name;
//    @Column(columnDefinition = "")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "order_id" )
    @JsonIgnore
    private Order order;
}
