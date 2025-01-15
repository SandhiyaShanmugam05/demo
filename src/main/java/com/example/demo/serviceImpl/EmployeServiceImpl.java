package com.example.demo.serviceImpl;



import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employe;
import com.example.demo.entity.EmployeDto;
import com.example.demo.repository.EmployeRepository;
import com.example.demo.service.EmployeService;



@Service
public class EmployeServiceImpl implements EmployeService{
    @Autowired
    private EmployeRepository empRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public Employe savEmploye(Employe employe) {
        return empRepository.save(employe);
    }

    // @Override
    // public List<Employe> getAllEmploye() {
    //     return empRepository.findAll();
    // }
    @Override
    public List<EmployeDto> getAllEmploye(){
      
        Aggregation aggregation = Aggregation.newAggregation(
            Aggregation.project("empId", "empName", "empDept")  
        );


        List<EmployeDto> employeeDTOs = mongoTemplate.aggregate(aggregation, Employe.class, EmployeDto.class).getMappedResults();
        
        return employeeDTOs;
    }

    @Override
    public List<Employe> getByName(String name) {
        List<Employe> employes =empRepository.findByEmpName(name);
        if(employes.isEmpty()){
            throw new NoSuchElementException("No such element is present in that name ,"+name);
        }
        return employes;
    }

    public String deleteEmp(String name){
        List<Employe> employes =empRepository.findByEmpName(name);
        if(employes.isEmpty()){
            return "No such employe in that name "+name;
        }
        else{
            empRepository.deleteByEmpName(name);
            return "employe data is deleted By name";
        }
        
    }

    @Override
    public Employe getEmployeByempId(String id) {
        return empRepository.findByEmpId(id);
    }

    @Override
    public List<Employe> getByEmpDEpt(String empName) {
        return empRepository.findByEmpDept(empName);
    }
    @Override
    public Optional<Employe> findByUsername(String email) {
        return empRepository.findByEmpEmail(email);
    }


}
