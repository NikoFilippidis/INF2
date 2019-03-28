package engine;

import java.util.Random;

import karte.Karte;
import karte.KartenArt;
import karte.erde.feldarten.*;
import karte.resourcenarten.*;

public class GeneratorKontinente2 {
	// wird berrechnet wieviele zeilen eis maximal gesetzt werden d�rfen. oben
	// und unten deshalb /2
	static int maxeis = (int) (Parameter.spielfeldAnzahlX
			* Parameter.spielfeldAnzahlY * 0.1 / Parameter.spielfeldAnzahlX);
	static Random r = new Random();
	static int wuesteXYAusschlagMax = (int) ((Parameter.spielfeldAnzahlX
			* Parameter.spielfeldAnzahlY * 0.1) / Parameter.spielfeldAnzahlX);
	static int WuesteGrenzeLinksX = r.nextInt(2) + 2;
	static int WuesteGrenzeRechtsX = Parameter.spielfeldAnzahlX
			- (r.nextInt(2) + 2);
	static int wuesteAusschlagUnten = r.nextInt(wuesteXYAusschlagMax);
	static int wuesteAusschlagOben = r.nextInt(wuesteXYAusschlagMax);

	static Random randomZahl = new Random();
	
	static int zehntelallFelderDurchX = (int) ((Parameter.spielfeldAnzahlX
			* Parameter.spielfeldAnzahlY * 0.1) / Parameter.spielfeldAnzahlX);
	static int dreißigProzentGesamt = (int) ((Parameter.spielfeldAnzahlX
			* Parameter.spielfeldAnzahlY * 0.3));
	static int maxSteppe = (int) ((Parameter.spielfeldAnzahlX
			* Parameter.spielfeldAnzahlY * 0.1) / Parameter.spielfeldAnzahlX);
	static int randomZahlOben = randomZahl.nextInt(zehntelallFelderDurchX) + 1; 
	static int randomZahlUnten = randomZahl.nextInt(zehntelallFelderDurchX) + 1;

	static int inselanzahl = ((Parameter.spielfeldAnzahlX + Parameter.spielfeldAnzahlY) / 2) / 10;
	static int[] x;
	static int[] y;
	static int[] randomrechts;
	static int[] randomlinks;
	static int[] randomunten;
	static int[] randomoben;
	static boolean kontinente=true;
	public static Karte generateinsel() {
		// karte mit meer wird gesetzt
		Karte k = new Karte(1, KartenArt.Erde, null);
		for (int i = 1; i <= Parameter.spielfeldAnzahlX; i++) {
			for (int j = 2; j <= Parameter.spielfeldAnzahlY - 1; j++) {
				k.getFelder()[i][j] = new Meer();
			}
		}
		pole(k);
		inselgenerieren(k);
		wuestegenerieren(k);
		feldartensetzen(k);
		setRessourcen(k);
		diagonalenFuellerWueste(k);
		seenDiagonaleKorrektur(k);
		spielersetzen(k);
		return k;
	}
	private static void diagonalenFuellerWueste(Karte k) {
		for (int i = 2; i <= Parameter.spielfeldAnzahlX-1; i++) {
			for (int j = 2; j <= Parameter.spielfeldAnzahlY-1; j++) {
				 if (k.getFelder()[i][j] instanceof Meer) {
					if (!(k.getFelder()[i-1][j-1] instanceof Meer)&&!(k.getFelder()[i-1][j-1] instanceof Kueste)&&!(k.getFelder()[i-1][j-1] instanceof Steppe)) {
						k.getFelder()[i-1][j-1] = new Kueste();
					}
					if (!(k.getFelder()[i+1][j-1] instanceof Meer)&&!(k.getFelder()[i+1][j-1] instanceof Kueste)&&!(k.getFelder()[i-1][j-1] instanceof Steppe)) {
						k.getFelder()[i+1][j-1] = new Kueste();
					}
					if (!(k.getFelder()[i-1][j+1] instanceof Meer)&&!(k.getFelder()[i-1][j+1] instanceof Kueste)&&!(k.getFelder()[i-1][j-1] instanceof Steppe)) {
						k.getFelder()[i-1][j+1] = new Kueste();
					}
					if (!(k.getFelder()[i+1][j+1] instanceof Meer)&&!(k.getFelder()[i+1][j+1] instanceof Kueste)&&!(k.getFelder()[i-1][j-1] instanceof Steppe)) {
						k.getFelder()[i+1][j+1] = new Kueste();
					}
				}
			}
		}
	}
	
	private static void seenDiagonaleKorrektur(Karte k) {
		for (int i = 2; i <= Parameter.spielfeldAnzahlX-1; i++) {
			for (int j = 2; j <= Parameter.spielfeldAnzahlY-1; j++) {
				 if (k.getFelder()[i][j] instanceof Wueste) {
					if (!(k.getFelder()[i-1][j-1] instanceof Wueste)&&!(k.getFelder()[i-1][j-1] instanceof Kueste)&&!(k.getFelder()[i-1][j-1] instanceof Steppe)&&!(k.getFelder()[i-1][j-1] instanceof Meer)) {
						k.getFelder()[i-1][j-1] = new Steppe();
					}
					if (!(k.getFelder()[i+1][j-1] instanceof Wueste)&&!(k.getFelder()[i+1][j-1] instanceof Kueste)&&!(k.getFelder()[i+1][j-1] instanceof Steppe)&&!(k.getFelder()[i+1][j-1] instanceof Meer)) {
						k.getFelder()[i+1][j-1] = new Steppe();
					}
					if (!(k.getFelder()[i-1][j+1] instanceof Wueste)&&!(k.getFelder()[i-1][j+1] instanceof Kueste)&&!(k.getFelder()[i-1][j+1] instanceof Steppe)&&!(k.getFelder()[i-1][j+1] instanceof Meer)) {
						k.getFelder()[i-1][j+1] = new Steppe();
					}
					if (!(k.getFelder()[i+1][j+1] instanceof Wueste)&&!(k.getFelder()[i+1][j+1] instanceof Kueste)&&!(k.getFelder()[i+1][j+1] instanceof Steppe)&&!(k.getFelder()[i+1][j+1] instanceof Meer)) {
						k.getFelder()[i+1][j+1] = new Steppe();
					}
				}
			}
		}
	}
	
