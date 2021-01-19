package com.aptech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aptech.model.BillDetail;
import com.aptech.model.User;
@Repository
public interface BillsDetailRepository extends JpaRepository<BillDetail, Long>{
	

}
