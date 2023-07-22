package com.jpa.tutorial.ggi.entities;
import com.jpa.tutorial.ggi.enums.GroupType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "PRODUCTGROUP")
@Getter
@Setter
public class ProductGroup implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME",nullable = false)
    private String name;
    @Column(name = "POLICYNOPREFIX")
    private String policyNoPrefix;
    @Column(name = "PROPOSALNOPREFIX")
    private String proposalNoPrefix;
    @Column(name = "UNDERSESSION13")
    private String underSession13;
    @Column(name = "UNDERSESSION25")
    private String underSession25;
    @Column(name = "MAXSUMINSURED",nullable = false)
    private Double maximumSumInsured;
    @Column(name = "ACCOUNTCODENAME",nullable = false)
    private String accountCodeName;
    @Column(name = "DESCRIPTION")
    private String Description;

    @Enumerated(EnumType.STRING)
    @Column(name = "GROUPTYPE")
    private GroupType groupType;

    @OneToMany(mappedBy = "productGroup",cascade = CascadeType.REMOVE)
    private Set<Product> products;

    @Version
    private Integer version;
}
