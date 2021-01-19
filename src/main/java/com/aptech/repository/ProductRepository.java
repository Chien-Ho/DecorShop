package com.aptech.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aptech.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	Page<Product> findById(Long id, Pageable pageable);
	Page<Product> findAll(Pageable pageable);
	Product findById(int id);
	@Query(value ="SELECT * FROM Product where status = :status limit :limit", nativeQuery = true)
	List<Product> findAllByStatus(@Param("status") boolean status, @Param("limit") int limit);
	@Query(value ="SELECT * FROM Product where status = :status and featured = :featured limit :limit", nativeQuery = true)
	List<Product> findAllByStatusAndFeatured(@Param("status") boolean status,@Param("featured") boolean featured, @Param("limit") int limit);
	@Query(value ="SELECT * FROM Product where status = :status and category_id =:categoryId limit :limit", nativeQuery = true)
	List<Product> relatedProduct(@Param("status") boolean status,@Param("categoryId") Long categoryId, @Param("limit") int limit);
	@Query("FROM Product where status = :status and name LIKE %:keywords%")
	List<Product> searchAll(@Param("status") boolean status, @Param("keywords") String keywords);
	@Query("FROM Product  where status = :status and category_id = :categoryId and name LIKE %:keywords%")
	List<Product> searchByCategory(@Param("status") boolean status, @Param("keywords") String keywords,@Param("categoryId") int categoryId);


}
