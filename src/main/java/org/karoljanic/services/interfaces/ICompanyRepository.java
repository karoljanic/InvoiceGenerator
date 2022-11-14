package org.karoljanic.services.interfaces;

import org.karoljanic.models.Company;

import java.util.List;

// Cel klasy: implementacja interface'u magazynu danych o firmach
public interface ICompanyRepository {
    List<Company> getAll();
    Company getByIdentifier(String companyIdentifier);
    void save(Company company);
    void update(Company company);
    void delete(Company company);
}
