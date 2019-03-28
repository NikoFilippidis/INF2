package karte.erde.feldarten;

import karte.Feld;
import karte.FeldArtErde;
import karte.Karte;
import karte.ResourcenArt;

public class Wiese extends Feld {
	private static final long serialVersionUID = 1L;

	public Wiese(){		
		setArt(FeldArtErde.Wiese);
		setBild(FeldArtErde.getBild(getArt()));
		setResource(null);
	}
	
	public Wiese(Karte brett,byte posX,byte posY){
		this();
		setKarte(brett);
		setPosition(posX,posY);
	}

	@Override
	public void setErlaubteResourcen(){
		addErlaubteResource(ResourcenArt.Pferde);
		addErlaubteResource(ResourcenArt.Tabak);
		addErlaubteResource(ResourcenArt.Rinder);
		addErlaubteResource(ResourcenArt.Wein);
		addErlaubteResource(ResourcenArt.Weizen);
	}
}