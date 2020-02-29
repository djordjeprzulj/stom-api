package com.stom.app.kvartalniIzvestaj;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StarosneKategorije implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int ukupno;
	private int predskolskaDeca;
	private int omladina;
	private int ostali;

}
