package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.models.Kind;

public interface KindRepository extends JpaRepository<Kind, Long> {

}
