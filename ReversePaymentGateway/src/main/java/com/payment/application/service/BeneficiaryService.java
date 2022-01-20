package com.payment.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.demo.repository.BeneficiaryRepository;
import com.payment.application.model.Beneficiary;

@Service
public class BeneficiaryService {
	@Autowired
	BeneficiaryRepository beneficiaryRepository;

	public List<Beneficiary> getAllBeneficiary() {
		List<Beneficiary> Beneficiarys = new ArrayList<Beneficiary>();
		beneficiaryRepository.findAll().forEach(Beneficiary -> Beneficiarys.add(Beneficiary));
		return Beneficiarys;
	}

	public Beneficiary getBeneficiaryById(int id) {
		return beneficiaryRepository.findById(id).get();
	}

	public Beneficiary saveOrUpdate(Beneficiary beneficiary) {
		return beneficiaryRepository.save(beneficiary);
	}

	public void delete(int id) {
		beneficiaryRepository.deleteById(id);
	}
}