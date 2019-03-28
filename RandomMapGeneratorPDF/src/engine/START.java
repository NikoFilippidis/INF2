 package engine;

import java.io.BufferedReader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

import karte.Karte;
import karte.erde.feldarten.*;

public class START {
	
	public static Karte k = null;
	public static Document document = new Document();
	
	
	public static void main(String[] args) throws IOException {
		 new Engine();

		//console
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int maplength = 0;
		int maphight = 0;
		int wahl = 0;
		System.out.println("Das ist ein Zufallskartengenerator");
		System.out.println("");
		System.out.println("Es sind nur Werte von 80 bis 120 zugelassen!");
		while(maplength < 80 || maplength > 120){
		try{
			System.out.println("Geben Sie die Breite der Karte ein:");
		
		maplength = Integer.valueOf(br.readLine());
		if(maplength < 1 || maplength > 999999){
			 throw new Exception("");
		 }
		}
		catch(Exception e){
			System.err.println("\nEs duerfen nur zahlen zwischen 80 und 120 eingegeben werden");
			System.out.println("");
		}
		}
		while(maphight < 1 || maphight > 999999){
		System.out.print("Geben Sie die Hoehe der Karte ein:");
		try{
		 maphight = Integer.valueOf(br.readLine());
		 if(maphight < 1 || maphight > 99999){
			 throw new Exception("");
		 }
			}
			catch(Exception e){
				System.err.println("Es duerfen nur zahlen zwischen 80 und 120 eingegeben werden");
			}
		}
		
		
		System.out.println("waehlen sie eine der folgenden Kartenarten");
		System.out.println("1: Inseln");
		System.out.println("2: Kontinente");
		System.out.println("3: Pangaea");
		System.out.println("4: Seen");
		System.out.println("5: Spiegeln");
		
		while(wahl < 1 || wahl > 5){
		try{
		 wahl = Integer.valueOf(br.readLine());
		 if(wahl < 1 || wahl > 5){
			 throw new Exception("");
		 }
			}
			catch(Exception e){
				System.err.println("ungueltige Eingabe");
			}
		}
//		int maphight=2000;
//		int maplength = 2000;
		
		//mapSize
		Parameter.spielfeldAnzahlX = (byte)maplength;
		Parameter.spielfeldAnzahlY = (byte)maphight;
		//createMap
		//Karte k = new Karte(1,GeneratorSeen.Erde,null);
		
		k = GeneratorSeen.generateSeen();
		
		
		
		switch(wahl){
		case 1:
			k = generatorinsel.generateinsel();
			break;
		case 2:
			k = GeneratorKontinente2.generateinsel();
			break;
		case 3:
			k = GeneratorPangaea2.generatePangaea();
			break;
		case 4:
			k = GeneratorSeen.generateSeen();
			break;
		case 5:
			k = GeneratorSpiegeln.generateinsel();
		}
		

		Dateizugriff dz = new Dateizugriff();
		dz.speichernKarte(k,"randomMap.map");
		
		pdfGenerieren();
	}
	
	private static void pdfGenerieren(){

		Rectangle rect = new Rectangle(Parameter.spielfeldAnzahlX*10,Parameter.spielfeldAnzahlY*10);
		document.setPageSize(rect);
		try {
			PdfWriter.getInstance(document, new FileOutputStream("Map.pdf"));
			document.open();

			//Felder in PDF zeichnen
			for (int i = 1; i <= Parameter.spielfeldAnzahlX; i++) {
				for (int j = 1; j <= Parameter.spielfeldAnzahlY; j++) {
					if (k.getFelder()[i][j] instanceof Berg) {
						setFeld(i,j,"berg");
					}else if(k.getFelder()[i][j] instanceof Dschungel) {
						setFeld(i,j,"dschungel");
					}else if(k.getFelder()[i][j] instanceof Eis) {
						setFeld(i,j,"eis");
					}else if(k.getFelder()[i][j] instanceof Huegel) {
						setFeld(i,j,"huegel");
					}else if(k.getFelder()[i][j] instanceof Kueste) {
						setFeld(i,j,"kueste");
					}else if(k.getFelder()[i][j] instanceof Meer) {
						setFeld(i,j,"meer");
					}else if(k.getFelder()[i][j] instanceof Steppe) {
						setFeld(i,j,"steppe");
					}else if(k.getFelder()[i][j] instanceof Sumpf) {
						setFeld(i,j,"sumpf");
					}else if(k.getFelder()[i][j] instanceof Wald) {
						setFeld(i,j,"wald");
					}else if(k.getFelder()[i][j] instanceof Wiese) {
						setFeld(i,j,"wiese");
					}else if(k.getFelder()[i][j] instanceof Wueste) {
						setFeld(i,j,"wueste");
					}
					if(k.getFelder()[i][j].getSpielerstart()>0&&k.getFelder()[i][j].getSpielerstart()<=4) {
//						System.out.println("Spieler Nr. : "+k.getFelder()[i][j].getSpielerstart()+" gefunden ");
						setSpieler(i,j,k.getFelder()[i][j].getSpielerstart());
					}
					if (k.getFelder()[i][j].getResource() != null) {
						String resource = ""+k.getFelder()[i][j].getResource();
						String s="";
						String[] a=resource.split("");
						a[1].toLowerCase();
						//Grossbuchstaben in kleine Buchstaben wandeln
						for(char c : resource.toCharArray()){   
				        	if(Character.isUpperCase(c)){
				        		s = s+a[1].toLowerCase();
				        	}	
				        }
						for (int k = 2; k < a.length; k++) {
							if (a[k]!=null) {
								s = s+a[k];
							}
								
						}
						//Resourcen zeichnen
						Image img=null;
						img= Image.getInstance("resources//resourcenarten//"+s+".png");
						img.scaleAbsolute(5,5);
						img.setAbsolutePosition(i*10-5, Parameter.spielfeldAnzahlY*10-(j*10-5));
						document.add(img);
					}
				}
			}	        
			document.close();
			System.out.println("Karte wurde als PDF gespeichert");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private static void setSpieler(int i, int j, int spielerPos) {
		String spielerNummer = "";
		Image img = null;
		try {
				if (spielerPos==1) {
					spielerNummer ="1";
				}else if(spielerPos==2){
					spielerNummer ="2";
				}else if(spielerPos==3){
					spielerNummer ="3";
				}else if(spielerPos==4){
					spielerNummer ="4";
				}
				
				img= Image.getInstance("spieler"+spielerNummer+".png");
				img.scaleAbsolute(10,10);
				img.setAbsolutePosition(i*10-5, Parameter.spielfeldAnzahlY*10-(j*10-5));
				document.add(img);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void setFeld(int i, int j, String FeldArt) {
		
		try {
			if (i==1) {
				Image img= Image.getInstance("resources//feldarten//erde//"+FeldArt+".jpg");
				img.scaleAbsolute(10,10);
				img.setAbsolutePosition(i,Parameter.spielfeldAnzahlY*10-(j*10));
				document.add(img);
			
			}else{
				Image img= Image.getInstance("resources//feldarten//erde//"+FeldArt+".jpg");
				img.scaleAbsolute(10,10);
				img.setAbsolutePosition(i*10-10,Parameter.spielfeldAnzahlY*10-(j*10));
				document.add(img);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}