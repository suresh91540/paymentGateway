package com.payment.application.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.application.model.Payee;
import com.payment.application.repository.PayeeRepository;

@Service
public class PayeeService {
	@Autowired
	PayeeRepository payeeRepository;

//getting all Payee records  
	public List<Payee> getAllPayee() {
		List<Payee> Payees = new ArrayList<Payee>();
		payeeRepository.findAll().forEach(Payee -> Payees.add(Payee));
		return Payees;
	}

//getting a specific record  
	public Payee getPayeeById(int id) {
		return payeeRepository.findById(id).get();
	}

	public Payee saveOrUpdate(Payee payee) {
		return payeeRepository.save(payee);
	}

//deleting a specific record  
	public void delete(int id) {
		payeeRepository.deleteById(id);
	}
}