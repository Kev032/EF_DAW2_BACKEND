package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.models.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {

}
