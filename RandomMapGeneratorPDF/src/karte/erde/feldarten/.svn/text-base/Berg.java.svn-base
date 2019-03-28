package karte.erde.feldarten;

import karte.Feld;
import karte.FeldArtErde;
import karte.Karte;
import karte.ResourcenArt;

public class Berg extends Feld {
	private static final long serialVersionUID = 1L;

	public Berg() {
		super();
		setArt(FeldArtErde.Berg);
		setBild(FeldArtErde.getBild(getArt()));
		setResource(null);
	}

	public Berg(Karte brett,byte posX,byte posY) {
		this();
		setKarte(brett);
		setPosition(posX,posY);
	}

	@Override
	public void setErlaubteResourcen(){
		addErlaubteResource(ResourcenArt.Edelsteine);
		addErlaubteResource(ResourcenArt.Eisen);
		addErlaubteResource(ResourcenArt.Gold);
		addErlaubteResource(ResourcenArt.Kohle);
		addErlaubteResource(ResourcenArt.Salpeter);
		addErlaubteResource(ResourcenArt.Uran);
	}
	@Override
	public Berg clone(){
		return new Berg();
	}
}