	private static void spielersetzen(Karte k) {
		for (int i = 1; i <= Parameter.spielfeldAnzahlX; i++) {
			for (int j = 1; j <= Parameter.spielfeldAnzahlY; j++) {
				k.getFelder()[i][j].setKarte(k);
			}
		}
		if(kontinente){
			k.getFelder()[x[0]][(y[0] - randomoben[0]) + (r.nextInt(5)+2)].setSpielerstart(1);
			k.getFelder()[x[0]][(y[0] + randomunten[0]) - (r.nextInt(5)+2)].setSpielerstart(2);
			k.getFelder()[x[1]][(y[1] - randomoben[1]) + (r.nextInt(5)+2)].setSpielerstart(3);
			k.getFelder()[x[1]][(y[1] + randomunten[1]) - (r.nextInt(5)+2)].setSpielerstart(4);
		/*	boolean nichtgesetzt = true;
			int xwertquartal1 = (int) (Parameter.spielfeldAnzahlX * 0.25);
			int ywertquartal1 = (int) (Parameter.spielfeldAnzahlY * 0.25);
			int xwertquartal2 = (int) (Parameter.spielfeldAnzahlX * 0.75);
			int ywertquartal2 = (int) (Parameter.spielfeldAnzahlY * 0.25);
			int xwertquartal3 = (int) (Parameter.spielfeldAnzahlX * 0.25);
			int ywertquartal3 = (int) (Parameter.spielfeldAnzahlY * 0.75);
			int xwertquartal4 = (int) (Parameter.spielfeldAnzahlX * 0.75);
			int ywertquartal4 = (int) (Parameter.spielfeldAnzahlY * 0.75);
			while(nichtgesetzt){
					if(!(k.getFelder()[xwertquartal1][ywertquartal1] instanceof Meer)
					&& !(k.getFelder()[xwertquartal2][ywertquartal2] instanceof Meer)
					&& !(k.getFelder()[xwertquartal3][ywertquartal3] instanceof Meer)
					&& !(k.getFelder()[xwertquartal4][ywertquartal4] instanceof Meer)
						){
							k.getFelder()[xwertquartal1][ywertquartal1].setSpielerstart(1);
							k.getFelder()[xwertquartal2][ywertquartal2].setSpielerstart(2);
							k.getFelder()[xwertquartal3][ywertquartal3].setSpielerstart(3);
							k.getFelder()[xwertquartal4][ywertquartal4].setSpielerstart(4);
							nichtgesetzt = false;
				}
					else{
						xwertquartal1++; ywertquartal1++; xwertquartal2--; ywertquartal2++;
						xwertquartal3++; ywertquartal3--; xwertquartal4--; ywertquartal4--;
					}
			}*/
		}
		else{ 
		if(inselanzahl >= 4){
		k.getFelder()[x[1]][y[1]].setSpielerstart(1);
		k.getFelder()[x[2]][y[2]].setSpielerstart(2);
		k.getFelder()[x[3]][y[3]].setSpielerstart(3);
		k.getFelder()[x[0]][y[0]].setSpielerstart(4);
		}
		if(inselanzahl == 3){
			k.getFelder()[x[1]][y[1]].setSpielerstart(1);
			k.getFelder()[x[2]][y[2]].setSpielerstart(2);
			k.getFelder()[x[0]][y[0]].setSpielerstart(3);
		}
		if(inselanzahl == 2){
			k.getFelder()[x[1]][y[1]].setSpielerstart(1);
			k.getFelder()[x[0]][y[0]].setSpielerstart(2);
		}
		}
/*																			//f�r euch !!! ja gut die oberen 2 
 * 																			for schleifen braucht ihr auch noch
 * 																			f�r pangea m�ssen noch randwerte ge�ndert werden
 * 																			und eine randomzahl generiert werden, um damit so und so viele felder in pangea reinzugehen
		*/
		
	}

	private static void setRessourcen(Karte k) {
			for (int i = 1; i <= Parameter.spielfeldAnzahlX; i++) {
				for (int j = 1; j <= Parameter.spielfeldAnzahlY; j++) {				
					if(j == 1) j  = r.nextInt(20);
					switch(ermittleFeldTyp(k,i,j)){
					case 0: 
						setRessourcenAufBerg(k,i,j);
						break;
					case 1:
						setRessourcenAufDschungel(k,i,j);
						break;
					case 2:
						setRessourcenAufEis(k,i,j);
						break;
					case 3:
						setRessourcenAufHuegel(k,i,j);
						break;
					case 4:
						setRessourcenAufKueste(k,i,j);
						break;
					case 5:
						setRessourcenAufMeer(k,i,j);
						break;
					case 6:
						setRessourcenAufSteppe(k,i,j);
						break;
					case 7:
						setRessourcenAufSumpf(k,i,j);
						break;
					case 8:
						setRessourcenAufWald(k,i,j);
						break;
					case 9:
						setRessourcenAufWiese(k,i,j);
						break;
					case 10:
						setRessourcenAufWueste(k,i,j);
						break;
					}
					j += r.nextInt(zzz(1, 50));
				}
			}
		}
	private static int zzz(int a,int e){
		int zahl;
		do{
			zahl = r.nextInt(Parameter.spielfeldAnzahlY);
		}while(zahl < a || zahl > e);		
		return zahl;
	}

		private static void setRessourcenAufWueste(Karte k, int i, int j) {
			switch(r.nextInt(4)){
			case 0:
				k.getFelder()[i][j].setResource(new Oel());
				break;
			case 1:
				k.getFelder()[i][j].setResource(new Oase());
				break;
			case 2:
				k.getFelder()[i][j].setResource(new Salpeter());
				break;
			case 3:
				k.getFelder()[i][j].setResource(new Weihrauch());
				break;
			}
		}

