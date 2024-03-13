package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cibertec.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
