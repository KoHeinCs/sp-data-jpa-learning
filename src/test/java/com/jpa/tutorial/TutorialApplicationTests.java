package com.jpa.tutorial;

import com.jpa.tutorial.ManyToOneEntities.Guide;
import com.jpa.tutorial.repositories.GuideRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TutorialApplicationTests {
    @Autowired
    GuideRepository guideRepository;

    @Test
    void findObjectGraphByGuide1(){
        Guide guide = guideRepository.findById(44L).get();
        guide.setSalary(2000);
        guideRepository.save(guide);

    }

}
