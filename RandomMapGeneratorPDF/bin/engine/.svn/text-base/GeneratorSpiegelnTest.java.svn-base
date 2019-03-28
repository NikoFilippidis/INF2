package engine;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import karte.Karte;
import karte.erde.feldarten.Eis;
import karte.erde.feldarten.Kueste;
import karte.erde.feldarten.Meer;
import karte.erde.feldarten.Steppe;
import karte.erde.feldarten.Wueste;

import org.junit.Ignore;
import org.junit.Test;

public class GeneratorSpiegelnTest {

	@Test
	public void sindAllesFlaechenBelegt()throws IOException {
		 BufferedReader br=null;
		  String s="0";
		  String[] split;
		  int counter = 0 ;
		  try{
		  br=new BufferedReader(new FileReader("randomMap.map"));
		  }
		  catch(Exception e){
		  }
		  while (s!=null) {
		   s = br.readLine();
		   if (counter>3&&s!=null) {
		    split = s.split(";");
		    if(split[2] == null){
		    	 fail();
		    }
		  counter++;
		  }
		   counter = counter - 5;
		  }
		 assertTrue(true); 	  
	}
	
	@Test
	public void eisWueste30Prozent() throws IOException {
		BufferedReader br = null;
		String s = "0";
		String[] split;
		int counter = 0;
		int felderEisCounter = 0;
		try {
			br = new BufferedReader(new FileReader("randomMap.map"));
		} catch (Exception e) {
		}

		while (s != null) {

			s = br.readLine();
			if (counter > 3 && s != null) {
				split = s.split(";");
				System.out.println(split[2]);
				if (split[2].equals("Wueste"))
					felderEisCounter++;
			}
			counter++;
		}
		System.out.println(counter);
		int ist30Prozent = (int) ((int) (counter - 5) * 0.3);
		assertTrue(ist30Prozent >= felderEisCounter);
	}

	@Test
	public void eisMax20Prozent() throws IOException {
		BufferedReader br = null;
		String s = "0";
		String[] split;
		int counter = 0;
		int felderEisCounter = 0;
		try {
			br = new BufferedReader(new FileReader("randomMap.map"));
		} catch (Exception e) {
		}

		while (s != null) {

			s = br.readLine();
			if (counter > 3 && s != null) {
				split = s.split(";");
				System.out.println(split[2]);
				if (split[2].equals("Eis"))
					felderEisCounter++;
			}
			counter++;
		}
		System.out.println(counter);
		int ist20Prozent = (int) ((int) (counter - 5) * 0.2);
		System.out.println("ist20%: " + ist20Prozent);
		System.out.println("Anzahl Eis: " + felderEisCounter);
		assertTrue(ist20Prozent >= felderEisCounter);
	}

	@Test
	public void sindResourcenGesetzt() throws IOException {
		BufferedReader br = null;
		String s = "0";
		String[] split;
		boolean sindGesetzt = false;
		int counter = 0;
		try {
			br = new BufferedReader(new FileReader("randomMap.map"));
		} catch (Exception e) {
		}
		while (s != null) {

			s = br.readLine();
			if (counter > 3 && s != null) {
				split = s.split(";");
				if (!(split[3].equals("")))
					sindGesetzt = true;
			}

			counter++;
		}
		assertTrue(sindGesetzt);
	}

	@Test
	public void istUmWuesteSteppeoderKueste() {
		Parameter.spielfeldAnzahlX = (byte)80;
		Parameter.spielfeldAnzahlY = (byte)80;
		Karte k = GeneratorSpiegeln.generateinsel();
		for (int i = 2; i <= Parameter.spielfeldAnzahlX - 2; i++) {
			for (int j = 11; j <= Parameter.spielfeldAnzahlY - 10; j++) {
				if (k.getFelder()[i][j] instanceof Wueste) {
					if (!(k.getFelder()[i][j + 1] instanceof Kueste)
							& !(k.getFelder()[i][j + 1] instanceof Steppe)
							& !(k.getFelder()[i][j + 1] instanceof Wueste))
						fail();
					if (!(k.getFelder()[i][j - 1] instanceof Kueste)
							& !(k.getFelder()[i][j - 1] instanceof Steppe)
							& !(k.getFelder()[i][j - 1] instanceof Wueste))
						fail();
					if (!(k.getFelder()[i + 1][j] instanceof Kueste)
							& !(k.getFelder()[i + 1][j] instanceof Steppe)
							& !(k.getFelder()[i + 1][j] instanceof Wueste))
						fail();
					if (!(k.getFelder()[i - 1][j - 1] instanceof Kueste)
							& !(k.getFelder()[i - 1][j - 1] instanceof Steppe)
							& !(k.getFelder()[i - 1][j - 1] instanceof Wueste))
						fail();
					if (!(k.getFelder()[i + 1][j - 1] instanceof Kueste)
							& !(k.getFelder()[i + 1][j - 1] instanceof Steppe)
							& !(k.getFelder()[i + 1][j - 1] instanceof Wueste))
						fail();
					if (!(k.getFelder()[i - 1][j + 1] instanceof Kueste)
							& !(k.getFelder()[i - 1][j + 1] instanceof Steppe)
							& !(k.getFelder()[i - 1][j + 1] instanceof Wueste))
						fail();
					if (!(k.getFelder()[i + 1][j + 1] instanceof Kueste)
							& !(k.getFelder()[i + 1][j + 1] instanceof Steppe)
							& !(k.getFelder()[i + 1][j + 1] instanceof Wueste))
						fail();
				}
			}
		}
		assertTrue(true);
	}
	
