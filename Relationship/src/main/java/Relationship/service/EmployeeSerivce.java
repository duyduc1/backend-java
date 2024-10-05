package Relationship.service;

import Relationship.entity.Employee;
import Relationship.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSerivce {
    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployee(){
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(Long id){
        return employeeRepo.findById(id).orElse(null);
    }

    public void saveEmployee(Employee employee){
        employeeRepo.save(employee);
    }

    public void updateEmployee(Long id , Employee updateEmployee){
        Employee employees = employeeRepo.findById(id).orElse(null);
        employees.setUsername(updateEmployee.getUsername());
        employees.setEmail(updateEmployee.getEmail());
        employees.setNumberphone(updateEmployee.getNumberphone());
        employeeRepo.save(employees);
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
    }

}
