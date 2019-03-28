package karte;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public enum ResourcenArt {
	Aluminium,Edelsteine,Eisen,Elfenbein,Faerbemittel,Fisch,Gewuertz,Gold,Gummi,
	Kohle,Oase,Obst,Oel,Pelz,Pferde,Rinder,Salpeter,Seide,Tabak,Uran,Wal,Weihrauch,
	Wein,Weizen,Wild,Zucker;
	
	private static String pfadBild="resources//resourcenarten";
	private static String packageKlasse="karte.resourcenarten.";


	private static BufferedImage[] bild=new BufferedImage[ResourcenArt.values().length];
	static{
		try {
			for(int i=0;i<ResourcenArt.values().length;i++){
				String name=(""+ResourcenArt.values()[i]).toLowerCase();
				bild[i]=ImageIO.read(new File(pfadBild,name+".png"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public static Resource getResource(ResourcenArt art){
		return getResource(""+art);
	}
	
	public static Resource getResource(String art){
    try {
  		@SuppressWarnings("unchecked")
  		Class<Resource> c=(Class<Resource>)Class.forName(packageKlasse+art);
			return (Resource)c.newInstance();
		} catch (Exception e) {
			return null;
		}
	}
	
	public static BufferedImage getBild(ResourcenArt art){
		return bild[art.ordinal()];
	}
}