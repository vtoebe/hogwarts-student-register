package com.vtoebe.hogwartsstudentregister.controllers;

import com.vtoebe.hogwartsstudentregister.entities.StudentEntity;
import com.vtoebe.hogwartsstudentregister.payloads.StudentRequest;
import com.vtoebe.hogwartsstudentregister.payloads.StudentResponse;
import com.vtoebe.hogwartsstudentregister.payloads.clients.HouseInfo;
import com.vtoebe.hogwartsstudentregister.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hogwarts")
public class StudentController {

    private final StudentService service;

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public StudentEntity register(@RequestBody StudentRequest studentRequest){
        return service.create(studentRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public StudentResponse findStudentById(@PathVariable("id") Long id){
        return service.findStudentById(id);
    }

    @GetMapping("/house/{houseToken}")
    @ResponseStatus(code = HttpStatus.OK)
    public HouseInfo findHouse(@PathVariable("houseToken") UUID houseToken){
        return service.findHouse(houseToken);
    }
}
