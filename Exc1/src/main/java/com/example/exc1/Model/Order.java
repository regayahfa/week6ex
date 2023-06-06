package com.example.exc1.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "myOrder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;
    private Integer totalPrice;
//    @DateTimeFormat
    private String dateReceived;
    @Column(columnDefinition = " varchar(20) not null check(status='new' or status='inProgress'  or status = 'completed')")
    private String status;


    @ManyToOne
@JoinColumn(name = "orders", referencedColumnName = "id")
    @JsonIgnore
    private myUser myUser;


@OneToMany(mappedBy = "order")
    private Set<Prodect> prodect;

}
