package karte;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Scrollable;

import engine.Engine;
import engine.KartenEvents;
import engine.Parameter;

public class Karte extends JPanel implements Scrollable{
	private static final long serialVersionUID = 1L;
	private KartenArt art;
	private int id;
	private Engine en;
	private Feld[][] felder;
	private JScrollPane scrollerKarte;
	private KartenEvents listener;
	
	public Karte(int id,KartenArt art,Engine ed){
		setId(id);
		setArt(art);
		setEngine(ed);
		listener=new KartenEvents(ed);
		felder=new Feld[Parameter.spielfeldAnzahlX+1][Parameter.spielfeldAnzahlY+1];
		setLayout(null);
	}
	

	public void initFeld(Feld f){
		f.addMouseListener(listener);
		f.addMouseMotionListener(listener);
		felder[f.getPos().getX()][f.getPos().getY()]=f;
		add(f);		
	}

	public void zeichneFelder(){
		setPreferredSize(new Dimension(
				Parameter.spielfeldAnzahlX*Parameter.spielfeldGroesse*Parameter.zoomfaktor/100,
				Parameter.spielfeldAnzahlY*Parameter.spielfeldGroesse*Parameter.zoomfaktor/100));
		for(byte i=1;i<=Parameter.spielfeldAnzahlX;i++){
			for(byte j=1;j<=Parameter.spielfeldAnzahlY;j++){
				Feld f=felder[i][j];
				if (f==null) continue;
				f.setBounds(new Rectangle(
						Parameter.spielfeldGroesse*Parameter.zoomfaktor/100,
						Parameter.spielfeldGroesse*Parameter.zoomfaktor/100));
				f.setLocation(
						(f.getPos().getX()-1)*Parameter.spielfeldGroesse*Parameter.zoomfaktor/100,
						(f.getPos().getY()-1)*Parameter.spielfeldGroesse*Parameter.zoomfaktor/100);
				f.zeichnen();				
			}
		}
	}

	public void terminate(){
		for(byte i=1;i<=Parameter.spielfeldAnzahlX;i++){
			for(byte j=1;j<=Parameter.spielfeldAnzahlY;j++){
				Feld f=felder[i][j];
				try{
					f.removeMouseListener(listener);
					f.removeMouseMotionListener(listener);
					f.setVisible(false);
					remove(f);					
				}
				catch (Exception e){};
				felder[i][j]=null;
			}
		}
	}

	public void initDarstellung(JPanel jp){
		JScrollPane scroller=new JScrollPane(this,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.setScroller(scroller);
		jp.add(scroller,BorderLayout.CENTER);
	}
	
	public void setFeld(Feld f,Position pos){
		int i=pos.getX();
		int j=pos.getY();
		if (felder[i][j]==null) return;
		f.setBounds(felder[i][j].getBounds());
		f.setLocation(felder[i][j].getLocation());
		f.addMouseListener(listener);
		f.addMouseMotionListener(listener);
		felder[i][j].setVisible(false);
		felder[i][j]=f;
		add(felder[i][j]);
		repaint();
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setArt(KartenArt art) {
		this.art = art;
	}

	public KartenArt getArt() {
		return art;
	}

	public void setEngine(Engine en) {
		this.en = en;
	}
	
	public Engine getEngine(){
		return en;
	}
	
	public Feld[][] getFelder(){
		return felder;
	}

	public JScrollPane getScroller() {
		return scrollerKarte;
	}
	
	public void setScroller(JScrollPane scroller) {
		this.scrollerKarte=scroller;
	}
	
	@Override
	public Dimension getPreferredScrollableViewportSize() {
		 return getPreferredSize();
	}

	@Override
	public boolean getScrollableTracksViewportHeight() {
		return false;
	}

	@Override
	public boolean getScrollableTracksViewportWidth() {
		return false;
	}
	
	@Override
	public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
		return 10;
	}
	
	@Override
	public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
		return 10;
	}
}
