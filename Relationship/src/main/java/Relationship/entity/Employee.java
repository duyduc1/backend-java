package Relationship.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private int numberphone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id" , referencedColumnName = "id" , nullable = false)
    private Company company;

    @Column(name = "companyName")
    private String companyName;
}
