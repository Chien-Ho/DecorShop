package com.aptech.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aptech.repository.BillsDetailRepository;
import com.aptech.repository.BillsRepository;
import com.aptech.repository.CategoryRepository;
import com.aptech.repository.PhotoRepository;
import com.aptech.service.IBillDetailService;
import com.aptech.service.ICategoryService;
import com.aptech.service.IPhotoService;
import com.aptech.model.BillDetail;
import com.aptech.model.Bills;
import com.aptech.model.Category;
import com.aptech.model.Photo;

@Service
public class BillDetailService implements IBillDetailService{
	@Autowired 
	private BillsDetailRepository billsDetailRepository;

	

	@Override
	public BillDetail save(BillDetail billDetail) {
		return billsDetailRepository.save(billDetail);
	}


}
