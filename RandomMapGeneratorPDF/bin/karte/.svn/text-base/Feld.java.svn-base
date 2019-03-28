package karte;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import engine.Parameter;

public abstract class Feld extends JLabel{
	private static final long serialVersionUID = 1L;
	private FeldArt art=null;
	private Karte k;
	private Resource res;
	private Position pos;
	private int spielerstart=0;
	private ArrayList<ResourcenArt> erlaubteResourcen=new ArrayList<ResourcenArt>();
	private BufferedImage bild=null;

	public Feld(){
		setEnabled(true);
		setOpaque(true);
		setFocusable(false);
		setErlaubteResourcen();
	}
	
	public Feld(Karte k,byte posX,byte posY) {
		this();
		setKarte(k);
		setPosition(posX,posY);
	}
	
	public abstract void setErlaubteResourcen();
	
	public void setPosition(byte posX, byte posY){
		pos=new Position(posX,posY);
	}

	public void setPosition(Position p){
		pos=p;
	}

	public Position getPos(){
		return pos;
	}
	
	public void setKarte(Karte k){
		this.k=k;
	}
	
	public Karte getKarte(){
		return k;
	}

	public void addErlaubteResource(ResourcenArt art){
		if (erlaubteResourcen.contains(art)) return;
		erlaubteResourcen.add(art);
	}
	
	public ArrayList<ResourcenArt> getErlaubteResourcen(){
		return erlaubteResourcen;
	}
	
	public void zeichnen(){	
		BufferedImage bildIcon=new BufferedImage(bild.getWidth(),bild.getHeight(),BufferedImage.TYPE_INT_ARGB);
		Image bildIconSkaliert;
		Graphics g=bildIcon.getGraphics();
		g.drawImage(bild,0,0,null);
		if (res!=null){
			BufferedImage bildResource=res.getBild();
			g.drawImage(bildResource,bildIcon.getWidth()/2-bildResource.getWidth()/2,bildIcon.getHeight()/2-bildResource.getWidth()/2,null);
		}
		if (spielerstart!=0){
			g.setFont(new Font("Arial",Font.BOLD,30));
			g.setColor(new Color(255,0,0));
			g.drawString(""+spielerstart,5,24);
		}
		if (Parameter.zoomfaktor==100)
			bildIconSkaliert=bildIcon;
		else
			bildIconSkaliert=bildIcon.getScaledInstance(bild.getWidth()*Parameter.zoomfaktor/100,bild.getHeight()*Parameter.zoomfaktor/100,Image.SCALE_FAST);
		setIcon(new ImageIcon(bildIconSkaliert));
	}
	
	public void setResource(Resource resource){
		if ((resource==null)||(erlaubteResourcen.contains(resource.getArt()))){
			this.res=resource;			
			zeichnen();
		}
	}
	
	public Resource getResource(){
		return res;
	}
	
	public void setArt(FeldArt art) {
		this.art = art;
	}

	public FeldArt getArt() {
		return art;
	}
	
	public BufferedImage getBild() {
		return bild;
	}

	public void setBild(BufferedImage bild) {
		this.bild=bild;
	}

	public void setSpielerstart(int spielerstart) {
		if (spielerstart!=0){
			for(int i=1;i<=Parameter.spielfeldAnzahlX;i++){
				for(int j=1;j<=Parameter.spielfeldAnzahlY;j++){
					Feld f=k.getFelder()[i][j];
					if (f==null) continue;
					if (f.getSpielerstart()==spielerstart){
						f.spielerstart=0;
						f.zeichnen();
					}
				}
			}			
		}
		this.spielerstart=spielerstart;
		zeichnen();
	}

	public int getSpielerstart() {
		return spielerstart;
	}

	@Override
	public String toString(){
		return "Spielfeld "+pos;
	}
	
	@Override
	public boolean equals(Object o){
		if (!(o instanceof Feld)) return false;
		Feld f=(Feld)o;
		return (f.getPos().equals(this.getPos()));
	}
}
