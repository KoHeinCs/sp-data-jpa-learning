package com.jpa.tutorial.repositories;

import com.jpa.tutorial.CollectionMappingEntities.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends JpaRepository<Friend,Long> {
}
