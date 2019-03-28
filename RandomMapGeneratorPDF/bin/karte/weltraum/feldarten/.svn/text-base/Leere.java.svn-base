package karte.weltraum.feldarten;

import karte.Feld;
import karte.FeldArtWeltraum;
import karte.Karte;

public class Leere extends Feld {
	private static final long serialVersionUID = 1L;

	public Leere() {
		super();
		setArt(FeldArtWeltraum.Leere);
		setBild(FeldArtWeltraum.getBild(getArt()));
		setResource(null);
	}

	public Leere(Karte brett,byte posX,byte posY) {
		this();
		setKarte(brett);
		setPosition(posX,posY);
	}

	@Override
	public void setErlaubteResourcen(){

	}
}