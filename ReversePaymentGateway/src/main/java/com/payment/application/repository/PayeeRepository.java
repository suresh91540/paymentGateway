package com.payment.application.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.payment.application.model.Payee;

public interface PayeeRepository extends JpaRepository<Payee, Integer> {
	@Transactional
	@Modifying
	@Query("delete from Payee b where b.id=:id")
	void deleteById(Integer id);
}