package org.icet.repository;

import org.icet.dto.Student;
import org.icet.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity,String> {
}
