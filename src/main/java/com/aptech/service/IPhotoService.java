package com.aptech.service;

import org.springframework.stereotype.Service;

import com.aptech.model.Photo;

@Service
public interface IPhotoService {
	Photo save(Photo photo);
	void delete(Long id);
	Photo findById(Long id);

}
