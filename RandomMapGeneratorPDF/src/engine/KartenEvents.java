package engine;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JOptionPane;

import karte.Feld;
import karte.FeldArtErde;
import karte.KartenArt;
import karte.ResourcenArt;


public class KartenEvents implements MouseListener,MouseMotionListener{
	private Engine en;
	private boolean dragging=false;

	public KartenEvents(Engine en) {
		this.en=en;
	}

	@Override
	public void mouseDragged(MouseEvent ev) {
		Feld g=(Feld)ev.getSource();
		aktion(g);
		dragging=true;
	}

	@Override
	public void mouseMoved(MouseEvent ev) {
		Feld f=(Feld)ev.getSource();
		String s=""+f.getPos()+": "+f.getArt();
		if (f.getResource()!=null)
			s+=", Resource "+f.getResource().getArt();
		if (f.getSpielerstart()!=0)
			s+=" und Startposition von Spieler "+f.getSpielerstart();
		if (en!=null)	en.setStatus(s);
	}

	@Override
	public void mouseClicked(MouseEvent ev) {
		Feld g=(Feld)ev.getSource();
		aktion(g);
	}
	
	@Override
	public void mouseEntered(MouseEvent ev) {
		Feld g=(Feld)ev.getSource();
		if (dragging) aktion(g);
	}

	@Override
	public void mouseExited(MouseEvent ev) {
	}

	@Override
	public void mousePressed(MouseEvent ev) {
	}

	@Override
	public void mouseReleased(MouseEvent ev) {
		dragging=false;
	}
	
	private void aktion(Feld f){
		AktionsArt aktion=en.getAktion();
		if (aktion.equals(AktionsArt.FeldArtSetzen)){
			Feld fNeu=en.getFeld();
			if (fNeu==null) return;
			fNeu.setKarte(en.getKarte());
			fNeu.setPosition(f.getPos());
			fNeu.setSpielerstart(f.getSpielerstart());
			en.getKarte().setFeld(fNeu,f.getPos());
		}
		if (aktion.equals(AktionsArt.ResourceSetzen)){
			dragging=false;
			ResourcenArt[] optionen=new ResourcenArt[f.getErlaubteResourcen().size()];
			if (optionen.length==0) return;
			for(int i=0;i<f.getErlaubteResourcen().size();i++){
				optionen[i]=f.getErlaubteResourcen().get(i);
			}
      int gewaehlt=JOptionPane.showOptionDialog(en,
      		"Setzen Sie die Resource...", 
      		"Resource fuer "+f.getPos()+" vom Typ "+f.getArt(),
		    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
		    null, optionen, optionen[0]);
      if (gewaehlt==-1) return;
			f.setResource(ResourcenArt.getResource(optionen[gewaehlt]));
		}
		if (aktion.equals(AktionsArt.ResourceLoeschen)){
			f.setResource(null);			
		}
		if (aktion.equals(AktionsArt.SpielerstartSetzen)){
			if (!en.getKarte().getArt().equals(KartenArt.Erde)) return;
			if ((f.getArt().equals(FeldArtErde.Kueste))||(f.getArt().equals(FeldArtErde.Meer))){
	    	JOptionPane.showMessageDialog(
	    			en,
	    			"Ein Spieler kann leider nicht auf dem Gelaende '"+f.getArt()+"' starten!",
	    			"Startposition eines Spielers setzen...",
	    			JOptionPane.WARNING_MESSAGE);
			}
			else{
				byte nummer=en.getSpielernummer();
				f.setSpielerstart(nummer);				
			}
		}
	}
}