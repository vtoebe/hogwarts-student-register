package com.vtoebe.hogwartsstudentregister.repositories;

import com.vtoebe.hogwartsstudentregister.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
