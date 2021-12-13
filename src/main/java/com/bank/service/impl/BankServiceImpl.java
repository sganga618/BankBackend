package com.bank.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.bank.dto.Bank;
import com.bank.service.BankService;

@Service
public class BankServiceImpl implements BankService {

	public List<Bank> getBankDetails(Bank bank) {
		List<Bank> details = new ArrayList<Bank>();
		try {
			File inputF = new File("data.csv");
			InputStream inputFS = new FileInputStream(inputF);
			BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));

			details = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
			br.close();
		} catch (Exception e) {

		}
		//apply search filters
		details = applyFilters(details, bank);
		return details;
	}

	private List<Bank> applyFilters(List<Bank> details, Bank bank) {
		if(StringUtils.isNotEmpty(bank.getName())) {
			details = details.stream().filter(b->bank.getName().equals(b.getName())).collect(Collectors.toList());
		}
		if(StringUtils.isNotEmpty(bank.getType())) {
			details = details.stream().filter(b-> bank.getType().equals(b.getType())).collect(Collectors.toList());
		}
		if(StringUtils.isNotEmpty(bank.getCity()) ) {
			details =  details.stream().filter(b->bank.getCity().equals(b.getCity())).collect(Collectors.toList());
		}
		if(StringUtils.isNotEmpty(bank.getState()) ) {
			details = details.stream().filter(b->bank.getState().equals(b.getState())).collect(Collectors.toList());
		}
		if(StringUtils.isNotEmpty(bank.getZipCode())) {
			details = details.stream().filter(b->bank.getZipCode().equals(b.getZipCode())).collect(Collectors.toList());
		}
		
		return details;
	}

	private Function<String, Bank> mapToItem = (line) -> {
	  String[] p = line.split(";");
	  Bank item = new Bank();
	  item.setId(p[0].trim());
	  item.setName(p[1].trim());
	  item.setType(p[2].trim());
	  item.setCity(p[3].trim());
	  item.setState(p[4].trim());
	  item.setZipCode(p[5].trim());
	  return item;
	};
}
