package Restapi_method.service;

import Restapi_method.entity.Company;
import Restapi_method.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }

    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    public Company addCompany(Company company){
        return companyRepository.save(company);
    }

    public Optional<Company> updatedCompany(Long id , Company updatedCompany){
        Optional<Company> updateCompanyById = companyRepository.findById(id);
        if (updateCompanyById.isPresent()) {
            Company company = updateCompanyById.get();
            company.setCompanyName(updatedCompany.getCompanyName());
            companyRepository.save(company);
            return Optional.of(company);
        }
        return Optional.empty();
    }

    public boolean deleteCompanyById(Long id){
        companyRepository.deleteById(id);
        return true;
    }
}
