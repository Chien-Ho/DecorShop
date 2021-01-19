package com.aptech.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aptech.repository.BillsRepository;
import com.aptech.repository.CategoryRepository;
import com.aptech.repository.PhotoRepository;
import com.aptech.service.IBillsService;
import com.aptech.service.ICategoryService;
import com.aptech.service.IPhotoService;
import com.aptech.model.Bills;
import com.aptech.model.Category;
import com.aptech.model.Photo;

@Service
@Transactional
public class BillsService implements IBillsService{
	@Autowired 
	private BillsRepository billsRepository;

	

	@Override
	public Bills save(Bills bills) {
		return billsRepository.save(bills);
	}

	
	


}
