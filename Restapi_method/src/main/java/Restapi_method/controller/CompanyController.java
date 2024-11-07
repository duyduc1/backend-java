package Restapi_method.controller;

import Restapi_method.entity.Company;
import Restapi_method.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    private List<Company> getAllCompany() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable("id") Long id){
        Company company = companyService.getCompanyById(id);
        return new ResponseEntity<>(company , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company){
        companyService.addCompany(company);
        return ResponseEntity.ok("Đăng ký doanh nghiêp thành công");
    }

    @PutMapping("/{id}")
    public String updateCompany(@PathVariable("id") Long id, @RequestBody Company company){
        companyService.updatedCompany(id,company);
        return "Cập nhật thành công ";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable("id") Long id){
        companyService.deleteCompanyById(id);
        return ResponseEntity.ok("Xoá thành công");
    }
}
