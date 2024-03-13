package com.cibertec.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.models.Category;
import com.cibertec.models.Kind;
import com.cibertec.models.Priority;
import com.cibertec.models.Project;
import com.cibertec.models.Status;
import com.cibertec.models.Ticket;
import com.cibertec.models.User;
import com.cibertec.models.dto.TicketRequest;
import com.cibertec.repository.CategoryRepository;
import com.cibertec.repository.KindRepository;
import com.cibertec.repository.PriorityRepository;
import com.cibertec.repository.ProjectRepository;
import com.cibertec.repository.StatusRepository;
import com.cibertec.repository.UserRepository;
import com.cibertec.service.TicketService;
import com.cibertec.util.AppSettings;

@RestController
@RequestMapping("/ticket")
@CrossOrigin(origins = AppSettings.CrossOriginUrl)
public class TicketController {
	
	@Autowired
    private TicketService ticketService;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private KindRepository kindRepository;
	
	@Autowired
	private PriorityRepository priorityRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private UserRepository userRepository;

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Optional<Ticket> ticket = ticketService.find(id);
        return ticket.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Ticket add(@RequestBody TicketRequest ticketRequest) throws BadRequestException {

        // Obtener las entidades relacionadas a partir de los IDs
        Category category = categoryRepository.findById(ticketRequest.getCategoryId()).orElse(null);
        Kind kind = kindRepository.findById(ticketRequest.getKindId()).orElse(null);
        Priority priority = priorityRepository.findById(ticketRequest.getPriorityId()).orElse(null);
        Project project = projectRepository.findById(ticketRequest.getProjectId()).orElse(null);
        Status status = statusRepository.findById(ticketRequest.getStatusId()).orElse(null);
        User user = userRepository.findById(ticketRequest.getUserId()).orElse(null);
        
     // Verifique si hay entidades nulas y maneje adecuadamente (por ejemplo, lanzar una excepción)
        if (category == null || kind == null || priority == null || project == null || status == null || user == null) {
          throw new BadRequestException("Falta la entidad relacionada requerida para la creación del ticket");
        }

        // Crear un nuevo ticket con las entidades relacionadas
        Ticket ticket = new Ticket();
        ticket.setTitle(ticketRequest.getTitle());
        ticket.setDescription(ticketRequest.getDescription());
        ticket.setCategory(category);
        ticket.setKind(kind);
        ticket.setPriority(priority);
        ticket.setProject(project);
        ticket.setStatus(status);
        ticket.setUser(user);

        // Guardar el ticket en la base de datos
        return ticketService.add(ticket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Long id, @RequestBody TicketRequest request) {
        Optional<Ticket> ticketOptional = ticketService.find(id);
        if (ticketOptional.isPresent()) {
            Ticket ticket = ticketOptional.get();

            // Mapear los campos de TicketRequest a Ticket
            ticket.setTitle(request.getTitle());
            ticket.setDescription(request.getDescription());
            ticket.setCategory(categoryRepository.findById(request.getCategoryId()).orElse(null));
            ticket.setKind(kindRepository.findById(request.getKindId()).orElse(null));
            ticket.setPriority(priorityRepository.findById(request.getPriorityId()).orElse(null));
            ticket.setProject(projectRepository.findById(request.getProjectId()).orElse(null));
            ticket.setStatus(statusRepository.findById(request.getStatusId()).orElse(null));
            ticket.setUser(userRepository.findById(request.getUserId()).orElse(null));

            Ticket updatedTicket = ticketService.update(ticket);
            return new ResponseEntity<>(updatedTicket, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        if (ticketService.find(id).isPresent()) {
            ticketService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/categoryusers")
    public ResponseEntity<Map<String, Map<String, Long>>> getUsersWithTicketsByCategory() {
        Map<String, Map<String, Long>> usersWithTicketsByCategory = ticketService.getUsersWithTicketsByCategory();
        if (usersWithTicketsByCategory != null) {
            return new ResponseEntity<>(usersWithTicketsByCategory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
