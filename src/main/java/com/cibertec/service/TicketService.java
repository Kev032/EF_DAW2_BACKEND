package com.cibertec.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.cibertec.models.Ticket;

public interface TicketService {
	
	public List<Ticket> list();
	
	public Ticket add(Ticket t);
	
	public Optional<Ticket> find(Long id);
	
	public Ticket getTicketById(Long id);
	
	public Ticket update(Ticket t);
	
	public void delete(Long id);
	
    Map<String, Map<String, Long>> getUsersWithTicketsByCategory();


}
