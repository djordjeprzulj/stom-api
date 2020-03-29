package com.stom.app.kvartalniIzvestaj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class KvartalniIzvestajStavka {
	
	private String kategorija;
	private int predskolskaDeca;
	private int omladina;
	private int ostali;
	private int ukupno;

}
