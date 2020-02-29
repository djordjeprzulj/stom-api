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

import com.stom.app.jpa.GrupaIntervencija;
import com.stom.app.reps.GrupaIntervencijaRepository;
import com.stom.app.reps.VrstaIntervencijeRepository;

@RestController
@CrossOrigin
@RequestMapping("grupaIntervencija")
public class GrupaIntervencijaRestController {
	
	@Autowired
	private GrupaIntervencijaRepository grupaIntervencijaRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping
	public Collection<GrupaIntervencija> getAll() {
		return grupaIntervencijaRepository.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Void> get(@PathVariable("id") int id) {
		Optional<GrupaIntervencija> obj = grupaIntervencijaRepository.findById(id);
		return new ResponseEntity(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> insertGrupaIntervencija(@RequestBody GrupaIntervencija obj) {
		grupaIntervencijaRepository.save(obj);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> updateGrupaIntervencija (@PathVariable("id") Integer id, @RequestBody GrupaIntervencija obj){
		if (!grupaIntervencijaRepository.existsById(id)) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		grupaIntervencijaRepository.save(obj);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteGrupaIntervencija(@PathVariable("id")Integer id) {
		if(!grupaIntervencijaRepository.existsById(id)) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		grupaIntervencijaRepository.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	

}
