package gui;

import java.util.ArrayList;

import javax.swing.JPanel;

import charakter.Relevance;
import charakter.SubCharakter;

public class Steckbrief {

	private SteckbriefGUI _gui;

	private SubCharakter _charakter;

	public Steckbrief(SubCharakter charakter) {
		_gui = new SteckbriefGUI();
		setCharakter(charakter);
	}

	public void setCharakter(SubCharakter charakter) {
		_charakter = charakter;
		if (charakter != null) {
			setName(_charakter.get_name());
			setNachname(_charakter.get_nachname());
			setRelevance(_charakter.getRelevance());
			setBeruf(_charakter.get_beruf());
			setAlter(_charakter.get_alter());
			setSternzeichen(_charakter.get_sternzeichen());	
			setHaarfarbe(_charakter.get_haarfarbe());
			setAugenfarbe(_charakter.get_augenfarbe());
			setGroesse(_charakter.get_groesse());
			setBeschreibung(_charakter.get_beschreibung());
			setEigenschaften(_charakter.get_eigenschaften());
			setStory(_charakter.get_story());
			setTags(_charakter.get_tags());

		}

	}

	public void setRelevance(Relevance r) {
		_gui.get_relevance().setText(r.get_name());
	}
	
	public void setGroesse(String n) {
		_gui.get_groesse().setText(n);
	}
	
	public void setHaarfarbe(String n) {
		_gui.get_haarfarbe().setText(n);
	}
	
	public void setAugenfarbe(String n) {
		_gui.get_augenfarbe().setText(n);
	}
	
	public void setBeschreibung(String n) {
		_gui.getBeschreibungsFeld().setText(n);
	}

	public void setEigenschaften(String n) {
		_gui.getEigenschaftsFeld().setText(n);
	}

	public void setStory(String n) {
		_gui.getStoryFeld().setText(n);
	}

	public void setTags(ArrayList<String> list) {
		String inhalt = "";
		for (String s : list) {
			inhalt = inhalt + s + ", ";
		}
		if (inhalt.length() > 0) {
			inhalt = inhalt.substring(0, inhalt.length() - 2);
			_gui.get_tags().setText(inhalt);
		}
	}

	public void setName(String n) {
		_gui.get_name().setText(n);
	}

	public void setNachname(String n) {
		_gui.get_nachname().setText(n);
	}

	public void setBeruf(String n) {
		_gui.get_beruf().setText(n);
	}

	public void setAlter(int n) {
		_gui.get_alter().setText(String.valueOf(n));
	}

	public void setSternzeichen(String n) {
		_gui.get_sternzeichen().setText(n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public JPanel getSteckbriefPanel() {

		return _gui.getPanel();
	}

}
