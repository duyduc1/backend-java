package Restapi_method.repository;

import Restapi_method.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company , Long> {
}
