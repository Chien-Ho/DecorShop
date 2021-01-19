package com.aptech.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aptech.model.Photo;
import com.aptech.model.Product;
import com.aptech.service.ICategoryService;
import com.aptech.service.IPhotoService;
import com.aptech.service.IProductService;


@Controller
@RequestMapping("/admin")
public class PhotoController implements ServletContextAware{
	private ServletContext servletContext;
	@Autowired 
	private IProductService productService;
	@Autowired 
	private IPhotoService photoService;

	@GetMapping("/photo-list/{id}")
	public String List(@PathVariable("id") Long id,Pageable pageable,Model model) {
Page<Product> products = productService.findById(id, pageable);
		
		model.addAttribute("number",products.getNumber());
		model.addAttribute("size",products.getSize());
		model.addAttribute("totalElements",products.getTotalElements());
		model.addAttribute("totalPages",products.getTotalPages());
		model.addAttribute("productId",id);
		model.addAttribute("products",products);
		return "admin/photo-list";
	}
	@GetMapping("/photo-add/{id}")
	public String Add(@PathVariable("id") Long id,Model model) {
		
		Product product = productService.findById(id);
		Photo photo = new Photo();
		photo.setProduct(product);
		photo.setStatus(true);
		model.addAttribute("photo", photo);
		
		return "admin/photo-add";
	}
	@PostMapping("/photo-add")
	public String add(@ModelAttribute("photo") Photo photo,@RequestParam(value="file") MultipartFile file) {
		photo.setName(uploadFile(file));
		photoService.save(photo);
		return "redirect:/photo-list/" + photo.getProduct().getId();
		
	}
	public String uploadFile(MultipartFile multipartFile) {
		try {
			String path = servletContext.getRealPath("/uploads/images/"+ multipartFile.getOriginalFilename());
			multipartFile.transferTo(new java.io.File(path));
			
			return multipartFile.getOriginalFilename();
		} catch(Exception ex) {
			return "no-image.png";	
		}
		
		
	}
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		
	}
	@GetMapping("/photo-update/{pId}/{photoId}")
	public String updatePhoto(@PathVariable(value="photoId") Long photoId,Model model) {
		Photo photo =  new Photo();
		if(photoId != null) {
			 photo = photoService.findById(photoId);
		}
		model.addAttribute("photo", photo);
		return "admin/photo-update";
	}
	@PostMapping("/photo-update")
	public String update(@ModelAttribute("photo") Photo photo,@RequestParam(value="file") MultipartFile file) {
		Photo currentPhoto = photoService.findById(photo.getId());
		if(file!= null &&!file.getOriginalFilename().isEmpty()) {
			currentPhoto.setName(uploadFile(file));
		}
		currentPhoto.setStatus(photo.isStatus());
		photoService.save(currentPhoto);
		return "redirect:/admin/photo-list/" + photo.getProduct().getId();
		
	}
	@PostMapping("/photo-detele/{pId}/{photoId}")
	public String detelePhoto(@PathVariable("pId") Long productId,@PathVariable("photoId") Long photoId) {
		photoService.delete(photoId);
		
		return "redirect:/admin/photo-list/" + productId;
		
	}
	

}
