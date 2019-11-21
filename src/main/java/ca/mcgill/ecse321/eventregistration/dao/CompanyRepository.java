package ca.mcgill.ecse321.eventregistration.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.eventregistration.model.Company;

public interface CompanyRepository extends CrudRepository<Company, String> {

	Company findCompanyByName(String name);

}
