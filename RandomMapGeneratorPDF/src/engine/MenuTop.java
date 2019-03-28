package engine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import karte.Feld;
import karte.FeldArt;
import karte.Karte;
import karte.KartenArt;
import karte.Position;

public class MenuTop extends JMenuBar implements ActionListener{
	private static final long serialVersionUID = 1L;
	private Engine en;
  private JMenu datei;
  private JMenu hilfe;
  private TreeMap<String,JMenuItem> menus=new TreeMap<String,JMenuItem>();
  
  public MenuTop(Engine en){
  	this.en=en;
    datei=new JMenu("Datei");
    add(datei);
    addMenuItem("datei-neu","neue Karte",datei);
    addMenuItem("datei-laden","Karte laden",datei);
    addMenuItem("datei-speichern","Karte speichern",datei);
    addMenuItem("datei-beenden","Editor beenden",datei);
    hilfe=new JMenu("Hilfe");
    add(hilfe);
    addMenuItem("hilfe-ueber","Ueber",hilfe);
  }
  
  private void addMenuItem(String name,String titel,JMenu hauptmenu){
  	JMenuItem it=new JMenuItem(titel);
    it.addActionListener(this);
    hauptmenu.add(it);
    menus.put(name,it);
  }

	@Override
	public void actionPerformed(ActionEvent ev) {
		Object o=ev.getSource();
		
    if (o==menus.get("datei-neu")){
    	JSpinner spinnerId=new JSpinner(new SpinnerNumberModel(1,1,255,1));
    	JSpinner spinnerX=new JSpinner(new SpinnerNumberModel(30,5,120,1));
    	JSpinner spinnerY=new JSpinner(new SpinnerNumberModel(30,5,120,1));
    	final JComboBox wahlKarteArt=new JComboBox();
    	final JComboBox wahlFeldArt=new JComboBox();
    	for(KartenArt karteArt:KartenArt.values())
  			wahlKarteArt.addItem(karteArt);
	   	for(FeldArt feldArt:KartenArt.getErlaubteFeldarten(KartenArt.Erde))
	   		wahlFeldArt.addItem(feldArt);
  		wahlKarteArt.addActionListener(new ActionListener(){
  			@Override
  			public void actionPerformed(ActionEvent ev) {
  				KartenArt kArt=(KartenArt)wahlKarteArt.getSelectedItem();
  				wahlFeldArt.removeAllItems();
  		   	for(FeldArt feldArt:KartenArt.getErlaubteFeldarten(kArt))
  		   		wahlFeldArt.addItem(feldArt);
  			}
  		});
    	Object[] eingaben={
    			"ID der Karte",spinnerId,
    			"Kartengroesse X",spinnerX,
    			"KartengroesseY",spinnerY,
    			"Kartenart",wahlKarteArt,
  				"Standard-Feldart",wahlFeldArt};
    	JOptionPane eingabe=new JOptionPane(eingaben,JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
    	eingabe.createDialog(en, "Neue Karte erzeugen...").setVisible(true);
    	if ((eingabe.getValue()!=null)&&(eingabe.getValue().equals(JOptionPane.OK_OPTION))){
    		try{
      		KartenArt kArt=(KartenArt)wahlKarteArt.getSelectedItem();
      		FeldArt fArt=(FeldArt)wahlFeldArt.getSelectedItem();
  				en.removeKarte();      		
  				Parameter.spielfeldAnzahlX=Byte.parseByte(""+spinnerX.getValue());
  				Parameter.spielfeldAnzahlY=Byte.parseByte(""+spinnerY.getValue());
  				en.log("Erstelle eine neue Karte mit Breite "+Parameter.spielfeldAnzahlX+", Hoehe "+Parameter.spielfeldAnzahlY+" und Standard-Feldart "+fArt+"...");
  				Karte k=new Karte(Byte.parseByte(""+spinnerId.getValue()),kArt,en);
  				en.setKarte(k);
  				k.initDarstellung(en.getPanel());
  		  	for(byte i=1;i<=Parameter.spielfeldAnzahlX;i++){
  		  		for(byte j=1;j<=Parameter.spielfeldAnzahlY;j++){
  			  		Feld f=KartenArt.getFeld(kArt,fArt);
  			  		f.setKarte(k);
  			  		f.setPosition(new Position(i,j));
  			  		k.initFeld(f);
  			  	}
  		  	}
  		  	en.aktiviereMenu();
  		  	en.getKarte().zeichneFelder();
  				en.validate();
  		  	en.repaint();
  				en.log("OK");
    		}
    		catch (Exception e){
        	JOptionPane.showMessageDialog(
        			en,"Ihre Eingaben sind ungueltig!","Neue Karte erzeugen...",
        			JOptionPane.WARNING_MESSAGE);
        	e.printStackTrace();
    		}
    	}
    }
    
    

		if (o==menus.get("datei-laden")){
	  	en.log("Lade Kartendatei...");
			JFileChooser chooser=new JFileChooser();
			chooser.setAcceptAllFileFilterUsed(false);
			chooser.setFileFilter(new FileNameExtensionFilter("Kartendaten (.map)","map"));
			if (chooser.showOpenDialog(en)==JFileChooser.APPROVE_OPTION) {
				Dateizugriff dz=new Dateizugriff();
				dz.ladenKarte(en, chooser.getSelectedFile().toString());
			}
			else
				en.log("ABGEBROCHEN");
		}
		
		

		if (o==menus.get("datei-speichern")){
	  	en.log("Speichere Kartendatei...");
			JFileChooser chooser=new JFileChooser();
			chooser.setAcceptAllFileFilterUsed(false);
			chooser.setFileFilter(new FileNameExtensionFilter("Kartendaten (.map)","map"));
			if (chooser.showSaveDialog(en)==JFileChooser.APPROVE_OPTION) {
				Dateizugriff dz=new Dateizugriff();
				dz.speichernKarte(en, chooser.getSelectedFile().toString());
			}
			else
				en.log("ABGEBROCHEN");
		}

		if (o==menus.get("datei-beenden")){
			System.exit(0);
		}

    if (o==menus.get("hilfe-ueber")){
    	JOptionPane.showMessageDialog(
    			en,
    			Parameter.titel+"\n\n"+"Copyright by Prof. Dr. Frank Dopatka"+"\n\n"+"Dieser Editor beinhaltet graphische Elemente des Spiels Civilization!"+"\n"+"Er darf daher NICHT veröffentlicht werden!"+"\n"+"Der Editor ist nur fuer den Einsatz in der Lehre bestimmt!",
    			"Ueber WorldOfMKI",
    			JOptionPane.INFORMATION_MESSAGE);
    }
	}
}
