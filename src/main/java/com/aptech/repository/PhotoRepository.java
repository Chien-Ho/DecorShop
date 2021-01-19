package com.aptech.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aptech.model.Photo;
import com.aptech.model.Product;
@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long>{
	
}
