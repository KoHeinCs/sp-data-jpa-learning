package com.jpa.tutorial.service;

import com.jpa.tutorial.ManyToOneEntities.Guide;
import com.jpa.tutorial.ManyToOneEntities.Student;
import com.jpa.tutorial.dto.StudentDTO;
import com.jpa.tutorial.dto.mapper.StudentMapper;
import com.jpa.tutorial.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;


    @Transactional
    public void findById(Long id){
        Student student = studentRepository.findById(id).get();
        StudentDTO studentDTO = studentMapper.toDTO(student);
        System.out.println(studentDTO.toString());
    }
}
