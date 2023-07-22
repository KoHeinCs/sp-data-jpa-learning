package com.jpa.tutorial.ggi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PAYMENTTYPE")
@Getter
@Setter
public class PaymentType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME",nullable = false)
    private String name;
    @Column(name = "MONTH")
    private Integer month;
    @Column(name = "DESCRIPTION")
    @Lob
    private String description;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


    @Version
    private Integer version;
}
