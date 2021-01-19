package com.aptech.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aptech.repository.CategoryRepository;
import com.aptech.repository.PhotoRepository;
import com.aptech.service.ICategoryService;
import com.aptech.service.IPhotoService;
import com.aptech.model.Category;
import com.aptech.model.Photo;

@Service
public class PhotoServiceImpl implements IPhotoService{
	@Autowired
	private PhotoRepository photoRepository;

	@Override
	@Transactional
	public Photo save(Photo photo) {
		return photoRepository.save(photo);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		photoRepository.deleteById(id);
		
	}

	@Override
	public Photo findById(Long id) {
		
		return photoRepository.findById(id).get();
	}
	


}
