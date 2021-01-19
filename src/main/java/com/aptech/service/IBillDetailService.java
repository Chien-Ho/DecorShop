package com.aptech.service;

import org.springframework.stereotype.Service;

import com.aptech.model.BillDetail;

@Service
public interface IBillDetailService {
	BillDetail save(BillDetail billDetail);
}
