package com.aptech.api.downupload.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileResponse {
	private String fileName;
    private String fileUrl;
    private String message;
	public FileResponse(String fileName, String fileUrl, String message) {
		this.fileName = fileName;
		this.fileUrl = fileUrl;
		this.message = message;
	}
	
	
}
