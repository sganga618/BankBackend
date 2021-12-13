package com.bank.service;

import java.util.List;

import com.bank.dto.Bank;

public interface BankService {

	List<Bank> getBankDetails(Bank bank);
	
}
