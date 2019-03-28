package engine;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import karte.Feld;
import karte.FeldArt;
import karte.FeldArtErde;
import karte.KartenArt;

public class MenuRechts extends JPanel implements ActionListener{
	private static final long serialVersionUID=1L;
	private Engine en;
	private JRadioButton[] aktionsButton=new JRadioButton[4];
	private JComboBox wahlFeldArt=new JComboBox();
	private JComboBox wahlSpielernummer=new JComboBox();
	private JComboBox wahlZoom=new JComboBox();
	private AktionsArt aktion;
	
	public MenuRechts(Engine en){
		this.en=en;
		setLayout(new GridLayout(11,1));
		setPreferredSize(new Dimension(200,200));
		ButtonGroup aktionenGruppe=new ButtonGroup();
		// AKTIONEN
		addHeader("AKTION");
		aktionsButton[0]=addAktion(aktionenGruppe,"Feldart setzen");		
		aktionsButton[0].doClick();
		aktionsButton[1]=addAktion(aktionenGruppe,"Resource setzen");		
		aktionsButton[2]=addAktion(aktionenGruppe,"Resource loeschen");		
		aktionsButton[3]=addAktion(aktionenGruppe,"Spielerstart setzen");		
		for (int i=0;i<aktionsButton.length;i++)
			aktionsButton[i].setEnabled(false);
		// FELDART
		addHeader("FELDART");
		wahlFeldArt.setFont(new Font("Arial",Font.BOLD,14));
		add(wahlFeldArt);
		wahlFeldArt.setSelectedItem(FeldArtErde.Wiese);
		wahlFeldArt.addActionListener(this);
		wahlFeldArt.setEnabled(false);
		// SPIELERNUMMER
		addHeader("SPIELERNUMMER");
		wahlSpielernummer.setFont(new Font("Arial",Font.BOLD,14));
		for(byte i=1;i<=4;i++) wahlSpielernummer.addItem(i);			
		add(wahlSpielernummer);
		wahlSpielernummer.addActionListener(this);
		wahlSpielernummer.setEnabled(false);
		// ZOOM
		addHeader("ZOOM in %");
		wahlZoom.setFont(new Font("Arial",Font.BOLD,14));
		for(int i=20;i<=200;i+=20) wahlZoom.addItem(i);
		wahlZoom.setSelectedItem(100);
		add(wahlZoom);
		wahlZoom.addActionListener(this);
		wahlZoom.setEnabled(false);
	}
	
	public void aktivieren(){
		try{
			wahlFeldArt.removeAllItems();			
		}
		catch (Exception e){}
		for(FeldArt feldArt:KartenArt.getErlaubteFeldarten(en.getKarte().getArt()))
			wahlFeldArt.addItem(feldArt);
		for (int i=0;i<aktionsButton.length;i++)
			aktionsButton[i].setEnabled(true);
		wahlZoom.setEnabled(true);
		aktionsButton[0].doClick();
		wahlZoom.setSelectedItem(100);
	}
	
	public AktionsArt getAktion(){
		return aktion;
	}
	
	public Feld getFeld(){
		FeldArt art=(FeldArt)wahlFeldArt.getSelectedItem();
		return KartenArt.getFeld(en.getKarte().getArt(),art);
	}
	
	public byte getSpielernummer(){
		return (Byte)wahlSpielernummer.getSelectedItem();
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		Object o=ev.getSource();
		if(o==aktionsButton[0])
			addAktionsReaktion(true,false,
					"Jetzt koennen Sie die gewaehlte Feldart auf der Karte verbreiten.",AktionsArt.FeldArtSetzen);
		if(o==aktionsButton[1])
			addAktionsReaktion(false,false,
					"Jetzt koennen Sie je eine passende Resource pro Feld verbreiten.",AktionsArt.ResourceSetzen);
		if (o==aktionsButton[2])
			addAktionsReaktion(false,false,
					"Jetzt koennen Sie Resourcen von der Karte entfernen.",AktionsArt.ResourceLoeschen);
		if (o==aktionsButton[3])
			addAktionsReaktion(false,true,
					"Jetzt koennen Sie Startposition der gewaehlten Spielernummer auf der Karte definieren.",AktionsArt.SpielerstartSetzen);
		if (o==wahlFeldArt){
			FeldArt art=(FeldArt)wahlFeldArt.getSelectedItem();
			Feld f=KartenArt.getFeld(en.getKarte().getArt(),art);
			en.log("Gewaehlte Feldart: "+art+" "+f.getErlaubteResourcen());			
		}
		if (o==wahlSpielernummer){
			en.log("Gewaehlte Spielernummer: "+wahlSpielernummer.getSelectedItem());			
		}
		if (o==wahlZoom){
			if (en.getKarte()==null) return;
			int zoom=(Integer)wahlZoom.getSelectedItem();
			en.log("Zoomfaktor: "+zoom+"%");
			Parameter.zoomfaktor=zoom;
			en.getKarte().zeichneFelder();
		}
	}

	private void addHeader(String text){
		JLabel x=new JLabel(text);
		x.setFont(new Font("Aral", Font.BOLD, 18));
		add(x);		
	}
	
	private JRadioButton addAktion(ButtonGroup gruppe,String text){
		JRadioButton b=new JRadioButton(text);
		b.addActionListener(this);
		gruppe.add(b); 
		add(b);
		return b;
	}
	
	private void addAktionsReaktion(
			boolean wahlFeldArtEnabled, boolean wahlSpielernummerEnabled,
			String logText,AktionsArt aktionArt){
		wahlFeldArt.setEnabled(wahlFeldArtEnabled);
		wahlSpielernummer.setEnabled(wahlSpielernummerEnabled);
		en.log(logText);
		aktion=aktionArt;
	}
}
