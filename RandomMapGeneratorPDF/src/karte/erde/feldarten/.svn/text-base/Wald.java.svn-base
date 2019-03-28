package karte.erde.feldarten;

import karte.Feld;
import karte.FeldArtErde;
import karte.Karte;
import karte.ResourcenArt;

public class Wald extends Feld {
	private static final long serialVersionUID = 1L;

	public Wald() {
		super();
		setArt(FeldArtErde.Wald);
		setBild(FeldArtErde.getBild(getArt()));
		setResource(null);
	}

	public Wald(Karte brett,byte posX,byte posY) {
		this();
		setKarte(brett);
		setPosition(posX,posY);
	}

	@Override
	public void setErlaubteResourcen(){
		addErlaubteResource(ResourcenArt.Faerbemittel);
		addErlaubteResource(ResourcenArt.Gewuertz);
		addErlaubteResource(ResourcenArt.Gummi);
		addErlaubteResource(ResourcenArt.Pelz);
		addErlaubteResource(ResourcenArt.Seide);
		addErlaubteResource(ResourcenArt.Wild);
		addErlaubteResource(ResourcenArt.Uran);
	}
}
