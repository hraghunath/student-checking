package com.raghunathit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghunathit.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

}
