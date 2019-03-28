package karte.erde.feldarten;

import karte.Feld;
import karte.FeldArtErde;
import karte.Karte;
import karte.ResourcenArt;

public class Huegel extends Feld {
	private static final long serialVersionUID = 1L;

	public Huegel() {
		super();
		setArt(FeldArtErde.Huegel);
		setBild(FeldArtErde.getBild(getArt()));
		setResource(null);
	}

	public Huegel(Karte brett,byte posX,byte posY) {
		this();
		setKarte(brett);
		setPosition(posX,posY);
	}

	@Override
	public void setErlaubteResourcen(){
		addErlaubteResource(ResourcenArt.Aluminium);
		addErlaubteResource(ResourcenArt.Eisen);
		addErlaubteResource(ResourcenArt.Gold);
		addErlaubteResource(ResourcenArt.Kohle);
		addErlaubteResource(ResourcenArt.Salpeter);
		addErlaubteResource(ResourcenArt.Tabak);
		addErlaubteResource(ResourcenArt.Wein);
		addErlaubteResource(ResourcenArt.Weihrauch);
		addErlaubteResource(ResourcenArt.Zucker);

	}
}
