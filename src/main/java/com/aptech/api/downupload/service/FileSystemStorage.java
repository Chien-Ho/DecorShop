package com.aptech.api.downupload.service;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;

import org.springframework.web.multipart.MultipartFile;
import com.aptech.api.downupload.exception.FileNotFoundException;
import com.aptech.api.downupload.exception.FileStorageException;
import com.aptech.api.downupload.properties.FileUploadProperties;

public class FileSystemStorage implements IFileSystemStorage{
	private final Path dirLocation;
	@Autowired
	public FileSystemStorage(FileUploadProperties fileUploadProperties) {
		this.dirLocation = Paths.get(fileUploadProperties.getLocation()).toAbsolutePath().normalize();
		 try {
	            Files.createDirectories(this.dirLocation);
	        } catch (Exception ex) {
	            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.");
	        }
	}

	
	

	@Override
	public String saveFile(MultipartFile file) {
		
		try {
			String fileName = file.getOriginalFilename();
			Path dfile = this.dirLocation.resolve(fileName);
			Files.copy(file.getInputStream(), dfile, StandardCopyOption.REPLACE_EXISTING);
			return fileName;
		} catch (Exception e) {
			throw new FileStorageException("Could not upload file");
		}
		
		
	}




	@Override
	public org.springframework.core.io.Resource loadFile(String fileName) {
		
		   try {
               Path file = this.dirLocation.resolve(fileName).normalize();
               org.springframework.core.io.Resource resource = new UrlResource(file.toUri());

               if (resource.exists() || resource.isReadable()) {
                   return resource;
               } 
               else {
                   throw new FileNotFoundException("Could not find file");
               }
             } 
             catch (MalformedURLException e) {
                 throw new FileNotFoundException("Could not download file");
             }           
         }
	}

	


