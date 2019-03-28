package karte.erde.feldarten;

import karte.Feld;
import karte.FeldArtErde;
import karte.Karte;
import karte.ResourcenArt;

public class Kueste extends Feld {
	private static final long serialVersionUID = 1L;

	public Kueste() {
		super();
		setArt(FeldArtErde.Kueste);
		setBild(FeldArtErde.getBild(getArt()));
		setResource(null);
	}

	public Kueste(Karte brett,byte posX,byte posY) {
		this();
		setKarte(brett);
		setPosition(posX,posY);
	}

	@Override
	public void setErlaubteResourcen(){
		addErlaubteResource(ResourcenArt.Fisch);
		addErlaubteResource(ResourcenArt.Oel);
	}
}
