package gui;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Charakter {

	private String _name;
	private String _nachname;
	private String _alter;
	private String _beruf;
	private String _sternzeichen;
	private String _haarfarbe;
	private String _augenfarbe;
	private String _groesse;
	private String _beschreibung;
	private String _eigenschaften;
	private String _story;
	private ArrayList<Charakter> _beziehungen;
	private ArrayList<Charakter> _familie;
	private ArrayList<String> _tags;
	public ArrayList<String> get_tags() {
		return _tags;
	}

	public void set_tags(ArrayList<String> _tags) {
		this._tags = _tags;
	}

	private ImageIcon _bild;

	public String get_alter() {
		return _alter;
	}

	public String get_augenfarbe() {
		return _augenfarbe;
	}

	public String get_beruf() {
		return _beruf;
	}

	public String get_beschreibung() {
		return _beschreibung;
	}

	public ArrayList<Charakter> get_beziehungen() {
		return _beziehungen;
	}

	public String get_eigenschaften() {
		return _eigenschaften;
	}

	public ArrayList<Charakter> get_familie() {
		return _familie;
	}

	public String get_groesse() {
		return _groesse;
	}

	public String get_haarfarbe() {
		return _haarfarbe;
	}

	public String get_nachname() {
		return _nachname;
	}

	public String get_name() {
		return _name;
	}

	public String get_sternzeichen() {
		return _sternzeichen;
	}

	public String get_story() {
		return _story;
	}

	public void set_alter(String _alter) {
		this._alter = _alter;
	}

	public void set_augenfarbe(String _augenfarbe) {
		this._augenfarbe = _augenfarbe;
	}
	public void set_beruf(String _beruf) {
		this._beruf = _beruf;
	}
	public void set_beschreibung(String _beschreibung) {
		this._beschreibung = _beschreibung;
	}
	public void set_beziehungen(ArrayList<Charakter> _beziehungen) {
		this._beziehungen = _beziehungen;
	}
	public void set_eigenschaften(String _eigenschaften) {
		this._eigenschaften = _eigenschaften;
	}
	public void set_familie(ArrayList<Charakter> _familie) {
		this._familie = _familie;
	}
	public void set_groesse(String _groesse) {
		this._groesse = _groesse;
	}
	public void set_haarfarbe(String _haarfarbe) {
		this._haarfarbe = _haarfarbe;
	}
	public void set_nachname(String _nachname) {
		this._nachname = _nachname;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	public void set_sternzeichen(String _sternzeichen) {
		this._sternzeichen = _sternzeichen;
	}
	public void set_story(String _story) {
		this._story = _story;
	}
	
	public void set_bild(String pfad){
		_bild = new ImageIcon(pfad);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
