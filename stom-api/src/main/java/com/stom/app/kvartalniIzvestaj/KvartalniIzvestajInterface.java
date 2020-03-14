package com.stom.app.kvartalniIzvestaj;

import java.sql.SQLException;

public interface KvartalniIzvestajInterface {
	
	public KvartalniIzvestaj generisiKvartalniIzvestaj(String pocIntervala, String krajIntervala) throws SQLException;
	
	

}
