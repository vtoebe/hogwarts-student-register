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
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    @Autowired
    SortingHatClient sortingHat;
    @Override @CacheEvict(cacheNames = "student", allEntries = true)
    public StudentEntity create(StudentRequest studentRequest) {
        StudentEntity student = new StudentEntity(studentRequest, sortingHat.sort().getHouseToken());
        return repository.save(student);
    }

    @Override @Cacheable(cacheNames = "student", key = "#id")
    public StudentResponse findStudentById(Long id) {
        StudentEntity student = repository.findById(id).orElseThrow();
        HouseInfo houseInfo = sortingHat.getHouseInfo(student.getHouseToken());

        StudentResponse studentResponse = new StudentResponse(student);
        studentResponse.setHouse(houseInfo);
        return studentResponse;
    }

    @Override @Cacheable(cacheNames = "houseInfo", key = "#houseToken")
    public HouseInfo findHouse(UUID houseToken) {
        return sortingHat.getHouseInfo(houseToken);
    }
}
