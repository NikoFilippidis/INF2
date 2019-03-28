package karte;

public enum KartenArt {
	Erde,Unterwasser,Weltraum;
	
	public static KartenArt vonString(String kartenArt){
		for(int i=0;i<KartenArt.values().length;i++){
			if ((""+KartenArt.values()[i]).equals(kartenArt))
				return KartenArt.values()[i]; 
		}
		return null;
	}
	
	public static FeldArt[] getErlaubteFeldarten(KartenArt kArt){
		switch (kArt){
		case Erde:
			return FeldArtErde.values();
		case Unterwasser:
			return FeldArtUnterwasser.values();
		case Weltraum:
			return FeldArtWeltraum.values();
		}
		return null;
	}

	public static Feld getFeld(KartenArt kArt,FeldArt feldArt){
		return getFeld(kArt,""+feldArt);
	}

	public static Feld getFeld(KartenArt kArt,String feldArt){
		switch (kArt){
		case Erde:
			return FeldArtErde.getFeld(feldArt);
		case Unterwasser:
			return FeldArtUnterwasser.getFeld(feldArt);
		case Weltraum:
			return FeldArtWeltraum.getFeld(feldArt);
		}
		return null;
	}
}