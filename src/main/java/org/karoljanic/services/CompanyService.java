package org.karoljanic.services;

import org.karoljanic.models.Company;
import org.karoljanic.services.interfaces.ICompanyRepository;

import java.util.List;

// Cel klasy: zarzadzanie danymi o firmach
public class CompanyService {
    private final ICompanyRepository _companyRepository;

    public CompanyService(ICompanyRepository companyRepository) {
        _companyRepository = companyRepository;
    }

    public List<Company> getAll() { return _companyRepository.getAll(); }
    public Company getByIdentifier(String companyIdentifier) { return _companyRepository.getByIdentifier(companyIdentifier); }
    public void save(Company company) { _companyRepository.save(company); }
    public void update(Company company) { _companyRepository.update(company); }
    public void delete(Company company) { _companyRepository.delete(company); }
}
