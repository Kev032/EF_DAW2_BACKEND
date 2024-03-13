package com.cibertec.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.models.Ticket;
import com.cibertec.repository.TicketRepository;
import com.cibertec.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	TicketRepository ticketRepository;

	@Override
	public List<Ticket> list() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket add(Ticket t) {
		return ticketRepository.save(t);
	}

	@Override
	public Optional<Ticket> find(Long id) {
		return ticketRepository.findById(id);
	}

	@Override
	public Ticket getTicketById(Long id) {
		return ticketRepository.findById(id).orElse(null);
	}

	@Override
	public Ticket update(Ticket t) {
		return ticketRepository.save(t);
	}

	@Override
	public void delete(Long id) {
		ticketRepository.deleteById(id);
		
	}

	 @Override
	    public Map<String, Map<String, Long>> getUsersWithTicketsByCategory() {
	        List<Ticket> tickets = ticketRepository.findAll();
	        
	        // Creamos un mapa para almacenar los usuarios con sus tickets agrupados por categoría
	        Map<String, Map<String, Long>> usersWithTicketsByCategory = new HashMap<>();
	        
	        // Iteramos sobre la lista de tickets
	        for (Ticket ticket : tickets) {
	            String userName = ticket.getUser().getName(); // Obtenemos el nombre del usuario
	            String categoryName = ticket.getCategory().getName(); // Obtenemos el nombre de la categoría
	            
	            // Si el usuario no está en el mapa, lo agregamos
	            if (!usersWithTicketsByCategory.containsKey(userName)) {
	                usersWithTicketsByCategory.put(userName, new HashMap<>());
	            }
	            
	            // Obtenemos el mapa de tickets del usuario
	            Map<String, Long> userTickets = usersWithTicketsByCategory.get(userName);
	            
	            // Actualizamos el contador de tickets para la categoría actual del usuario
	            userTickets.put(categoryName, userTickets.getOrDefault(categoryName, 0L) + 1);
	        }
	        
	        return usersWithTicketsByCategory;
	    }

}