		private static void setRessourcenAufWiese(Karte k, int i, int j) {
			switch(r.nextInt(5)){
			case 0:
				k.getFelder()[i][j].setResource(new Pferde());
				break;
			case 1:
				k.getFelder()[i][j].setResource(new Tabak());
				break;
			case 2:
				k.getFelder()[i][j].setResource(new Rinder());
				break;
			case 3:
				k.getFelder()[i][j].setResource(new Wein());
				break;
			case 4:
				k.getFelder()[i][j].setResource(new Weizen());
				break;
			}
		}

		private static void setRessourcenAufWald(Karte k, int i, int j) {
			switch(r.nextInt(7)){
			case 0:
				k.getFelder()[i][j].setResource(new Faerbemittel());
				break;
			case 1:
				k.getFelder()[i][j].setResource(new Gummi());
				break;
			case 2:
				k.getFelder()[i][j].setResource(new Gewuertz());
				break;
			case 3:
				k.getFelder()[i][j].setResource(new Pelz());
				break;
			case 4:
				k.getFelder()[i][j].setResource(new Seide());
				break;
			case 5:
				k.getFelder()[i][j].setResource(new Wild());
				break;
			case 6:
				k.getFelder()[i][j].setResource(new Uran());
				break;
			}		
		}

		private static void setRessourcenAufSumpf(Karte k, int i, int j) {
			switch(r.nextInt(3)){
			case 0:
				k.getFelder()[i][j].setResource(new Oel());
				break;
			case 1:
				k.getFelder()[i][j].setResource(new Gummi());
				break;
			case 2:
				k.getFelder()[i][j].setResource(new Wild());
				break;
			}
		}

		private static void setRessourcenAufSteppe(Karte k, int i, int j) {
			switch(r.nextInt(6)){
			case 0:
				k.getFelder()[i][j].setResource(new Oel());
				break;
			case 1:
				k.getFelder()[i][j].setResource(new Gummi());
				break;
			case 2:
				k.getFelder()[i][j].setResource(new Wild());
				break;
			case 3:
				k.getFelder()[i][j].setResource(new Wein());
				break;
			case 4:
				k.getFelder()[i][j].setResource(new Weizen());
				break;
			case 5:
				k.getFelder()[i][j].setResource(new Zucker());
				break;
			}		
		}

		private static void setRessourcenAufMeer(Karte k, int i, int j) {
			switch(r.nextInt(3)){
			case 0:
				k.getFelder()[i][j].setResource(new Fisch());
				break;
			case 1:
				k.getFelder()[i][j].setResource(new Oel());
				break;
			case 2:
				k.getFelder()[i][j].setResource(new Wal());
				break;

			}		
		}

		private static void setRessourcenAufKueste(Karte k, int i, int j) {
			switch(r.nextInt(2)){
			case 0:
				k.getFelder()[i][j].setResource(new Fisch());
				break;
			case 1:
				k.getFelder()[i][j].setResource(new Oel());
				break;
			}		
		}

		private static void setRessourcenAufHuegel(Karte k, int i, int j) {
			switch(r.nextInt(9)){
			case 0:
				k.getFelder()[i][j].setResource(new Aluminium());
				break;
			case 1:
				k.getFelder()[i][j].setResource(new Eisen());
				break;
			case 2:
				k.getFelder()[i][j].setResource(new Gold());
				break;
			case 3:
				k.getFelder()[i][j].setResource(new Kohle());
				break;
			case 4:
				k.getFelder()[i][j].setResource(new Salpeter());
				break;
			case 5:
				k.getFelder()[i][j].setResource(new Tabak());
				break;
			case 6:
				k.getFelder()[i][j].setResource(new Wein());
				break;
			case 7:
				k.getFelder()[i][j].setResource(new Weihrauch());
				break;
			case 8:
				k.getFelder()[i][j].setResource(new Zucker());
				break;
			}
			
		}

		private static void setRessourcenAufEis(Karte k, int i, int j) {
			switch(r.nextInt(4)){
			case 0:
				k.getFelder()[i][j].setResource(new Aluminium());
				break;
			case 1:
				k.getFelder()[i][j].setResource(new Oel());
				break;
			case 2:
				k.getFelder()[i][j].setResource(new Pelz());
				break;
			case 3:
				k.getFelder()[i][j].setResource(new Wild());
				break;
			}
			
		}

		private static void setRessourcenAufDschungel(Karte k, int i, int j) {
			switch(r.nextInt(7)){
			case 0:
				k.getFelder()[i][j].setResource(new Aluminium());
				break;
			case 1:
				k.getFelder()[i][j].setResource(new Edelsteine());
				break;
			case 2:
				k.getFelder()[i][j].setResource(new Eisen());
				break;
			case 3:
				k.getFelder()[i][j].setResource(new Gold());
				break;
			case 4:
				k.getFelder()[i][j].setResource(new Kohle());
				break;
			case 5:
				k.getFelder()[i][j].setResource(new Uran());
				break;
			case 6:
				k.getFelder()[i][j].setResource(new Wild());
				break;
			}
		}

		private static void setRessourcenAufBerg(Karte k, int i, int j) {
			switch(r.nextInt(6)){
			case 0:
				k.getFelder()[i][j].setResource(new Edelsteine());
				break;
			case 1:
				k.getFelder()[i][j].setResource(new Faerbemittel());
				break;
			case 2:
				k.getFelder()[i][j].setResource(new Gewuertz());
				break;
			case 3:
				k.getFelder()[i][j].setResource(new Gummi());
				break;
			case 4:
				k.getFelder()[i][j].setResource(new Kohle());
				break;
			case 5:
				k.getFelder()[i][j].setResource(new Obst());
				break;
			case 6:
				k.getFelder()[i][j].setResource(new Seide());
				break;
			}
		}

		private static int ermittleFeldTyp(Karte k,int x, int y) {
			if(k.getFelder()[x][y] instanceof Berg)
				return 0;
			if(k.getFelder()[x][y] instanceof Dschungel)
				return 1;
			if(k.getFelder()[x][y] instanceof Eis)
				return 2;
			if(k.getFelder()[x][y] instanceof Huegel)
				return 3;
			if(k.getFelder()[x][y] instanceof Kueste)
				return 4;
			if(k.getFelder()[x][y] instanceof Meer)
				return 5;
			if(k.getFelder()[x][y] instanceof Steppe)
				return 6;
			if(k.getFelder()[x][y] instanceof Sumpf)
				return 7;
			if(k.getFelder()[x][y] instanceof Wald)
				return 8;
			if(k.getFelder()[x][y] instanceof Wiese)
				return 9;
			if(k.getFelder()[x][y] instanceof Wueste)
				return 10;
			return -1;
		}

		

