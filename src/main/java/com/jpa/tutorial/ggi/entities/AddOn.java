package com.jpa.tutorial.ggi.entities;

import com.jpa.tutorial.ggi.enums.AddOnType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ADDON")
@Getter
@Setter
public class AddOn implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME",nullable = false)
    private String name;
    @Column(name = "VALUE",nullable = false)
    private Double value;
    @Column(name = "DESCRIPTION")
    @Lob
    private String description;

    @Column(name = "ADDONTYPE")
    @Enumerated(EnumType.STRING)
    private AddOnType addOnType;

    @Column(name = "MINAMOUNT")
    private Double minimumAmount;
    @Column(name = "MAXAMOUNT")
    private Double maximumAmount;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Version
    private Integer version;
}
