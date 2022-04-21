package com.vtoebe.hogwartsstudentregister.payloads;

import com.vtoebe.hogwartsstudentregister.entities.StudentEntity;
import com.vtoebe.hogwartsstudentregister.payloads.clients.HouseInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
public class StudentResponse extends StudentRequest{
    private Long id;
    private HouseInfo house;

    public StudentResponse(StudentEntity student){
        this.setId(student.getId());
        this.setName(student.getName());
        this.setAncestry(student.getAncestry());
        this.setWand(student.getWand());
        this.setPatronus(student.getPatronus());
    }
}
