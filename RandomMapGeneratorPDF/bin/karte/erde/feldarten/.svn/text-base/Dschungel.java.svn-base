package karte.erde.feldarten;

import karte.Feld;
import karte.FeldArtErde;
import karte.Karte;
import karte.ResourcenArt;

public class Dschungel extends Feld {
	private static final long serialVersionUID = 1L;

	public Dschungel() {
		super();
		setArt(FeldArtErde.Dschungel);
		setBild(FeldArtErde.getBild(getArt()));
		setResource(null);
	}

	public Dschungel(Karte brett,byte posX,byte posY) {
		this();
		setKarte(brett);
		setPosition(posX,posY);
	}

	@Override
	public void setErlaubteResourcen(){
		addErlaubteResource(ResourcenArt.Edelsteine);
		addErlaubteResource(ResourcenArt.Faerbemittel);
		addErlaubteResource(ResourcenArt.Gewuertz);
		addErlaubteResource(ResourcenArt.Gummi);
		addErlaubteResource(ResourcenArt.Kohle);
		addErlaubteResource(ResourcenArt.Obst);
		addErlaubteResource(ResourcenArt.Seide);


	}
}
