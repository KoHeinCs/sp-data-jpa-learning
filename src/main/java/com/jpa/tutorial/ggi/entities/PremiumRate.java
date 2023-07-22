package com.jpa.tutorial.ggi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PREMIUMRATE")
@Getter
@Setter
public class PremiumRate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "AGE",nullable = false)
    private Integer age;
    @Column(name = "TERM",nullable = false)
    private Integer term;
    @Column(name = "PREMIUMRATE",nullable = false)
    private Double premiumRate;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

}
