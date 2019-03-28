package karte.erde.feldarten;

import karte.Feld;
import karte.FeldArtErde;
import karte.Karte;
import karte.ResourcenArt;

public class Steppe extends Feld {
	private static final long serialVersionUID = 1L;

	public Steppe() {
		super();
		setArt(FeldArtErde.Steppe);
		setBild(FeldArtErde.getBild(getArt()));
		setResource(null);
	}

	public Steppe(Karte brett,byte posX,byte posY) {
		this();
		setKarte(brett);
		setPosition(posX,posY);
	}

	@Override
	public void setErlaubteResourcen(){
		addErlaubteResource(ResourcenArt.Elfenbein);
		addErlaubteResource(ResourcenArt.Pferde);
		addErlaubteResource(ResourcenArt.Rinder);
		addErlaubteResource(ResourcenArt.Wein);
		addErlaubteResource(ResourcenArt.Weizen);
		addErlaubteResource(ResourcenArt.Zucker);
	}
}
