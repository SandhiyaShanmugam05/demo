package com.example.demo.controller;




import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employe;
import com.example.demo.entity.EmployeDto;

import com.example.demo.serviceImpl.EmployeServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class EmployeController {
   @Autowired
   private EmployeServiceImpl employeService;

    @GetMapping("/helo")
     public String getName(){
        return "Hellow world";
     }

     @PostMapping("/save")
     public Employe saveEmploye(@RequestBody Employe employe) {
      return employeService.savEmploye(employe);
     }
     
   //   @GetMapping("/getAllEmployee")
   //   public List<Employe> getAllEmploye(){
   //      return employeService.getAllEmploye();
   //   }

   @GetMapping("/getAllEmployee")
     public List<EmployeDto> getAllEmploye(){
        return employeService.getAllEmploye();
     }

     @GetMapping("/getByName/{empName}")
     public List<Employe> getByName(@PathVariable("empName") String name){
        return employeService.getByName(name);
     }

     @DeleteMapping("/delete/{empName}")
     public String deleteEmpDetails(@PathVariable("empName") String name){
      return employeService.deleteEmp(name);
     }

     @GetMapping("get-EmpId/{empId}")
     public Employe getMethodName(@PathVariable("empId") String id) {
         return employeService.getEmployeByempId(id);
     }

     @GetMapping("get-By-EmpDept/{empDept}")
     public List<Employe> getByEmpDept(@PathVariable("empDept") String empName) {
         return employeService.getByEmpDEpt(empName);
     }

      @GetMapping("get-EmpId")
      public ResponseEntity<?> getEmp(@RequestParam(value = "empId", required = false) String id) {

         if(id != null){
            return ResponseEntity.ok(employeService.getEmployeByempId(id));
      }
      else{
         return ResponseEntity.ok(employeService.getAllEmploye());
      }
      }
}


