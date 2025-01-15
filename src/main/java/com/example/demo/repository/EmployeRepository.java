package com.example.demo.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.entity.Employe;


@Repository
public interface EmployeRepository extends MongoRepository<Employe,String> {
    public List<Employe>  findByEmpName(String empName);
    public void deleteByEmpName(String name);
    public Employe findByEmpId(String empId);
    public List<Employe> findByEmpDept(String empDept);
    Optional<Employe> findByEmpEmail(String email);
}
