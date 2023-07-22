package com.jpa.tutorial;

import com.jpa.tutorial.ManyToOneEntities.Guide;
import com.jpa.tutorial.ManyToOneEntities.Student;
import com.jpa.tutorial.repositories.GuideRepository;
import com.jpa.tutorial.repositories.StudentRepository;
import com.jpa.tutorial.selfjoin.Department;
import com.jpa.tutorial.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StudentGuideEntityTest {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private GuideRepository guideRepository;
    @Autowired
    StudentService studentService;

   // @Test
    void findStudent(){
        studentService.findById(3L);
    }

  //@Test
    void createStudentObjectGraph(){

        Guide guide = new Guide("staff_2","KoHeinCs",300);
        Student student1 = new Student("roll_10","Junior",guide);
        studentRepository.saveAll(Arrays.asList(student1));
    }

    @Test
    void saveNewDeptWithExistingParent(){
        Guide guide = guideRepository.findById(7L).get();
        Student student1 = new Student("roll_20","Junior",guide);
        guide.addStudent(student1);
        guideRepository.save(guide);

    }

    //@Test
    void createGuideObjectGraph1(){
        Guide guide = new Guide("staff_2","KoHeinCs",300);
        Student student1 = new Student("roll_10","Junior",guide);
        Student student2 = new Student("roll_11","Junior",guide);
        guide.addStudent(student1);
        guide.addStudent(student2);

        guideRepository.save(guide);

    }

    //@Test
    void createGuideObjectGraph2(){
        List<Student> students = studentRepository.findAllStudents2();
        for (Student student:students){
            Guide guide = student.getGuide();
            System.out.println(guide);
        }
    }

   // @Test
    void deleteObjectGraph(){
        studentRepository.deleteById(11L);
    }

    //@Test
    void findObjectGraph(){
        Student student = studentRepository.findById(14L).orElse(null);
        Guide guide = student.getGuide();
        System.out.println(guide.getName());
    }

   //@Test
    void findObjectGraphByGuide1(){
//        Guide guide1 = guideRepository.findById(44L).get();
//       System.out.println(guide1);
       assertThat(guideRepository).isNotNull();

    }


}
