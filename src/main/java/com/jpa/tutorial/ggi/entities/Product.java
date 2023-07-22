package com.jpa.tutorial.ggi.entities;

import com.jpa.tutorial.ggi.enums.CurrencyType;
import com.jpa.tutorial.ggi.enums.InsuranceType;
import com.jpa.tutorial.ggi.enums.PremiumRateType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME",nullable = false)
    private String name;
    @Column(name = "STANDARDEXCESS")
    private Double standardExcess;
    @Column(name = "FIRST_COMMISSION")
    private Double firstCommission;
    @Column(name = "RENEWALCOMMISSION")
    private Double renewalCommission;

    @Enumerated(EnumType.STRING)
    @Column(name = "INSURANCETYPE",nullable = false)
    private InsuranceType insuranceType;

    @Column(name = "MINSUMINSURED")
    private Double minSumInsured;
    @Column(name = "MAXSUMINSURED")
    private Double maxSumInsured;
    @Column(name = "MINTERMMONTH")
    private Integer minTermMonth;
    @Column(name = "MAXTERMMONTH")
    private Integer maxTermMonth;

    @Enumerated(EnumType.STRING)
    @Column(name = "CURRENCYTYPE",nullable = false)
    private CurrencyType currencyType;
    @Column(name = "PREFIX")
    private String prefix;
    @Column(name = "MINAGE")
    private Integer minAge;
    @Column(name = "MAXAGE")
    private Integer maxAge;
    @Column(name = "MINTERMWEEK")
    private Integer minTermWeek;
    @Column(name = "MAXTERMWEEK")
    private Integer maxTermWeek;
    @Column(name = "AUTO_CALCULATE")
    private Boolean autoCalculate;
    @Column(name = "FIXED_VALUE")
    private Double fixedValue;

    @Enumerated(EnumType.STRING)
    @Column(name = "PREMIUMRATETYPE")
    private PremiumRateType premiumRateType;
    @Column(name = "SUMINSURED")
    private Double sumInsured;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "product_group_id",nullable = false)
    private ProductGroup productGroup;

    @OneToMany(mappedBy = "product",cascade = {CascadeType.PERSIST})
    private Set<PaymentType> paymentTypes;

    @OneToMany(mappedBy = "product",cascade = {CascadeType.PERSIST})
    private Set<AddOn> addOns;

    @OneToMany(mappedBy = "product",cascade = {CascadeType.PERSIST})
    private Set<KeyFactor> keyFactors;

    @OneToMany(mappedBy = "product",cascade = {CascadeType.REMOVE})
    private Set<PremiumRate> premiumRates;

    private void addPaymentType(PaymentType paymentType){
        paymentTypes.add(paymentType);
        paymentType.setProduct(this);
    }

    private void addAddOn(AddOn addOn){
        addOns.add(addOn);
        addOn.setProduct(this);
    }

    private void addKeyFactor(KeyFactor keyFactor){
        keyFactors.add(keyFactor);
        keyFactor.setProduct(this);
    }

    @Version
    private Integer version;


}
