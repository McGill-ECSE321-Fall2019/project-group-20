package ca.mcgill.ecse321.cooperator.services;

import ca.mcgill.ecse321.cooperator.Utilities;

import ca.mcgill.ecse321.cooperator.dao.*;
import ca.mcgill.ecse321.cooperator.model.*;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class RateService {

@Autowired
RateRepository rateRepository;

/**
 * Get all rates from the system.
 *
 * @return a list of rates representing all rates in the system.
 */

@Transactional
public List<Rate> getAllRates() {
    return (List<Rate>) rateRepository.findAll();
}