	private static void wuestegenerieren(Karte k) {
		/*WUESTE BALKEN UND UNTEN---------------------------------------------------*/
		
		// Zeichnet einen Wuestenbalken in der mit vom Spielfeld der
		for (int i = 1; i <= Parameter.spielfeldAnzahlX; i++) {
		if(k.getFelder()[i][Parameter.spielfeldAnzahlY / 2] == null){
		k.getFelder()[i][Parameter.spielfeldAnzahlY / 2] = new Wueste();
		}
		wuesteAusschlagUnten = wuesteAusschlagUnten + r.nextInt(3)-1;
		if (wuesteAusschlagUnten == 0)
			wuesteAusschlagUnten = 1;
		if (wuesteAusschlagUnten == wuesteXYAusschlagMax + 1) 
			wuesteAusschlagUnten = wuesteXYAusschlagMax;
		for (int j = 1; j <= wuesteAusschlagUnten; j++) {
			if(k.getFelder()[i][j +Parameter.spielfeldAnzahlY / 2] == null){
			k.getFelder()[i][j + Parameter.spielfeldAnzahlY / 2] = new Wueste();
			}
		}
		//Steppe auf Wueste unten zeichnen
		int steppeRandUnten = 1;
		for (int j = wuesteAusschlagUnten; j < steppeRandUnten
				+ wuesteAusschlagUnten; j++) {
			if(k.getFelder()[i][j + Parameter.spielfeldAnzahlY / 2 + 1] == null){
			k.getFelder()[i][j + Parameter.spielfeldAnzahlY / 2 + 1] = new Steppe();
			}
		}
		/*WUESTE BALKEN UND OBEN---------------------------------------------------*/
		
		// Wueste von Mitte nach oben zeichnen
		wuesteAusschlagOben = wuesteAusschlagOben + r.nextInt(3)-1;
		if (wuesteAusschlagOben == 0) 
			wuesteAusschlagOben = 1;
		if (wuesteAusschlagOben == wuesteXYAusschlagMax + 1)
			wuesteAusschlagOben = wuesteXYAusschlagMax;
		for (int j = 1; j <= wuesteAusschlagOben; j++) {
			if(k.getFelder()[i][Parameter.spielfeldAnzahlY / 2 -j] == null){
			k.getFelder()[i][Parameter.spielfeldAnzahlY / 2 - j] = new Wueste();
			}
		}
		// Steppe auf Wueste oben zeichnen
		int steppeRandOben = 1;
		for (int j = wuesteAusschlagOben; j < steppeRandOben
				+ wuesteAusschlagOben; j++) {
			if(k.getFelder()[i][(Parameter.spielfeldAnzahlY / 2) - 1 - j] == null){
			k.getFelder()[i][(Parameter.spielfeldAnzahlY / 2) - 1 - j] = new Steppe();
			}
		}
		}
	}

	/*
	 * private static void inselngenerieren(Karte k) { int maxgrosseinsel; if
	 * (Parameter.spielfeldAnzahlX + Parameter.spielfeldAnzahlY > 100)
	 * maxgrosseinsel = 15; if (Parameter.spielfeldAnzahlX +
	 * Parameter.spielfeldAnzahlY <= 100 && Parameter.spielfeldAnzahlX +
	 * Parameter.spielfeldAnzahlY >= 60) maxgrosseinsel = 10; else
	 * kleineinsel(k); }
	 */

