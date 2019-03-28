 package engine;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.annotation.Generated;

import karte.Karte;
import karte.erde.feldarten.Eis;
import karte.erde.feldarten.Kueste;
import karte.erde.feldarten.Meer;
import karte.erde.feldarten.Steppe;
import karte.erde.feldarten.Wueste;

import org.junit.Ignore;
import org.junit.Test;

public class GeneratorPangaeaTest {

		
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
		Karte k = GeneratorPangaea2.generatePangaea();
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
							& !(k.getFelder()[i - 1][j] instanceof Steppe)
							& !(k.getFelder()[i - 1][j] instanceof Wueste))
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
		Karte k = GeneratorPangaea2.generatePangaea();
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
	public void istKuesteUmPangaeaUndEis() {
		Parameter.spielfeldAnzahlX = (byte)80;
		Parameter.spielfeldAnzahlY = (byte)80;
		Karte k = GeneratorPangaea2.generatePangaea();
		boolean istKuesteUmSee=false;
		boolean linksOben = false,rechtsOben = false,linksUnten = false,rechtsUnten=false;
		for (int i = 2; i <= Parameter.spielfeldAnzahlX-1 ; i++) {
			for (int j = 2; j <= Parameter.spielfeldAnzahlY-1; j++) {
				if (k.getFelder()[i][j] instanceof Kueste) {
						if (!(k.getFelder()[i-1][j-1] instanceof Meer)&&!(k.getFelder()[i-1][j-1] instanceof Eis)&&!(k.getFelder()[i-1][j-1] instanceof Kueste)&&!(k.getFelder()[i-1][j-1] instanceof Wueste)&&!(k.getFelder()[i-1][j-1] instanceof Steppe)) {
							linksOben=false;
						}else
							linksOben=true;
						if (!(k.getFelder()[i+1][j-1] instanceof Meer)&&!(k.getFelder()[i+1][j-1] instanceof Eis)&&!(k.getFelder()[i+1][j-1] instanceof Kueste)&&!(k.getFelder()[i+1][j-1] instanceof Wueste)&&!(k.getFelder()[i+1][j-1] instanceof Steppe)) {
							rechtsOben=false;
						}else
							rechtsOben=true;
						if (!(k.getFelder()[i-1][j+1] instanceof Meer)&&!(k.getFelder()[i-1][j+1] instanceof Eis)&&!(k.getFelder()[i-1][j+1] instanceof Kueste)&&!(k.getFelder()[i-1][j+1] instanceof Wueste)&&!(k.getFelder()[i-1][j+1] instanceof Steppe)) {	
							linksUnten=false;
						}else
							linksUnten=true;
						if (!(k.getFelder()[i+1][j+1] instanceof Meer)&&!(k.getFelder()[i+1][j+1] instanceof Eis)&&!(k.getFelder()[i+1][j+1] instanceof Kueste)&&!(k.getFelder()[i+1][j+1] instanceof Wueste)&&!(k.getFelder()[i+1][j+1] instanceof Steppe)){
							rechtsUnten=false;
						}else
							rechtsUnten=true;
						if (!(linksOben||rechtsOben||linksUnten||rechtsUnten)) {
							fail();
						}
						else
							istKuesteUmSee=true;
					
				}
			}
		}
		assertTrue(istKuesteUmSee);
	}	
	
	@Test
	public void istMindesgroessePangaeaEreicht(){
		int groesse = 0;
		Parameter.spielfeldAnzahlX = (byte)80;
		Parameter.spielfeldAnzahlY = (byte)80;
		Karte k = GeneratorPangaea2.generatePangaea();
		for (int i = 1; i <= Parameter.spielfeldAnzahlX; i++) {
			for (int j = 2; j <= Parameter.spielfeldAnzahlY - 1; j++) {
				if (!(k.getFelder()[i][j] instanceof Kueste)
						& !(k.getFelder()[i][j] instanceof Meer)
						& !(k.getFelder()[i][j] instanceof Eis))
					groesse++;
			}
		}
		 assertTrue(groesse > ((80 * 80)*0.25)); 	  
	}
	
	@Test
	public void sindWaleImMeer() throws IOException {
		BufferedReader br = null;
		String s = "0";
		String[] split;
		boolean waleExestierenInMeer = false;
		int counter = 0;
		try {
			br = new BufferedReader(new FileReader("randomMap.map"));
		} catch (Exception e) {
		}
		while (s != null) {

			s = br.readLine();
			if (counter > 3 && s != null) {
				split = s.split(";");
				if (!(split[3].equals("Wal")))
					waleExestierenInMeer = true;
			}

			counter++;
		}
		assertTrue(waleExestierenInMeer);
	}
		
	@Test
	public void richtigeAnzahlSpieler(){
		
		Parameter.spielfeldAnzahlX = (byte)60;
		Parameter.spielfeldAnzahlY = (byte)60;
		int counter = 0;
		Karte k = generatorinsel.generateinsel();
		for (int i = 1; i <= Parameter.spielfeldAnzahlX ; i++) {
			for (int j = 1; j <= Parameter.spielfeldAnzahlY; j++) {
				if (!(k.getFelder()[i][j] instanceof Meer)&&!(k.getFelder()[i][j] instanceof Kueste)) {
					if(k.getFelder()[i][j].getSpielerstart()>1&&k.getFelder()[i][j].getSpielerstart()<=4)
						counter++;
				}
				
		
			}
		}
		assertTrue(counter>1&& counter<=4);
	}
	
	
}

