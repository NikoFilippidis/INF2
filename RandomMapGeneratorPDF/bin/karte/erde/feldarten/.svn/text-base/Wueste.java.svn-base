package karte.erde.feldarten;

import karte.Feld;
import karte.FeldArtErde;
import karte.Karte;
import karte.ResourcenArt;

public class Wueste extends Feld {
	private static final long serialVersionUID = 1L;

	public Wueste() {
		super();
		setArt(FeldArtErde.Wueste);
		setBild(FeldArtErde.getBild(getArt()));
		setResource(null);
	}

	public Wueste(Karte brett,byte posX,byte posY) {
		this();
		setKarte(brett);
		setPosition(posX,posY);
	}

	@Override
	public void setErlaubteResourcen(){
		addErlaubteResource(ResourcenArt.Oel);
		addErlaubteResource(ResourcenArt.Oase);
		addErlaubteResource(ResourcenArt.Salpeter);
		addErlaubteResource(ResourcenArt.Weihrauch);
	}
}
