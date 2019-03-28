package engine;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import karte.Feld;
import karte.Karte;

public class Engine extends JFrame{
	private static final long serialVersionUID = 1L;
	private Karte k;
	private MenuTop menuTop;
	private MenuRechts menuRechts;
	private JPanel panel=new JPanel();
	private JTextArea ta=new JTextArea(6,20);
	private JTextField st=new JTextField("");

	public Engine(){
		super(Parameter.titel);
		setLayout(new BorderLayout());
		panel.setLayout(new BorderLayout());
		menuTop=new MenuTop(this);
		menuRechts=new MenuRechts(this);
		
		// MENUS
		panel.add(menuTop,BorderLayout.NORTH);
		panel.add(menuRechts,BorderLayout.EAST);
		
    // LOGGER
    JPanel logger=new JPanel();
    logger.setLayout(new BorderLayout());
		ta.setFont(new Font("Arial", Font.PLAIN, 11));
		ta.setOpaque(true);
		ta.setEditable(false);
		logger.add(new JScrollPane(ta),BorderLayout.CENTER);
		logger.add(st,BorderLayout.SOUTH);
		panel.add(logger,BorderLayout.SOUTH);

		add(panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(Parameter.aufloesungX,Parameter.aufloesungY);
		setVisible(true);
	}
	
	public void log(String text){
		if (ta.getText().length()==0)
			ta.setText(" "+text);
		else
			ta.setText(ta.getText()+"\n"+" "+text);
	}
	
	public void logClear(){
		ta.setText("");
	}
	
	public void setStatus(String text){
		st.setText(" "+text);
	}
	
	public AktionsArt getAktion(){
		return menuRechts.getAktion();
	}
	
	public Feld getFeld(){
		return menuRechts.getFeld();
	}
	
	public byte getSpielernummer(){
		return menuRechts.getSpielernummer();
	}
	
	public void aktiviereMenu(){
		menuRechts.aktivieren();
	}
	
	public Karte getKarte(){
		return k;
	}
	
	public void setKarte(Karte k){
		this.k=k;
	}
	
	public void removeKarte(){
		if (k==null) return;
		k.terminate();
		if ((panel!=null)&&(k!=null)&&(k.getScroller()!=null)) panel.remove(k.getScroller());
		k=null;
		validate();
  	repaint();
	}
	
	public JPanel getPanel(){
		return panel;
	}
	
	@Override
	public void dispose(){
		System.exit(0);
	}
}