package com.stom.app.kvartalniIzvestaj;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class KvartalniIzvestajRestController {
	
	@Autowired
	private KvartalniIzvestajInterface kvartalniIzvestajInterface;
	
	
	@GetMapping(value = "kvartalniIzvestaj/{pocIntervala}/{krajIntervala}")
	public ResponseEntity<KvartalniIzvestaj> getData(@PathVariable("pocIntervala") String _pocIntervala, @PathVariable("krajIntervala") String _krajIntervala) throws SQLException{
		
		KvartalniIzvestaj kvartalniIzvestaj = kvartalniIzvestajInterface.generisiKvartalniIzvestaj(_pocIntervala,_krajIntervala);
		
		return new ResponseEntity<KvartalniIzvestaj>(kvartalniIzvestaj, HttpStatus.OK);
	}

}
