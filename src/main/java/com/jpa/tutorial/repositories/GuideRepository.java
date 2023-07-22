package com.jpa.tutorial.repositories;

import com.jpa.tutorial.ManyToOneEntities.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideRepository extends JpaRepository<Guide,Long> {
}
