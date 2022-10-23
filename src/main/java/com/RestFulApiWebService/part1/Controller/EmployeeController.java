package com.RestFulApiWebService.part1.Controller;

import com.RestFulApiWebService.part1.Exception.CustomExceptionHandlerClass;
import com.RestFulApiWebService.part1.Exception.EmployeeNotFoundException;
import com.RestFulApiWebService.part1.Service.EmployeeService;
import com.RestFulApiWebService.part1.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
@Component
   @RestController
    public class EmployeeController {
    @Autowired
    EmployeeService service;

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String welcomeMessage() {
        return "Welcome  spring boot";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/get")
    public List<Employee> getEmployeeList(){
        return service.getempList();
    }

    @RequestMapping(method = RequestMethod.GET,path = "get/{id}")
    public Employee getParticularEmployee(@PathVariable int id)  {
        Employee emp = service.getPartcularEmp(id);
      if (emp == null)
         throw new EmployeeNotFoundException("Employee not found for id: " + id);
        return emp;
    }
    @RequestMapping(method = RequestMethod.DELETE,path = "delete/{id}")
    public void deleteParticularEmployee(@PathVariable int id){
        service.deleteParticularEmp(id);
    }


    @RequestMapping(method = RequestMethod.POST , path = "/add")
    public ResponseEntity<Object> addEmployee(@Valid  @RequestBody Employee emp){
          service.addEmp(emp);
          return ResponseEntity.created(null).build();
    }

    @RequestMapping(method = RequestMethod.PUT,path = "/update")
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee emp){
        service.updateEmp(emp);
        return ResponseEntity.created(null).build();
    }



}


