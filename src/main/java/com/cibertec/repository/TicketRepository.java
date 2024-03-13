package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.models.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
	
	@Query("SELECT u.username, c.name, COUNT(t) " +
	           "FROM Ticket t " +
	           "JOIN t.user u " +
	           "JOIN t.category c " +
	           "GROUP BY u.username, c.name")
	    List<Object[]> getUsersWithTicketsByCategory();

}
