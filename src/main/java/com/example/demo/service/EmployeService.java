package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employe;
import com.example.demo.entity.EmployeDto;


@Service
public interface EmployeService {
 public Employe savEmploye(Employe employe);
    // public List<Employe> getAllEmploye();
    public List<EmployeDto> getAllEmploye();

    public List<Employe> getByName(String name);
    public String deleteEmp(String name);
    public Employe getEmployeByempId(String id);
    public List<Employe> getByEmpDEpt(String empName);
    public Optional<Employe> findByUsername(String email);
}
