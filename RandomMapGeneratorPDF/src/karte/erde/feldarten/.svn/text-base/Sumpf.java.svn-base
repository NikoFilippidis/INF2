package karte.erde.feldarten;

import karte.Feld;
import karte.FeldArtErde;
import karte.Karte;
import karte.ResourcenArt;

public class Sumpf extends Feld {
	private static final long serialVersionUID = 1L;

	public Sumpf() {
		setArt(FeldArtErde.Sumpf);
		setBild(FeldArtErde.getBild(getArt()));
		setResource(null);
	}

	public Sumpf(Karte brett,byte posX,byte posY) {
		this();
		setKarte(brett);
		setPosition(posX,posY);
	}

	@Override
	public void setErlaubteResourcen(){
		addErlaubteResource(ResourcenArt.Oel);
		addErlaubteResource(ResourcenArt.Gummi);
		addErlaubteResource(ResourcenArt.Wild);
	}
}
