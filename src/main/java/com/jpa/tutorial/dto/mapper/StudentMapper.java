package com.jpa.tutorial.dto.mapper;

import com.jpa.tutorial.ManyToOneEntities.Student;
import com.jpa.tutorial.dto.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper extends BaseMapper<StudentDTO, Student>{
    @Override
    @Mapping(source = "dto.studentName",target = "name")
    Student toEntity(StudentDTO dto);

    @Override
    @Mapping(source = "entity.name",target = "studentName")
    StudentDTO toDTO(Student entity);

    @Override
    List<Student> toEntityList(List<StudentDTO> dtoList);

    @Override
    List<StudentDTO> toDTOList(List<Student> entityList);
}