	private static void feldartensetzen(Karte k) {
		  int zufall=0;
		  int zufallMuster=0;
		  for (int i = 1; i <= Parameter.spielfeldAnzahlX; i++) {
		   for (int j = 1; j < Parameter.spielfeldAnzahlY; j++) {
		    zufall = r.nextInt(6)+1;
		    zufallMuster = r.nextInt(6)+1;
		    if(k.getFelder()[i][j]==null){
		     switch (zufall) {
		     case 1:
		      //Berg
		    	 if (i<(Parameter.spielfeldAnzahlX-1)) {
		    		 //Es gibt 6 verschiedene Muster eines wird zufaellig gewaehlt
				      switch (zufallMuster) {
				      case 1:	
						if(k.getFelder()[i+1][j]==null&&k.getFelder()[i][j+1]==null&&k.getFelder()[i+1][j+1]==null){
					       k.getFelder()[i][j] = new Berg();
					       k.getFelder()[i+1][j]= new Berg();
					       k.getFelder()[i][j+1]= new Berg();
					       k.getFelder()[i+1][j+1]= new Berg();
					      }else
					       k.getFelder()[i][j] = new Wiese();
						break;
				      case 2:
				    	  if(k.getFelder()[i][j]==null&&k.getFelder()[i+1][j]==null&&k.getFelder()[i+1][j+1]==null){
				    		  k.getFelder()[i][j]= new Berg();
				    		  k.getFelder()[i+1][j]= new Berg();
				    		  k.getFelder()[i+1][j+1]= new Berg();
				    		  k.getFelder()[i][j+1]= new Huegel();
				    	  }else
				    		  k.getFelder()[i][j]= new Wiese();
				    	  break;
				      case 3:
				    	  if(k.getFelder()[i+1][j]==null&&k.getFelder()[i][j+1]==null&&k.getFelder()[i+1][j+1]==null){
				    		  k.getFelder()[i][j]= new Wiese();
				    		  k.getFelder()[i+1][j]= new Berg();
				    		  k.getFelder()[i+1][j+1]= new Berg();
				    		  k.getFelder()[i][j+1]= new Berg();
				    	  }else
				    		  k.getFelder()[i][j]= new Wiese();
				    	  break;
				      case 4:
				    	  if(k.getFelder()[i][j]==null&&k.getFelder()[i][j+1]==null&&k.getFelder()[i+1][j]==null){
				    		  k.getFelder()[i][j]= new Berg();
				    		  k.getFelder()[i][j+1]= new Berg();
				    		  k.getFelder()[i+1][j]= new Berg();
				    		  k.getFelder()[i+1][j+1]= new Huegel();
				    	  }else
				    		  k.getFelder()[i][j]= new Wiese();
				    	  break;
				      case 5:
				    	  if(k.getFelder()[i][j]==null&&k.getFelder()[i][j+1]==null){
				    		  k.getFelder()[i][j]= new Berg();
				    		  k.getFelder()[i][j+1]= new Berg();
				    	  }else
				    		  k.getFelder()[i][j]= new Wiese();
				    	  break;
				      case 6:
				    	  if(k.getFelder()[i][j]==null&&k.getFelder()[i+1][j]==null){
				    		  k.getFelder()[i][j]= new Berg();
				    		  k.getFelder()[i+1][j]= new Berg();
				    	  }else
				    		  k.getFelder()[i][j]= new Wiese();
				    	  break;		
				}
	 }
		    		 k.getFelder()[i][j] = new Wiese();
		      break;
		     case 2:
		      //Dschungel
				      if (i<(Parameter.spielfeldAnzahlX-1)) {
				    		 //Es gibt 6 verschiedene Muster eines wird zufaellig gewaehlt
						      switch (zufallMuster) {
						      case 1:	
								if(k.getFelder()[i+1][j]==null&&k.getFelder()[i][j+1]==null&&k.getFelder()[i+1][j+1]==null){
							       k.getFelder()[i][j] = new Dschungel();
							       k.getFelder()[i+1][j]= new Dschungel();
							       k.getFelder()[i][j+1]= new Dschungel();
							       k.getFelder()[i+1][j+1]= new Dschungel();
							      }else
							       k.getFelder()[i][j] = new Wiese();
								break;
						      case 2:
						    	  if(k.getFelder()[i][j]==null&&k.getFelder()[i+1][j]==null&&k.getFelder()[i+1][j+1]==null){
						    		  k.getFelder()[i][j]= new Dschungel();
						    		  k.getFelder()[i+1][j]= new Dschungel();
						    		  k.getFelder()[i+1][j+1]= new Dschungel();
						    		  k.getFelder()[i][j+1]= new Huegel();
						    	  }else
						    		  k.getFelder()[i][j]= new Wiese();
						    	  break;
						      case 3:
						    	  if(k.getFelder()[i+1][j]==null&&k.getFelder()[i][j+1]==null&&k.getFelder()[i+1][j+1]==null){
						    		  k.getFelder()[i][j]= new Wiese();
						    		  k.getFelder()[i+1][j]= new Dschungel();
						    		  k.getFelder()[i+1][j+1]= new Dschungel();
						    		  k.getFelder()[i][j+1]= new Dschungel();
						    	  }else
						    		  k.getFelder()[i][j]= new Wiese();
						    	  break;
						      case 4:
						    	  if(k.getFelder()[i][j]==null&&k.getFelder()[i][j+1]==null&&k.getFelder()[i+1][j]==null){
						    		  k.getFelder()[i][j]= new Dschungel();
						    		  k.getFelder()[i][j+1]= new Dschungel();
						    		  k.getFelder()[i+1][j]= new Dschungel();
						    		  k.getFelder()[i+1][j+1]= new Huegel();
						    	  }else
						    		  k.getFelder()[i][j]= new Wiese();
						    	  break;
						      case 5:
						    	  if(k.getFelder()[i][j]==null&&k.getFelder()[i][j+1]==null){
						    		  k.getFelder()[i][j]= new Dschungel();
						    		  k.getFelder()[i][j+1]= new Dschungel();
						    	  }else
						    		  k.getFelder()[i][j]= new Wiese();
						    	  break;
						      case 6:
						    	  if(k.getFelder()[i][j]==null&&k.getFelder()[i+1][j]==null){
						    		  k.getFelder()[i][j]= new Dschungel();
						    		  k.getFelder()[i+1][j]= new Dschungel();
						    	  }else
						    		  k.getFelder()[i][j]= new Wiese();
						    	  break;		
						}
				    	 }
				    	 k.getFelder()[i][j] = new Wiese();
		      break;
		     case 3:
		    	 //Wald
			      if (i<(Parameter.spielfeldAnzahlX-1)) {
			    		 //Es gibt 6 verschiedene Muster eines wird zufaellig gewaehlt
					      switch (zufallMuster) {
					      case 1:	
							if(k.getFelder()[i+1][j]==null&&k.getFelder()[i][j+1]==null&&k.getFelder()[i+1][j+1]==null){
						       k.getFelder()[i][j] = new Wald();
						       k.getFelder()[i+1][j]= new Wald();
						       k.getFelder()[i][j+1]= new Wald();
						       k.getFelder()[i+1][j+1]= new Wald();
						      }else
						       k.getFelder()[i][j] = new Wiese();
							break;
					      case 2:
					    	  if(k.getFelder()[i][j]==null&&k.getFelder()[i+1][j]==null&&k.getFelder()[i+1][j+1]==null){
					    		  k.getFelder()[i][j]= new Wald();
					    		  k.getFelder()[i+1][j]= new Wald();
					    		  k.getFelder()[i+1][j+1]= new Wald();
					    		  k.getFelder()[i][j+1]= new Huegel();
					    	  }else
					    		  k.getFelder()[i][j]= new Wiese();
					    	  break;
					      case 3:
					    	  if(k.getFelder()[i+1][j]==null&&k.getFelder()[i][j+1]==null&&k.getFelder()[i+1][j+1]==null){
					    		  k.getFelder()[i][j]= new Wiese();
					    		  k.getFelder()[i+1][j]= new Wald();
					    		  k.getFelder()[i+1][j+1]= new Wald();
					    		  k.getFelder()[i][j+1]= new Wald();
					    	  }else
					    		  k.getFelder()[i][j]= new Wiese();
					    	  break;
					      case 4:
					    	  if(k.getFelder()[i][j]==null&&k.getFelder()[i][j+1]==null&&k.getFelder()[i+1][j]==null){
					    		  k.getFelder()[i][j]= new Wald();
					    		  k.getFelder()[i][j+1]= new Wald();
					    		  k.getFelder()[i+1][j]= new Wald();
					    		  k.getFelder()[i+1][j+1]= new Huegel();
					    	  }else
					    		  k.getFelder()[i][j]= new Wiese();
					    	  break;
					      case 5:
					    	  if(k.getFelder()[i][j]==null&&k.getFelder()[i][j+1]==null){
					    		  k.getFelder()[i][j]= new Wald();
					    		  k.getFelder()[i][j+1]= new Wald();
					    	  }else
					    		  k.getFelder()[i][j]= new Wiese();
					    	  break;
					      case 6:
					    	  if(k.getFelder()[i][j]==null&&k.getFelder()[i+1][j]==null){
					    		  k.getFelder()[i][j]= new Wald();
					    		  k.getFelder()[i+1][j]= new Wald();
					    	  }else
					    		  k.getFelder()[i][j]= new Wiese();
					    	  break;		
					}
			    	 }else
			    		 k.getFelder()[i][j] = new Wiese();
		      break;
		     case 4:
		      //Sumpf
		      k.getFelder()[i][j]=new Sumpf();
		      break;
		     case 5:
		      //Huegel
		      k.getFelder()[i][j]=new Huegel();
		      break;
		     case 6:
		      //Wiese
		      k.getFelder()[i][j]=new Wiese();
		      break;  
		     }
		    }
		   }
		   
		  }
		 }

