package com.payment.application.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.application.model.Beneficiary;
import com.payment.application.model.Payee;

@Service
public class PaymentService {
	
	@Autowired
	BeneficiaryService beneficiaryService;
	
	@Autowired
	PayeeService payeeService;
	
	public boolean payMoneyToAccount(Beneficiary beneficiary,Integer amount) {
		boolean result = false;
		Payee existPayee = payeeService.getPayeeById(1);
		Integer payeeAmountChange = existPayee.getBalance()-amount;
		Beneficiary existingBeneficiary = beneficiaryService.getBeneficiaryById(beneficiary.getId());
		if(Objects.nonNull(existingBeneficiary) && payeeAmountChange>0) {
			existingBeneficiary.setBalance(existingBeneficiary.getBalance()+amount);
			existingBeneficiary = beneficiaryService.saveOrUpdate(existingBeneficiary);
			
			existPayee.setBalance(existPayee.getBalance()-amount);
			payeeService.saveOrUpdate(existPayee);
			
			result=true;
			
		}
		return result;
	}
}