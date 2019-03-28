package karte;

import java.awt.image.BufferedImage;

public class Resource{
	private ResourcenArt art=null;
	private BufferedImage bild=null;
	
	public Resource(ResourcenArt art){
		this.art=art;
		this.bild=ResourcenArt.getBild(art);
	}

	public ResourcenArt getArt() {
		return art;
	}

	public BufferedImage getBild() {
		return bild;
	}
	
	@Override
	public String toString(){
		return ""+this.getArt();
	}
	
	@Override
	public boolean equals(Object o){
		if (!(o instanceof Resource)) return false;
		Resource r=(Resource)o;
		return r.getArt().equals(this.getArt());
	}
}
