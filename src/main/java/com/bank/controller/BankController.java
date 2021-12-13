package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.Bank;
import com.bank.service.BankService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BankController {
	
	@Autowired
	private BankService service;
	
	@PostMapping("/getBankDetails")
	public List<Bank> getBankDetails(@RequestBody Bank bank){
		return service.getBankDetails(bank);
	}
	
}