	private static void inselgenerieren(Karte k) {
		int steppe = 2;
		int mindestgrosse = 0;
		if(kontinente){
			inselanzahl = 2;
			mindestgrosse =(((Parameter.spielfeldAnzahlX + Parameter.spielfeldAnzahlY) / 2) / 7);
		}
		else{ 
		if(inselanzahl <= 2) {steppe = 1;}
		if(inselanzahl >= 5){
			inselanzahl += r.nextInt(3);
		}
			mindestgrosse =(((Parameter.spielfeldAnzahlX + Parameter.spielfeldAnzahlY) / 2) / 10)/2;
		}
		 y = new int[inselanzahl];
		 x = new int[inselanzahl];
		randomrechts = new int[inselanzahl];
		randomlinks = new int[inselanzahl];
		randomunten = new int[inselanzahl];
		randomoben = new int[inselanzahl];
		int ungultig = 0;

		for (int j = 0; j < inselanzahl; j++) {
			do {
				ungultig = 0;
				randomrechts[j] = r.nextInt(Parameter.spielfeldAnzahlX / 10)
						+ mindestgrosse;
				randomlinks[j] = r.nextInt(Parameter.spielfeldAnzahlX / 10)
						+ mindestgrosse;
				randomunten[j] = r.nextInt(Parameter.spielfeldAnzahlY / 10)
						+ mindestgrosse;
				randomoben[j] = r.nextInt(Parameter.spielfeldAnzahlY / 10)
						+ mindestgrosse;
				x[j] = r.nextInt(Parameter.spielfeldAnzahlX - 5
						- randomlinks[j] - randomrechts[j])
						+ randomlinks[j]+3;
				y[j] = r.nextInt(Parameter.spielfeldAnzahlY - maxeis * 2
						- randomunten[j] - randomoben[j] - 3 - steppe)
						+ maxeis + randomoben[j] + 1 + steppe;

				for (int i = y[j] + randomunten[j] + 2; i >= y[j]
						- randomoben[j] - 2; i--) {
					for (int g = x[j] - randomlinks[j]-2; g <= x[j]
							+ randomrechts[j] + 2; g++) {
						if (k.getFelder()[g][i] instanceof Meer) {
						} else {
							
							ungultig++;
							continue;
						}
						
					}
				}
			} while (ungultig != 0);
			for (int i = x[j]; i <= x[j] + randomrechts[j]; i++) {
				k.getFelder()[i][y[j]] = null;
			}
			// rechts k�ste
			k.getFelder()[x[j] + randomrechts[j] + 1][y[j]] = new Kueste();
			k.getFelder()[x[j] + randomrechts[j]][y[j] - 1] = new Kueste();
			k.getFelder()[x[j] + randomrechts[j] + 1][y[j] - 1] = new Kueste();
			k.getFelder()[x[j] + randomrechts[j] + 1][y[j] + 1] = new Kueste();
			k.getFelder()[x[j] + randomrechts[j]][y[j] + 1] = new Kueste();
			for (int i = x[j]; i >= x[j] - randomlinks[j]; i--) {
				k.getFelder()[i][y[j]] = null;
			}
			// links k�ste
			k.getFelder()[x[j] - randomlinks[j] - 1][y[j]] = new Kueste();
			k.getFelder()[x[j] - randomlinks[j]][y[j] - 1] = new Kueste();
			k.getFelder()[x[j] - randomlinks[j] - 1][y[j] - 1] = new Kueste();
			k.getFelder()[x[j] - randomlinks[j] - 1][y[j] + 1] = new Kueste();
			k.getFelder()[x[j] - randomlinks[j]][y[j] + 1] = new Kueste();
			for (int i = y[j]; i >= y[j] - randomoben[j]; i--) {
				k.getFelder()[x[j]][i] = null;
			}
			// oben k�ste
			k.getFelder()[x[j] + 1][y[j] - randomoben[j]] = new Kueste();
			k.getFelder()[x[j] - 1][y[j] - randomoben[j]] = new Kueste();
			k.getFelder()[x[j] + 1][y[j] - randomoben[j] - 1] = new Kueste();
			k.getFelder()[x[j] - 1][y[j] - randomoben[j] - 1] = new Kueste();
			k.getFelder()[x[j]][y[j] - randomoben[j] - 1] = new Kueste();
			for (int i = y[j]; i <= y[j] + randomunten[j]; i++) {
				k.getFelder()[x[j]][i] = null;
			}
			// unten k�ste
			k.getFelder()[x[j] + 1][y[j] + randomunten[j]] = new Kueste();
			k.getFelder()[x[j] - 1][y[j] + randomunten[j]] = new Kueste();
			k.getFelder()[x[j] + 1][y[j] + randomunten[j] + 1] = new Kueste();
			k.getFelder()[x[j] - 1][y[j] + randomunten[j] + 1] = new Kueste();
			k.getFelder()[x[j]][y[j] + randomunten[j] + 1] = new Kueste();
			randzeichnen(x[j] + randomrechts[j], x[j] - randomlinks[j], y[j]
					- randomoben[j], y[j] + randomunten[j], x[j], y[j], k); // rechts,links,oben,unten,X-Koordinate,
																			// YKoordinate,Karte
																			// wird
																			// �bergeben

		}
	}

