package engine;

import karte.Karte;


//import backend.generator.engine.generatorinsel;

public class Generator {
	public static boolean generateMap(String art, int id,int parameterX,int parameterY){
		Karte k = null;

		Parameter.spielfeldAnzahlX = (byte)parameterX;
		Parameter.spielfeldAnzahlY = (byte)parameterY;
		
		switch(art){
		case "Inseln":
			k = generatorinsel.generateinsel();
			break;
		case "Kontinente":
			k = GeneratorKontinente2.generateinsel();			
			break;
		case "Pangaea":
			k = GeneratorPangaea2.generatePangaea();
			break;
		case "Seen":
			k = GeneratorSeen.generateSeen();
			break;
		case "Spiegeln":
			k = GeneratorSpiegeln.generateinsel();
		}
		
		k.setId(id);
		
		
	//	Karte k = generatorinsel.generateinsel(true); //  false f�r inseln, true f�r kontinente
	//	Karte k = Generator.generateKontinente();
	//	Karte k = GeneratorSeen.generateSeen();
		//k.getFelder()[0][0]= new Berg();
	//	k.getFelder()[1][1].setSpielerstart(1);
		//saveMap
//		Dateizugriff dz = new Dateizugriff();
		//dz.speichernKarte(k,"randomMap.map");
		
		return true;
	}
}
