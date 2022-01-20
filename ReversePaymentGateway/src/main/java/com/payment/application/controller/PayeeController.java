package com.payment.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payment.application.model.Payee;
import com.payment.application.service.PayeeService;

@RestController
@CrossOrigin(origins = "*")
public class PayeeController {
	@Autowired
	PayeeService payeeService;

	@GetMapping("/payee")
	private List<Payee> getAllPayee() {
		return payeeService.getAllPayee();
	}

	@GetMapping("/payee/{id}")
	private Payee getPayee(@PathVariable("id") int id) {
		return payeeService.getPayeeById(id);
	}

	@DeleteMapping("/payee/{id}")
	private void deletePayee(@PathVariable("id") int id) {
		payeeService.delete(id);
	}

	@PostMapping("/payee")
	private Payee savePayee(@RequestBody Payee payee) {
		Payee result = payeeService.saveOrUpdate(payee);
		return result;
	}
}