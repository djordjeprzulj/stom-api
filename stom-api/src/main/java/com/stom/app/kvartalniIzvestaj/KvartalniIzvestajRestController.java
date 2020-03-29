package com.stom.app.kvartalniIzvestaj;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;

@RestController
@CrossOrigin
public class KvartalniIzvestajRestController {
	
	@Autowired
	private KvartalniIzvestajInterface kvartalniIzvestajInterface;
	
	KvartalniIzvestaj kvartalniIzvestaj;
	
	
	@GetMapping(value = "kvartalniIzvestaj/{pocIntervala}/{krajIntervala}")
	public ResponseEntity<KvartalniIzvestaj> getData(@PathVariable("pocIntervala") String _pocIntervala, @PathVariable("krajIntervala") String _krajIntervala) throws SQLException{
		
		kvartalniIzvestaj = kvartalniIzvestajInterface.generisiKvartalniIzvestaj(_pocIntervala,_krajIntervala);
		
		return new ResponseEntity<KvartalniIzvestaj>(kvartalniIzvestaj, HttpStatus.OK);
	}
	
	@GetMapping(value = "kvartalniIzvestaj/pdfReport")
	public ResponseEntity<String> getPdfReport() throws FileNotFoundException, JRException{
		
		String pdfDestination = kvartalniIzvestajInterface.generatePDF(kvartalniIzvestaj);
		
		return new ResponseEntity<String>(pdfDestination, HttpStatus.OK);
		
		
	}

}
