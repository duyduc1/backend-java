package Restapi_method.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;

    @ManyToMany(mappedBy = "companyList") // Update this to match the field in Employee
    private Set<Employee> employees;

    public Set<Employee> getEmployees() {
        return employees;
    }
}
