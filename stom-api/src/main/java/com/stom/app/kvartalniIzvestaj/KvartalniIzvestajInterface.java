package com.stom.app.kvartalniIzvestaj;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import net.sf.jasperreports.engine.JRException;

public interface KvartalniIzvestajInterface {
	
	public KvartalniIzvestaj generisiKvartalniIzvestaj(String pocIntervala, String krajIntervala) throws SQLException;
	
	public String generatePDF(KvartalniIzvestaj kvartalniIzvestaj) throws FileNotFoundException, JRException;
	
	

}
