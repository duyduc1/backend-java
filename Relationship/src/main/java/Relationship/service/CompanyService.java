package Relationship.service;

import Relationship.entity.Company;
import Relationship.repository.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepo companyRepo;

    public List<Company> getAllCompany(){
        return companyRepo.findAll();
    }

    public Company getCompanyById(Long id){
        return companyRepo.findById(id).orElse(null);
    }

    public void saveCompany(Company company){
        companyRepo.save(company);
    }

    public void updateCompany(Long id , Company updatedCompany){
        Company company = companyRepo.findById(id).orElse(null);
        company.setCompanyName(updatedCompany.getCompanyName());
        companyRepo.save(company);
    }

    public void deleteCompany(Long id ){
        companyRepo.deleteById(id);
    }
}
