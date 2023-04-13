package com.clienteCred.clienteCred.repository;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.clienteCred.clienteCred.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, String> {
	
	Page<ClienteEntity> findAll(Pageable pageable);

}
