package Restapi_method.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "employees")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String employeeName;
    private String addressEmployee;
    private Integer phoneEmployee;
    private String emailEmployee;

    @ManyToMany
    @JoinTable(
            name = "employee_company",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    private List<Company> companyList; // This field represents the many-to-many relationship with Company
}
