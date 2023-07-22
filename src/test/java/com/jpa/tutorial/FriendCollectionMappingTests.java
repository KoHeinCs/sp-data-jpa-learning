package com.jpa.tutorial;

import com.jpa.tutorial.CollectionMappingEntities.Friend;
import com.jpa.tutorial.repositories.FriendRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FriendCollectionMappingTests {
    @Autowired
    FriendRepository friendRepository;

    @Test
    void saveFriendWithCollection(){
        Friend friend = new Friend("Mark Anderson","markanderson@gmail.com");

        friend.getNickNames().add("Marky");
        friend.getNickNames().add("Marco");
        friend.getNickNames().add("Markster");

        friendRepository.save(friend);
    }
}
