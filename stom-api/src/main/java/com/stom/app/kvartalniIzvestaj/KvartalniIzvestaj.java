package com.stom.app.kvartalniIzvestaj;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class KvartalniIzvestaj implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private StarosneKategorije poseteUkupno;
	private StarosneKategorije prvePosete;
	private StarosneKategorije serijskePosete;
	private StarosneKategorije plombiraniZubiBezLecenja;
	private StarosneKategorije plombiraniZubiSaLecenjem;
	private StarosneKategorije hirurskeIntervencijeVadjenje;
	private StarosneKategorije hirurskeIntervencijeOstalo;
	private StarosneKategorije pokretneProtezeTotalne;
	private StarosneKategorije pokretneProtezeParcijalne;
	private StarosneKategorije fiksneProtezeKrunice;
	private StarosneKategorije fiksneProtezeClanovi;
	private StarosneKategorije ortodoncijaPrviPregledi;
	private StarosneKategorije ortodoncijaPokretniAparati;
	private StarosneKategorije ortodoncijaTerapeutskeIntervencije;
	private StarosneKategorije ortodoncijaFiksniAparati;
	private StarosneKategorije mekaTkivaUsneSupljine;

}