	private static void randzeichnen(int rechts, int links, int oben,
			int unten, int Xwert, int Ywert, Karte k) {
		int wertX = links;
		int wertY = Ywert;
		int random = 2;
		boolean ersterdurchlauf = true;
		boolean begrenzung = false;
		// von links nach unten
		while (wertY < unten) {
			switch (r.nextInt(random)) {
			case 0:
				wertY++;
				for (int i = wertX; i <= Xwert; i++) {
					k.getFelder()[i][wertY] = null;
				}
				k.getFelder()[wertX - 1][wertY] = new Kueste();
				k.getFelder()[wertX][wertY + 1] = new Kueste();
				k.getFelder()[wertX - 1][wertY + 1] = new Kueste();
				if (begrenzung == true) {
					random++;
					begrenzung = false;
				}
				break;
			case 1:
				wertY++;
				wertX++;
				for (int i = wertX; i <= Xwert; i++) {
					k.getFelder()[i][wertY] = null;
				}
				k.getFelder()[wertX - 1][wertY] = new Kueste();
				k.getFelder()[wertX - 1][wertY + 1] = new Kueste();
				k.getFelder()[wertX][wertY + 1] = new Kueste();
				if (begrenzung == true) {
					random++;
					begrenzung = false;
				}
				break;
			case 2:
				wertX++;
				k.getFelder()[wertX][wertY + 1] = new Kueste();
				random--;
				begrenzung = true;
				break;
			}
			if (wertY == unten) {
				while (wertX < Xwert) {
					wertX++;
					k.getFelder()[wertX][wertY+1] = new Kueste();
				}
			}
			if (wertX == Xwert - 1) {
				while (wertY < unten) {
					wertY++;
					if (wertY == unten && r.nextInt(2) == 0) {
						break;
					}
					k.getFelder()[wertX][wertY] = null;
					k.getFelder()[wertX - 1][wertY] = new Kueste();
					k.getFelder()[wertX - 1][wertY + 1] = new Kueste();
					k.getFelder()[wertX][wertY + 1] = new Kueste();

				}
			}
			if (ersterdurchlauf) {
				random++;
				ersterdurchlauf = false;
			}
		}
		// links nach oben
		ersterdurchlauf = false;
		random = 2;
		wertY = Ywert;
		wertX = links;
		while (wertY > oben) {
			switch (r.nextInt(random)) {
			case 0:
				wertY--;
				for (int i = wertX; i <= Xwert; i++) {
					k.getFelder()[i][wertY] = null;
				}
				k.getFelder()[wertX - 1][wertY] = new Kueste();
				k.getFelder()[wertX][wertY - 1] = new Kueste();
				k.getFelder()[wertX - 1][wertY - 1] = new Kueste();
				if (begrenzung == true) {
					random++;
					begrenzung = false;
				}
				break;
			case 1:
				wertY--;
				wertX++;
				for (int i = wertX; i <= Xwert; i++) {
					k.getFelder()[i][wertY] = null;
				}
				k.getFelder()[wertX - 1][wertY] = new Kueste();
				k.getFelder()[wertX][wertY - 1] = new Kueste();
				k.getFelder()[wertX - 1][wertY - 1] = new Kueste();
				if (begrenzung == true) {
					random++;
					begrenzung = false;
				}
				break;
			case 2:
				wertX++;
				k.getFelder()[wertX][wertY - 1] = new Kueste();
				random--;
				begrenzung = true;
				break;
			}
			if (wertY == oben) {
				while (wertX < Xwert) {
					wertX++;
					k.getFelder()[wertX][wertY - 1] = new Kueste();
				}
			}
			if (wertX == Xwert - 1) {
				while (wertY > oben) {
					wertY--;
					if (wertY == oben && r.nextInt(2) == 0) {
						break;
					}
					k.getFelder()[wertX][wertY] = null;
					k.getFelder()[wertX - 1][wertY] = new Kueste();
					k.getFelder()[wertX][wertY - 1] = new Kueste();
					k.getFelder()[wertX - 1][wertY - 1] = new Kueste();

				}
			}
			if (ersterdurchlauf) {
				random++;
				ersterdurchlauf = false;
			}
		}
		// von oben nach rechts
		ersterdurchlauf = false;
		random = 2;
		wertY = oben;
		wertX = Xwert;
		while (wertX < rechts) {
			switch (r.nextInt(random)) {
			case 0:
				wertX++;
				for (int i = wertY; i <= Ywert; i++) {
					k.getFelder()[wertX][i] = null;
				}
				k.getFelder()[wertX + 1][wertY] = new Kueste();
				k.getFelder()[wertX][wertY - 1] = new Kueste();
				k.getFelder()[wertX + 1][wertY - 1] = new Kueste();
				if (begrenzung == true) {
					random++;
					begrenzung = false;
				}
				break;
			case 1:
				wertY++;
				wertX++;
				for (int i = wertY; i <= Ywert; i++) {
					k.getFelder()[wertX][i] = null;
				}
				k.getFelder()[wertX + 1][wertY] = new Kueste();
				k.getFelder()[wertX][wertY - 1] = new Kueste();
				k.getFelder()[wertX + 1][wertY - 1] = new Kueste();
				if (begrenzung == true) {
					random++;
					begrenzung = false;
				}
				break;
			case 2:
				wertY++;
				k.getFelder()[wertX + 1][wertY] = new Kueste();
				random--;
				begrenzung = true;
				break;
			}
			if (wertX == rechts) {
				while (wertY < Ywert) {
					wertY++;
					k.getFelder()[wertX + 1][wertY] = new Kueste();
				}
			}
			if (wertY == Ywert - 1) {
				while (wertX < rechts) {
					wertX++;
					if (wertX == rechts && r.nextInt(2) == 0) {
						break;
					}
					k.getFelder()[wertX][wertY] = null;
					k.getFelder()[wertX + 1][wertY] = new Kueste();
					k.getFelder()[wertX + 1][wertY - 1] = new Kueste();
					k.getFelder()[wertX][wertY - 1] = new Kueste();

				}
			}
			if (ersterdurchlauf) {
				random++;
				ersterdurchlauf = false;
			}
		}
		// von unten nach rechts
		ersterdurchlauf = false;
		random = 2;
		wertY = unten;
		wertX = Xwert;
		while (wertX < rechts) {
			switch (r.nextInt(random)) {
			case 0:
				wertX++;
				for (int i = wertY; i >= Ywert; i--) {
					k.getFelder()[wertX][i] = null;
				}
				k.getFelder()[wertX + 1][wertY] = new Kueste();
				k.getFelder()[wertX][wertY + 1] = new Kueste();
				k.getFelder()[wertX + 1][wertY + 1] = new Kueste();
				if (begrenzung == true) {
					random++;
					begrenzung = false;
				}
				break;
			case 1:
				wertY--;
				wertX++;
				for (int i = wertY; i >= Ywert; i--) {
					k.getFelder()[wertX][i] = null;
				}
				k.getFelder()[wertX + 1][wertY] = new Kueste();
				k.getFelder()[wertX][wertY + 1] = new Kueste();
				k.getFelder()[wertX + 1][wertY + 1] = new Kueste();
				if (begrenzung == true) {
					random++;
					begrenzung = false;
				}
				break;
			case 2:
				wertY--;
				k.getFelder()[wertX + 1][wertY] = new Kueste();
				random--;
				begrenzung = true;
				break;
			}
			if (wertX == rechts) {
				while (wertY > Ywert) {
					wertY--;
					k.getFelder()[wertX + 1][wertY] = new Kueste();
				}
			}
			if (wertY == Ywert + 1) {
				while (wertX < rechts) {
					wertX++;
					if (wertX == rechts && r.nextInt(2) == 0) {
						break;
					}
					k.getFelder()[wertX][wertY] = null;
					k.getFelder()[wertX + 1][wertY] = new Kueste();
					k.getFelder()[wertX][wertY + 1] = new Kueste();
					k.getFelder()[wertX + 1][wertY + 1] = new Kueste();

				}
			}
			if (ersterdurchlauf) {
				random++;
				ersterdurchlauf = false;
			}
		}
	}

