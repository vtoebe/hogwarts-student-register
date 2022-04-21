package com.vtoebe.hogwartsstudentregister.services;

import com.vtoebe.hogwartsstudentregister.entities.StudentEntity;
import com.vtoebe.hogwartsstudentregister.payloads.StudentRequest;
import com.vtoebe.hogwartsstudentregister.payloads.StudentResponse;

public interface StudentService {
    StudentEntity create(StudentRequest studentRequest);

    StudentResponse findStudentById(Long id);
}
