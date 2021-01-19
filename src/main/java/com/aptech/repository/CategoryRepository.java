package com.aptech.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aptech.model.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	@Query("from Category c where c.parent = null")
	public Page<Category> findParentCategory(Pageable pageable);
	@Query("from Category c where c.parent = null")
	public List<Category> findParentCategory();
	public Page<Category> findById(Long id, Pageable pageable);
	@Query("from Category c where c.parent = null and c.status =:status")
	public List<Category> findParentCategoryWithStatus(@Param("status") boolean status);

}
