package com.stom.app.ctrls;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stom.app.jpa.Status;
import com.stom.app.reps.StatusRepository;

@RestController
@CrossOrigin
@RequestMapping("status")
public class StatusRestController {
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping
	public Collection<Status> getAll() {
		return statusRepository.findAll();
	}
	
	@GetMapping(value = "/{id}")
    public ResponseEntity<Status> get(@PathVariable("id") int id) {
        Optional<Status> obj = statusRepository.findById(id);
        return new ResponseEntity(obj, HttpStatus.OK);
    }
		
	@PostMapping
    public ResponseEntity<Void> insertStatus(@RequestBody Status obj) {
		statusRepository.save(obj);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
	
	@PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateStatus(@PathVariable("id") Integer id, @RequestBody Status obj) {
        if (!statusRepository.existsById(id)) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        statusRepository.save(obj);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
	
	@DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable("id") Integer id) {
        if (!statusRepository.existsById(id)) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }	
		statusRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
