package com.jpa.tutorial.CollectionMappingEntities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Friend implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @ElementCollection
    @CollectionTable(name = "friend_nickname",joinColumns = @JoinColumn(name = "friend_id"))
    @Column(name = "nickname")
    private Collection<String> nickNames = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "friend_address",joinColumns = @JoinColumn(name = "friend_id"))
    @AttributeOverrides(
            {
                    @AttributeOverride(name = "zipcode",column = @Column(name = "address_zipcode")),
                    @AttributeOverride(name = "street",column = @Column(name = "address_street")),
                    @AttributeOverride(name = "city",column = @Column(name = "address_city"))
            }
    )
    private Collection<Address> addresses = new ArrayList<>();

    public Friend(){}
    public Friend(String name,String email)
    {
        this.name = name ;
        this.email = email ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<String> getNickNames() {
        return nickNames;
    }

    public void setNickNames(Collection<String> nickNames) {
        this.nickNames = nickNames;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", nickNames=" + nickNames +
                '}';
    }
}
