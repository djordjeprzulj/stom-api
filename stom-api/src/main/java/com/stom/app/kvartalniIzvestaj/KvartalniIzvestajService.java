package com.stom.app.kvartalniIzvestaj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KvartalniIzvestajService implements KvartalniIzvestajInterface{
	
	private KvartalniIzvestaj kvartalniIzvestaj;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional
	public KvartalniIzvestaj generisiKvartalniIzvestaj(String _pocIntervala, String _krajIntervala) throws SQLException {
		kvartalniIzvestaj = new KvartalniIzvestaj();
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
		java.util.Date date = null;
		try {
			date = sdf1.parse(_pocIntervala);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date pocIntervala = new java.sql.Date(date.getTime());
		java.util.Date date1 = null;
		try {
			date1 = sdf1.parse(_krajIntervala);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date krajIntervala = new java.sql.Date(date1.getTime());
		
		Connection connection = jdbcTemplate.getDataSource().getConnection();
		
		PreparedStatement st = connection.prepareStatement("select\r\n" + 
				"sum(case when v.grupa_intervencija = 1 and extract(year from age(current_date, datum_rodjenja)) < 7 then 1 else 0 end) AS hirurskeO1,\r\n" + 
				"sum(case when v.grupa_intervencija = 30 and extract(year from age(current_date, datum_rodjenja)) < 7 then 1 else 0 end) AS fiksnapPotezaC1, \r\n" + 
				"sum(case when v.grupa_intervencija = 31 and extract(year from age(current_date, datum_rodjenja)) < 7 then 1 else 0 end) AS fiksnapPotezaK1, \r\n" + 
				"sum(case when v.grupa_intervencija = 32 and extract(year from age(current_date, datum_rodjenja)) < 7 then 1 else 0 end) AS hirurskeV1,\r\n" + 
				"sum(case when v.grupa_intervencija = 33 and extract(year from age(current_date, datum_rodjenja)) < 7 then 1 else 0 end) AS LecenjeMekihTkiva1,\r\n" + 
				"sum(case when v.grupa_intervencija = 34 and extract(year from age(current_date, datum_rodjenja)) < 7 then 1 else 0 end) AS OrtoFiksniA1,\r\n" + 
				"sum(case when v.grupa_intervencija = 35 and extract(year from age(current_date, datum_rodjenja)) < 7 then 1 else 0 end) AS OrtoPokretniA1,\r\n" + 
				"sum(case when v.grupa_intervencija = 36 and extract(year from age(current_date, datum_rodjenja)) < 7 then 1 else 0 end) AS OrtoTIntercencije1, \r\n" + 
				"sum(case when v.grupa_intervencija = 38 and extract(year from age(current_date, datum_rodjenja)) < 7 then 1 else 0 end) AS PokretnaProtezaP1,\r\n" + 
				"sum(case when v.grupa_intervencija = 39 and extract(year from age(current_date, datum_rodjenja)) < 7 then 1 else 0 end) AS PokretnaProtezaT1,\r\n" + 
				"sum(case when v.grupa_intervencija = 1 and extract(year from age(current_date, datum_rodjenja)) between 7 and 19 then 1 else 0 end) AS hirurskeO2,\r\n" + 
				"sum(case when v.grupa_intervencija = 30 and extract(year from age(current_date, datum_rodjenja)) between 7 and 19 then 1 else 0 end) AS fiksnapPotezaC2, \r\n" + 
				"sum(case when v.grupa_intervencija = 31 and extract(year from age(current_date, datum_rodjenja)) between 7 and 19 then 1 else 0 end) AS fiksnapPotezaK2, \r\n" + 
				"sum(case when v.grupa_intervencija = 32 and extract(year from age(current_date, datum_rodjenja)) between 7 and 19 then 1 else 0 end) AS hirurskeV2,\r\n" + 
				"sum(case when v.grupa_intervencija = 33 and extract(year from age(current_date, datum_rodjenja)) between 7 and 19 then 1 else 0 end) AS LecenjeMekihTkiva2,\r\n" + 
				"sum(case when v.grupa_intervencija = 34 and extract(year from age(current_date, datum_rodjenja)) between 7 and 19 then 1 else 0 end) AS OrtoFiksniA2,\r\n" + 
				"sum(case when v.grupa_intervencija = 35 and extract(year from age(current_date, datum_rodjenja)) between 7 and 19 then 1 else 0 end) AS OrtoPokretniA2,\r\n" + 
				"sum(case when v.grupa_intervencija = 36 and extract(year from age(current_date, datum_rodjenja)) between 7 and 19 then 1 else 0 end) AS OrtoTIntercencije2, \r\n" + 
				"sum(case when v.grupa_intervencija = 38 and extract(year from age(current_date, datum_rodjenja)) between 7 and 19 then 1 else 0 end) AS PokretnaProtezaP2,\r\n" + 
				"sum(case when v.grupa_intervencija = 39 and extract(year from age(current_date, datum_rodjenja)) between 7 and 19 then 1 else 0 end) AS PokretnaProtezaT2,\r\n" + 
				"sum(case when v.grupa_intervencija = 1 and extract(year from age(current_date, datum_rodjenja)) > 19 then 1 else 0 end) AS hirurskeO3,\r\n" + 
				"sum(case when v.grupa_intervencija = 30 and extract(year from age(current_date, datum_rodjenja)) > 19 then 1 else 0 end) AS fiksnapPotezaC3, \r\n" + 
				"sum(case when v.grupa_intervencija = 31 and extract(year from age(current_date, datum_rodjenja)) > 19 then 1 else 0 end) AS fiksnapPotezaK3, \r\n" + 
				"sum(case when v.grupa_intervencija = 32 and extract(year from age(current_date, datum_rodjenja)) > 19 then 1 else 0 end) AS hirurskeV3,\r\n" + 
				"sum(case when v.grupa_intervencija = 33 and extract(year from age(current_date, datum_rodjenja)) > 19 then 1 else 0 end) AS LecenjeMekihTkiva3,\r\n" + 
				"sum(case when v.grupa_intervencija = 34 and extract(year from age(current_date, datum_rodjenja)) > 19 then 1 else 0 end) AS OrtoFiksniA3,\r\n" + 
				"sum(case when v.grupa_intervencija = 35 and extract(year from age(current_date, datum_rodjenja)) > 19 then 1 else 0 end) AS OrtoPokretniA3,\r\n" + 
				"sum(case when v.grupa_intervencija = 36 and extract(year from age(current_date, datum_rodjenja)) > 19 then 1 else 0 end) AS OrtoTIntercencije3, \r\n" + 
				"sum(case when v.grupa_intervencija = 38 and extract(year from age(current_date, datum_rodjenja)) > 19 then 1 else 0 end) AS PokretnaProtezaP3,\r\n" + 
				"sum(case when v.grupa_intervencija = 39 and extract(year from age(current_date, datum_rodjenja)) > 19 then 1 else 0 end) AS PokretnaProtezaT3\r\n" + 
				"FROM izvrsena_intervencija i, vrsta_intervencije v, pacijent p\r\n" + 
				"WHERE i.vrsta_intervencije = v.id\r\n" + 
				"AND i.pacijent = p.id\r\n" +
				"AND i.datum >= ? and i.datum <= ?;");
		st.setDate(1, pocIntervala);
		st.setDate(2, krajIntervala);
		ResultSet rs = st.executeQuery();
		rs.next();
		
		kvartalniIzvestaj.setHirurskeIntervencijeOstalo(new StarosneKategorije(rs.getInt(1)+rs.getInt(11)+rs.getInt(21),rs.getInt(1),rs.getInt(11),rs.getInt(21)));
		kvartalniIzvestaj.setFiksneProtezeClanovi(new StarosneKategorije(rs.getInt(2)+rs.getInt(12)+rs.getInt(22),rs.getInt(2),rs.getInt(12),rs.getInt(22)));
		kvartalniIzvestaj.setFiksneProtezeKrunice(new StarosneKategorije(rs.getInt(3)+rs.getInt(13)+rs.getInt(23),rs.getInt(3),rs.getInt(13),rs.getInt(23)));
		kvartalniIzvestaj.setHirurskeIntervencijeVadjenje(new StarosneKategorije(rs.getInt(4)+rs.getInt(14)+rs.getInt(24),rs.getInt(4),rs.getInt(14),rs.getInt(24)));
		kvartalniIzvestaj.setMekaTkivaUsneSupljine(new StarosneKategorije(rs.getInt(5)+rs.getInt(15)+rs.getInt(25),rs.getInt(5),rs.getInt(15),rs.getInt(25)));
		kvartalniIzvestaj.setOrtodoncijaFiksniAparati(new StarosneKategorije(rs.getInt(6)+rs.getInt(16)+rs.getInt(26),rs.getInt(6),rs.getInt(16),rs.getInt(26)));
		kvartalniIzvestaj.setOrtodoncijaPokretniAparati(new StarosneKategorije(rs.getInt(7)+rs.getInt(17)+rs.getInt(27),rs.getInt(7),rs.getInt(17),rs.getInt(27)));
		kvartalniIzvestaj.setOrtodoncijaTerapeutskeIntervencije(new StarosneKategorije(rs.getInt(8)+rs.getInt(18)+rs.getInt(28),rs.getInt(8),rs.getInt(18),rs.getInt(28)));
		kvartalniIzvestaj.setPokretneProtezeParcijalne(new StarosneKategorije(rs.getInt(9)+rs.getInt(19)+rs.getInt(29),rs.getInt(9),rs.getInt(19),rs.getInt(29)));
		kvartalniIzvestaj.setPokretneProtezeTotalne(new StarosneKategorije(rs.getInt(10)+rs.getInt(20)+rs.getInt(30),rs.getInt(10),rs.getInt(20),rs.getInt(30)));
		
		
		PreparedStatement st1 = connection.prepareStatement("select\r\n" + 
				"sum(case when extract(year from age(current_date, datum_rodjenja)) < 7 then 1 else 0 end) as predskolsko,\r\n" + 
				"sum(case when extract(year from age(current_date, datum_rodjenja)) between 7 and 19 then 1 else 0 end) as omladina,\r\n" + 
				"sum(case when extract(year from age(current_date, datum_rodjenja)) > 19 then 1 else 0 end) as ostali\r\n" + 
				"from (select min(datum), pacijent from izvrsena_intervencija group by pacijent) as dat, pacijent p\r\n" + 
				"where dat.pacijent = p.id\r\n" + 
				"and dat.min >= ? and dat.min <= ?;");
		st1.setDate(1, pocIntervala);
		st1.setDate(2, krajIntervala);
		ResultSet rs1 = st1.executeQuery();
		rs1.next();
		
		kvartalniIzvestaj.setPrvePosete(new StarosneKategorije(rs1.getInt(1)+rs1.getInt(2)+rs1.getInt(3),rs1.getInt(1),rs1.getInt(2),rs1.getInt(3)));
		
		PreparedStatement st2 = connection.prepareStatement("select \r\n" + 
				"sum(case when extract(year from age(current_date, datum_rodjenja)) < 7 then 1 else 0 end) as predskolsko,\r\n" + 
				"sum(case when extract(year from age(current_date, datum_rodjenja)) between 7 and 19 then 1 else 0 end) as omladina,\r\n" + 
				"sum(case when extract(year from age(current_date, datum_rodjenja)) > 19 then 1 else 0 end) as ostali\r\n" + 
				"from  izvrsena_intervencija i, pacijent p\r\n" + 
				"where i.pacijent = p.id\r\n" + 
				"and i.datum >= ? and i.datum <= ?;");
		st2.setDate(1, pocIntervala);
		st2.setDate(2, krajIntervala);
		ResultSet rs2 = st2.executeQuery();
		rs2.next();
		
		kvartalniIzvestaj.setPoseteUkupno(new StarosneKategorije(rs2.getInt(1)+rs2.getInt(2)+rs2.getInt(3),rs2.getInt(1),rs2.getInt(2),rs2.getInt(3)));
		kvartalniIzvestaj.setSerijskePosete(new StarosneKategorije(kvartalniIzvestaj.getPoseteUkupno().getUkupno() - kvartalniIzvestaj.getPrvePosete().getUkupno(),rs2.getInt(1) - rs1.getInt(1),rs2.getInt(2) - rs1.getInt(2),rs2.getInt(3) - rs1.getInt(3)));
		
		PreparedStatement st3 = connection.prepareStatement("select \r\n" + 
				"sum(case when extract(year from age(current_date, datum_rodjenja)) < 7 then 1 else 0 end) as predskolsko,\r\n" + 
				"sum(case when extract(year from age(current_date, datum_rodjenja)) between 7 and 19 then 1 else 0 end) as omladina,\r\n" + 
				"sum(case when extract(year from age(current_date, datum_rodjenja)) > 19 then 1 else 0 end) as ostali\r\n" + 
				"from  izvrsena_intervencija i, pacijent p, grupa_intervencija g, vrsta_intervencije v\r\n" + 
				"where i.pacijent = p.id\r\n" + 
				"and i.vrsta_intervencije = v.id\r\n" + 
				"and v.grupa_intervencija = g.id\r\n" + 
				"and g.id in (34,35,36)\r\n" + 
				"and i.datum >= ? and i.datum <= ?;");
		st3.setDate(1, pocIntervala);
		st3.setDate(2, krajIntervala);
		ResultSet rs3 = st3.executeQuery();
		rs3.next();
		
		
		kvartalniIzvestaj.setOrtodoncijaPrviPregledi(new StarosneKategorije(rs3.getInt(1)+rs3.getInt(2)+rs3.getInt(3),rs3.getInt(1),rs3.getInt(2),(rs3.getInt(3))));
		
		PreparedStatement st4 = connection.prepareStatement("select \r\n" + 
				"sum(case when extract(year from age(current_date, datum_rodjenja)) < 7 then 1 else 0 end) as predskolsko,\r\n" + 
				"sum(case when extract(year from age(current_date, datum_rodjenja)) between 7 and 19 then 1 else 0 end) as omladina,\r\n" + 
				"sum(case when extract(year from age(current_date, datum_rodjenja)) > 19 then 1 else 0 end) as ostali\r\n" + 
				"from vrsta_intervencije v, pacijent p, izvrsena_intervencija i, (select zub,pacijent from vrsta_intervencije v, izvrsena_intervencija i where v.grupa_intervencija = 37 and i.vrsta_intervencije = v.id) as plombirani\r\n" + 
				"where v.grupa_intervencija = 40\r\n" + 
				"and i.vrsta_intervencije = v.id\r\n" + 
				"and i.zub = plombirani.zub\r\n" + 
				"and i.pacijent = plombirani.pacijent\r\n" + 
				"and i.pacijent = p.id\r\n" +
				"and i.datum >= ? and i.datum <= ?;");
		st4.setDate(1, pocIntervala);
		st4.setDate(2, krajIntervala);
		ResultSet rs4 = st4.executeQuery();
		rs4.next();
		
		kvartalniIzvestaj.setPlombiraniZubiSaLecenjem(new StarosneKategorije(rs4.getInt(1)+rs4.getInt(2)+rs4.getInt(3),rs4.getInt(1),rs4.getInt(2),(rs4.getInt(3))));
		
		PreparedStatement st5 = connection.prepareStatement("select\r\n" + 
				"sum(case when extract(year from age(current_date, datum_rodjenja)) < 7 then 1 else 0 end) as predskolsko,\r\n" + 
				"sum(case when extract(year from age(current_date, datum_rodjenja)) between 7 and 19 then 1 else 0 end) as omladina, \r\n" + 
				"sum(case when extract(year from age(current_date, datum_rodjenja)) > 19 then 1 else 0 end) as ostali\r\n" + 
				"from vrsta_intervencije v, izvrsena_intervencija i,pacijent p \r\n" + 
				"where v.grupa_intervencija = 37 \r\n" + 
				"and i.pacijent = p.id\r\n" + 
				"and i.vrsta_intervencije = v.id\r\n" + 
				"and i.datum >= ? and i.datum <= ?;");
		st5.setDate(1, pocIntervala);
		st5.setDate(2, krajIntervala);
		ResultSet rs5 = st5.executeQuery();
		rs5.next();
		kvartalniIzvestaj.setPlombiraniZubiBezLecenja(new StarosneKategorije(rs5.getInt(1)+rs5.getInt(2)+rs5.getInt(3)-kvartalniIzvestaj.getPlombiraniZubiSaLecenjem().getUkupno(),rs5.getInt(1) - rs4.getInt(1),rs5.getInt(2)-rs4.getInt(2),rs5.getInt(3)-rs4.getInt(3)));
		rs.close();
		st.close();
		rs1.close();
		st1.close();
		rs2.close();
		st2.close();
		rs3.close();
		st3.close();
		
		rs4.close();
		st4.close();
		rs5.close();
		st5.close();
		connection.close();
		
		return kvartalniIzvestaj;
	}

}
