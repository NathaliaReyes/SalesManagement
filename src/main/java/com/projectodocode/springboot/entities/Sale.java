package com.projectodocode.springboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private double amount;
    @Column
    private String date;

    @ManyToOne
    @JoinColumn(name="id_customer")
    private Customer customer;

    @OneToMany(mappedBy="sale")
    @JsonIgnore
    private List<SaleDetail> saleDetailList = new ArrayList<>();
}
