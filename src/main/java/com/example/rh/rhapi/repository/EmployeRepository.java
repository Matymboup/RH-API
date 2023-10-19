package com.example.rh.rhapi.repository;

import com.example.rh.rhapi.model.Employe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends CrudRepository<Employe, Long> {
}
