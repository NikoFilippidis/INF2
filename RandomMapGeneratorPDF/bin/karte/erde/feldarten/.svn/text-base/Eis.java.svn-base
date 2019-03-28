package karte.erde.feldarten;

import karte.Feld;
import karte.FeldArtErde;
import karte.Karte;
import karte.ResourcenArt;

public class Eis extends Feld {
	private static final long serialVersionUID = 1L;

	public Eis() {
		super();
		setArt(FeldArtErde.Eis);
		setBild(FeldArtErde.getBild(getArt()));
		setResource(null);
	}

	public Eis(Karte brett,byte posX,byte posY) {
		this();
		setKarte(brett);
		setPosition(posX,posY);
	}

	@Override
	public void setErlaubteResourcen(){
		addErlaubteResource(ResourcenArt.Aluminium);
		addErlaubteResource(ResourcenArt.Oel);
		addErlaubteResource(ResourcenArt.Pelz);
		addErlaubteResource(ResourcenArt.Wild);
	}
}