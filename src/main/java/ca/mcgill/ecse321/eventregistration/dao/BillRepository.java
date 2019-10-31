package ca.mcgill.ecse321.eventregistration.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.eventregistration.model.Bill;

public interface BillRepository extends CrudRepository<Bill, String> {

	Bill findBillByAmount(double amount);

}