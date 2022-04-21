package com.vtoebe.hogwartsstudentregister.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vtoebe.hogwartsstudentregister.payloads.StudentRequest;
import com.vtoebe.hogwartsstudentregister.enums.AncestryEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity @Data
@Table(name = "student")
@NoArgsConstructor
public class StudentEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "ancestry")
    @Enumerated(EnumType.STRING)
    private AncestryEnum ancestry;
    @Column(name = "wand")
    private String wand;
    @Column(name = "patronus")
    private String patronus;
    @Column(name = "house")
    private UUID houseToken;

    public StudentEntity(StudentRequest request, UUID houseToken){
        this.name = request.getName();
        this.ancestry = request.getAncestry();
        this.wand = request.getWand();
        this.patronus = request.getPatronus();
        this.houseToken = houseToken;
    }
}
