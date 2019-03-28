package karte.unterwasser.feldarten;

import karte.Feld;
import karte.FeldArtUnterwasser;
import karte.Karte;

public class Wasser extends Feld {
	private static final long serialVersionUID = 1L;

	public Wasser() {
		super();
		setArt(FeldArtUnterwasser.Wasser);
		setBild(FeldArtUnterwasser.getBild(getArt()));
		setResource(null);
	}

	public Wasser(Karte brett,byte posX,byte posY) {
		this();
		setKarte(brett);
		setPosition(posX,posY);
	}

	@Override
	public void setErlaubteResourcen(){

	}
}