	@Test
	public void istUmEisSteppeoderKueste() {
		Parameter.spielfeldAnzahlX = (byte)80;
		Parameter.spielfeldAnzahlY = (byte)80;
		Karte k = GeneratorSpiegeln.generateinsel();
		for (int i = 2; i <= Parameter.spielfeldAnzahlX - 2; i++) {
			for (int j = 11; j <= Parameter.spielfeldAnzahlY - 10; j++) {
				if (k.getFelder()[i][j] instanceof Eis) {
					if (!(k.getFelder()[i][j + 1] instanceof Kueste)
							& !(k.getFelder()[i][j + 1] instanceof Steppe)
							& !(k.getFelder()[i][j + 1] instanceof Eis))
						fail();
					if (!(k.getFelder()[i][j - 1] instanceof Kueste)
							& !(k.getFelder()[i][j - 1] instanceof Steppe)
							& !(k.getFelder()[i][j - 1] instanceof Eis))
						fail();
					if (!(k.getFelder()[i + 1][j] instanceof Kueste)
							& !(k.getFelder()[i + 1][j] instanceof Steppe)
							& !(k.getFelder()[i + 1][j] instanceof Eis))
						fail();
					if (!(k.getFelder()[i - 1][j - 1] instanceof Kueste)
							& !(k.getFelder()[i - 1][j] instanceof Steppe)
							& !(k.getFelder()[i - 1][j] instanceof Eis))
						fail();

					if (!(k.getFelder()[i - 1][j - 1] instanceof Kueste)
							& !(k.getFelder()[i - 1][j - 1] instanceof Steppe)
							& !(k.getFelder()[i - 1][j - 1] instanceof Eis))
						fail();
					if (!(k.getFelder()[i + 1][j - 1] instanceof Kueste)
							& !(k.getFelder()[i + 1][j - 1] instanceof Steppe)
							& !(k.getFelder()[i + 1][j - 1] instanceof Eis))
						fail();
					if (!(k.getFelder()[i - 1][j + 1] instanceof Kueste)
							& !(k.getFelder()[i - 1][j + 1] instanceof Steppe)
							& !(k.getFelder()[i - 1][j + 1] instanceof Eis))
						fail();
					if (!(k.getFelder()[i + 1][j + 1] instanceof Kueste)
							& !(k.getFelder()[i + 1][j + 1] instanceof Steppe)
							& !(k.getFelder()[i + 1][j + 1] instanceof Eis))
						fail();
				}
			}
		}
		assertTrue(true);
	}
	
	@Test
	public void istGrenzeGezeichnet() {
		Parameter.spielfeldAnzahlX = (byte)80;
		Parameter.spielfeldAnzahlY = (byte)80;
		Karte k = GeneratorSpiegeln.generateinsel();
		boolean istGrenzeGezeichnetY=false;
		boolean istGrenzeGezeichnetX=false;
		//Y-Parallele
		for (int i = Parameter.spielfeldAnzahlX/2-1; i <=Parameter.spielfeldAnzahlX/2+1 ; i++) {
			for (int j = 1; j <= Parameter.spielfeldAnzahlY; j++) {
				if (k.getFelder()[i][j] instanceof Kueste) {
					istGrenzeGezeichnetY=true;
				}
			}
		}
		//Y-Parallele
		for (int i = Parameter.spielfeldAnzahlY/2-1; i <=Parameter.spielfeldAnzahlY/2+1 ; i++) {
			for (int j = 1; j <= Parameter.spielfeldAnzahlX; j++) {
				if (k.getFelder()[j][i] instanceof Kueste) {
					istGrenzeGezeichnetX=true;
				}
			}
		}
		assertTrue(istGrenzeGezeichnetY&&istGrenzeGezeichnetX);
	}
	@Test
	public void istgespiegelt(){
		Parameter.spielfeldAnzahlX = (byte)80;
		Parameter.spielfeldAnzahlY = (byte)80;
		Karte k = GeneratorSpiegeln.generateinsel();
		for(int i = 1; i <= Parameter.spielfeldAnzahlX; i++){
			for(int j = 1; j <= (Parameter.spielfeldAnzahlY / 2) - 1; j++){
				if(i == Parameter.spielfeldAnzahlX / 2){
					i++; i++;
				}
				if(k.getFelder()[i][j] == k.getFelder()[i][Parameter.spielfeldAnzahlY - j + 1]){
					assertTrue(true);
				}
				else{
					assertTrue(false);
				}
				
			}
		}
		
	} 

}

