package com.vtoebe.hogwartsstudentregister.services.impl;

import com.vtoebe.hogwartsstudentregister.clients.SortingHatClient;
import com.vtoebe.hogwartsstudentregister.payloads.StudentRequest;
import com.vtoebe.hogwartsstudentregister.entities.StudentEntity;
import com.vtoebe.hogwartsstudentregister.payloads.StudentResponse;
import com.vtoebe.hogwartsstudentregister.payloads.clients.HouseInfo;
import com.vtoebe.hogwartsstudentregister.repositories.StudentRepository;
import com.vtoebe.hogwartsstudentregister.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    @Autowired
    SortingHatClient sortingHat;
    @Override
    public StudentEntity create(StudentRequest studentRequest) {
        StudentEntity student = new StudentEntity(studentRequest, sortingHat.sort().getHouseToken());
        return repository.save(student);
    }

    @Override
    public StudentResponse findStudentById(Long id) {
        StudentEntity student = repository.findById(id).orElseThrow();
        HouseInfo houseInfo = sortingHat.getHouseInfo(student.getHouseToken());

        StudentResponse studentResponse = new StudentResponse(student);
        studentResponse.setHouse(houseInfo);
        return studentResponse;
    }
}
