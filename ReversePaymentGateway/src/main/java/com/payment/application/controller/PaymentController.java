package com.payment.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payment.application.model.Beneficiary;
import com.payment.application.service.PaymentService;

@RestController
@CrossOrigin(origins = "*")
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@PostMapping("pay/{amount}")
	public boolean addMoneyToAccount(@PathVariable("amount") Integer amount,@RequestBody Beneficiary beneficiary) {
		return paymentService.payMoneyToAccount(beneficiary, amount);
	}
	
}
