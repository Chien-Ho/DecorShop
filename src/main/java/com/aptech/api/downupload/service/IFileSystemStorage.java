package com.aptech.api.downupload.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IFileSystemStorage {
	String saveFile(MultipartFile file);
	Resource loadFile(String fileName);

}
