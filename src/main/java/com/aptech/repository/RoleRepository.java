package com.aptech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aptech.model.Role;
import com.aptech.model.User;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	 Role findByName(String roleName);

}
