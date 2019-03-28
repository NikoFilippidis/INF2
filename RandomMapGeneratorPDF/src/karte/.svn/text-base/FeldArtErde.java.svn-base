package karte;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public enum FeldArtErde implements FeldArt{
	Berg,Dschungel,Eis,Huegel,Kueste,Meer,Steppe,Sumpf,Wiese,Wald,Wueste;
	
	private static String pfadBild="resources//feldarten//erde";
	private static String packageKlasse="karte.erde.feldarten.";

	private static BufferedImage[] bild=new BufferedImage[FeldArtErde.values().length];
	static{
		try {
			for(int i=0;i<FeldArtErde.values().length;i++){
				String name=(""+FeldArtErde.values()[i]).toLowerCase();
				bild[i]=ImageIO.read(new File(pfadBild,name+".jpg"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public static Feld getFeld(FeldArt art) {
		return getFeld(""+art);
	}
	
	public static Feld getFeld(String art){
    try {
  		@SuppressWarnings("unchecked")
  		Class<Feld> c=(Class<Feld>)Class.forName(packageKlasse+art);
			return (Feld)c.newInstance();
		} catch (Exception e) {
			return null;
		}
	}
	
	public static BufferedImage getBild(FeldArtErde art){
		return bild[art.ordinal()];
	}

	public static BufferedImage getBild(FeldArt art) {
		return bild[((FeldArtErde)art).ordinal()];
	}
}
