package karte.erde.feldarten;

import karte.Feld;
import karte.FeldArtErde;
import karte.Karte;
import karte.ResourcenArt;

public class Meer extends Feld {
	private static final long serialVersionUID = 1L;

	public Meer() {
		super();
		setArt(FeldArtErde.Meer);
		setBild(FeldArtErde.getBild(getArt()));
		setResource(null);
	}

	public Meer(Karte brett,byte posX,byte posY) {
		this();
		setKarte(brett);
		setPosition(posX,posY);
	}

	@Override
	public void setErlaubteResourcen(){
		addErlaubteResource(ResourcenArt.Fisch);
		addErlaubteResource(ResourcenArt.Oel);
		addErlaubteResource(ResourcenArt.Wal);
	}
}
