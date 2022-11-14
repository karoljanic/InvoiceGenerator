package org.karoljanic.services.repositories;

import org.karoljanic.models.Company;
import org.karoljanic.services.interfaces.ICompanyRepository;

import java.util.List;

// Cel klasy: implementacja magazynu danych o firmach
public class CompanyRepository implements ICompanyRepository {
    @Override
    public List<Company> getAll() {
        return null;
    }

    @Override
    public Company getByIdentifier(String companyIdentifier) {
        return null;
    }

    @Override
    public void save(Company company) {

    }

    @Override
    public void update(Company company) {

    }

    @Override
    public void delete(Company company) {

    }
}