	private static void pole(Karte k) {
	for (int i = 1; i <= Parameter.spielfeldAnzahlX; i++) {
			
			
			randomZahlOben = randomZahlOben + randomZahl.nextInt(3) - 1;
			if (randomZahlOben == 0)
				randomZahlOben = 1;
			if (randomZahlOben == zehntelallFelderDurchX + 1) 
				randomZahlOben = zehntelallFelderDurchX;
			for (int j = 1; j <= randomZahlOben; j++) { 
				 k.getFelder()[i][j] = new Eis();
			}

			// Steppe auf Eis zeichnen oben der Startpunkt ist immer das Ende vom Eis
			int steppeHoeheOben = randomZahl.nextInt(2) + 3;
			for (int j = (randomZahlOben + 1); j < (randomZahlOben + steppeHoeheOben); j++) {
				int r = randomZahl.nextInt(50) + 1;
				if (r >= 25) {
					if (k.getFelder()[i][j - 1] instanceof Eis) {
						k.getFelder()[i][j] = new Steppe();
						if (i < Parameter.spielfeldAnzahlX&&!(k.getFelder()[i+1][j+1] instanceof Steppe)) 
							k.getFelder()[i+1][j+1] = new Kueste();
						if(i>=2&&!(k.getFelder()[i-1][j+1] instanceof Steppe))
							k.getFelder()[i-1][j+1] = new Kueste();
					} else {
						k.getFelder()[i][j] = new Kueste();
					}
				} else {
					k.getFelder()[i][j] = new Kueste();
				}

			}
			

			/*SUEDPOL------------------------------------------------------------------*/
			

			//Eis zeichnen
			randomZahlUnten = randomZahlUnten + randomZahl.nextInt(3) - 1; 
			if (randomZahlUnten == 0)
				randomZahlUnten = 1;
			if (randomZahlUnten == zehntelallFelderDurchX + 1)
				randomZahlUnten = zehntelallFelderDurchX;
			for (int j = Parameter.spielfeldAnzahlY; j > Parameter.spielfeldAnzahlY
					- randomZahlUnten; j--) {
				k.getFelder()[i][j] = new Eis();
			}

			// Steppe auf Eis zeichnen (Suedpol) unten der Startpunkt ist Ende von Eis
//			int steppeHoeheUnten = (randomZahl.nextInt(zehntelallFelderDurchX) + 1)+(randomZahl.nextInt(3));
			int steppeHoeheUnten = randomZahl.nextInt(2) + 2;
			for (int q = (Parameter.spielfeldAnzahlY - randomZahlUnten); q > (Parameter.spielfeldAnzahlY
					- randomZahlUnten - steppeHoeheUnten); q--) {
				int r = randomZahl.nextInt(50) + 1;
				if (r >= 25) {
					if (k.getFelder()[i][q+1] instanceof Eis) {
						k.getFelder()[i][q] = new Steppe();
//							k.getFelder()[i+1][q+1] = new Kueste();
							if (i < Parameter.spielfeldAnzahlX&&!(k.getFelder()[i+1][q-1] instanceof Steppe)) 
								k.getFelder()[i+1][q-1] = new Kueste();
							if(i>=2&&!(k.getFelder()[i-1][q-1] instanceof Steppe))
								k.getFelder()[i-1][q-1] = new Kueste();
					} else {
						k.getFelder()[i][q] = new Kueste();
					}
				} else {
					k.getFelder()[i][q] = new Kueste();
				}
				
			}
		}
	}


	
}
