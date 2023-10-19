package com.example.rh.rhapi.service;

import com.example.rh.rhapi.model.Employe;
import com.example.rh.rhapi.repository.EmployeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Data
@Service
public class EmployeService {
    @Autowired
    private EmployeRepository employeRepos ;
    public Optional <Employe> getEmploye(final Long id){
        return employeRepos.findById(id);

    }
    public Iterable <Employe> getEmployees(){
        return employeRepos.findAll();

    }
    public void  deleteEmploye(final Long id){
        employeRepos.deleteById(id);

    }
    public Employe  saveEmploye(Employe employee){
       Employe savedEmploye = employeRepos.save(employee);
       return savedEmploye;


    }

}
