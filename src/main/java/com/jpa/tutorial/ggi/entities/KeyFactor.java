package com.jpa.tutorial.ggi.entities;

import com.jpa.tutorial.ggi.enums.KeyFactorType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "KEYFACTOR")
@Getter
@Setter
public class KeyFactor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "KEYFACTORTYPE",nullable = false)
    private KeyFactorType keyFactorType;

    @Column(name = "KEYFACTORVALUE",nullable = false)
    private String keyFactorValue;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
