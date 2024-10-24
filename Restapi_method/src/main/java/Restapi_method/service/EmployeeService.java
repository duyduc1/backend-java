package Restapi_method.service;

import Restapi_method.entity.Employee;
import Restapi_method.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Optional<Employee> updateEmployee(Long id , Employee updateEmployee) {
        Optional<Employee> updateEmployeeById = employeeRepository.findById(id);
        if(updateEmployeeById.isPresent()){
            Employee employeeUpdate = updateEmployeeById.get();
            employeeUpdate.setAddressEmployee(updateEmployee.getAddressEmployee());
            employeeUpdate.setEmployeeName(updateEmployee.getEmployeeName());
            employeeUpdate.setEmailEmployee(updateEmployee.getEmailEmployee());
            employeeUpdate.setPhoneEmployee(updateEmployee.getPhoneEmployee());
            employeeRepository.save(employeeUpdate);
            return Optional.of(employeeUpdate);
        }
        return Optional.empty();
    }

    public boolean deleteEmployee(Long id){
        employeeRepository.deleteById(id);
        return true;
    }
}
