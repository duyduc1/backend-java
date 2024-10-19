package Restapi_method.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
}
