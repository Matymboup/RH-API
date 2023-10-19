package com.example.rh.rhapi.controller;

import com.example.rh.rhapi.model.Employe;
import com.example.rh.rhapi.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeController {
    @Autowired
    private EmployeService employee;

    @GetMapping("/employees")
    public Iterable <Employe> getEmployees(){
       return employee.getEmployees();
    }

    @PostMapping("/creer-Employe")
    public Employe saveEmploye( @RequestBody Employe e){

        return  employee.saveEmploye(e);
    }
    @GetMapping("/employe/{id}")
    public Employe getEmploye(@PathVariable("id") final Long id){
        Optional <Employe> employe = employee.getEmploye(id);
        if(employe.isPresent())
             return employe.get();
        else
            return null;
    }
    @PutMapping("/employee-update/{id}")
    public Employe updateEmployee(@PathVariable("id") final long id, @RequestBody Employe emp){
      Optional <Employe> e = employee.getEmploye(id);
      if(e.isPresent()){
          Employe currentEmployee=e.get();
          String firstName= emp.getPrenom();
          if(firstName!=null){
             currentEmployee.setPrenom( firstName);
          }
          String lastName= emp.getNomDeFamille();
          if(lastName!=null){
              currentEmployee.setNomDeFamille( lastName);
          }
          String mail= emp.getMail();
          if(mail!=null){
              currentEmployee.setMail( mail);
          }
          String password= emp.getPassword();
          if(password!=null){
              currentEmployee.setPassword( password);
          }
          employee.saveEmploye(currentEmployee);
          return currentEmployee;
      }
      else {
          return null;
      }

    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable("id") final Long id){
        employee.deleteEmploye(id);
    }




}
