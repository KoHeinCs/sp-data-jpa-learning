package com.jpa.tutorial.dto;

import com.jpa.tutorial.ManyToOneEntities.Guide;
import lombok.Data;

import java.util.Date;

@Data
public class StudentDTO {

    private Long id;

    private String enrollmentId;

    private String studentName;

    private GuideDTO guideDTO;



}
