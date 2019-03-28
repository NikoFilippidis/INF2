package engine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import karte.Feld;
import karte.Karte;
import karte.KartenArt;
import karte.Position;
import karte.ResourcenArt;

public class Dateizugriff implements DateiInterface{

	public void ladenKarte(Object o, String datei) {
		Engine en=(Engine)o;
	  if (!datei.endsWith(".map")) datei=datei+".map";
		en.removeKarte();
  	BufferedReader br=null;
	  try {
	  	br=new BufferedReader(new FileReader(datei));
	  	String karteIdString=br.readLine();
	  	String karteArtString=br.readLine();
	  	KartenArt kArt=KartenArt.vonString(karteArtString);
			Parameter.spielfeldAnzahlX=Byte.parseByte(br.readLine());
			Parameter.spielfeldAnzahlY=Byte.parseByte(br.readLine());
			Karte k=new Karte(Byte.parseByte(karteIdString),kArt,en);
			en.setKarte(k);
			k.initDarstellung(en.getPanel());
	  	for(int i=1;i<=Parameter.spielfeldAnzahlX;i++){
	  		for(int j=1;j<=Parameter.spielfeldAnzahlY;j++){
	  			String datensatz=br.readLine();
	  			if ((datensatz==null)||(datensatz.length()==0)) continue;
	  			String[] daten=datensatz.split(";");
	  			if ((daten==null)||(daten.length!=5)) continue;	
	  			Feld f=KartenArt.getFeld(kArt,daten[2]);
	  			f.setKarte(k);
	  			f.setPosition(new Position(Byte.parseByte(daten[0]),Byte.parseByte(daten[1])));
	  			if ((daten[3]==null)||(daten[3].length()==0))
	  				f.setResource(null);
	  			else
	  				f.setResource(ResourcenArt.getResource(daten[3]));
	  			f.setSpielerstart(Byte.parseByte(daten[4]));
	  			k.initFeld(f);
		  	}
	  	}
	  	en.aktiviereMenu();
	  	en.getKarte().zeichneFelder();
			en.validate();
	  	en.repaint();
			en.log("OK. Die geladene Karte ist "+Parameter.spielfeldAnzahlX+" Felder breit und "+Parameter.spielfeldAnzahlY+" Felder hoch.");
		} catch (Exception e) {
			en.log("FEHLER: "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				br.close();
			} catch (IOException e) {}
		}
	}

	public void speichernKarte(Object o, String datei) {
		Karte en=(Karte)o;
		if (en==null){
			System.out.println("ABBRUCH: Keine Karte vorhanden!");
			return;
		}
	  if (!datei.endsWith(".map")) datei=datei+".map";
  	BufferedWriter bw=null;
	  try {
	  	bw=new BufferedWriter(new FileWriter(datei));
	  	bw.write(""+en.getId());
	  	bw.newLine();
	  	bw.write(""+en.getArt());
	  	bw.newLine();
	  	bw.write(""+Parameter.spielfeldAnzahlX);
	  	bw.newLine();
	  	bw.write(""+Parameter.spielfeldAnzahlY);
	  	bw.newLine();
	  	Feld[][] felder=en.getFelder();
	   	for(int i=0;i<felder.length;i++){
	  		for(int j=0;j<felder[0].length;j++){
		  		Feld f=felder[i][j];
		  		if (f==null) continue;
		  		String s="";
		  		s+=i+";";
		  		s+=j+";";
		  		s+=f.getArt()+";";
		  		if(f.getResource()==null)
			  		s+=";";		  			
		  		else
			  		s+=f.getResource().getArt()+";";
		  		s+=f.getSpielerstart();
			  	bw.write(s);
			  	bw.newLine();
	  		}
	   	}
	  	System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FEHLER: "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				bw.close();
			} catch (IOException e) {}
		}
	}
}
