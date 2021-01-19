package com.aptech.service;

import org.springframework.stereotype.Service;

import com.aptech.model.Bills;

@Service
public interface IBillsService {
	Bills save(Bills bills);
	
}
