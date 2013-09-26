package charakter;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class SubCharakter {

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
	private String _geburtsdatum;	
	private int _ursprungsid;
	private int _weltid;
	private String _geschlecht;
	private ArrayList<Relationship> _beziehungen;
	private ArrayList<String> _tags;
	
	public SubCharakter() {
		_beziehungen = new ArrayList<Relationship>();
		_tags = new ArrayList<String>();
	}
	
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

	public ArrayList<Relationship> get_beziehungen() {
		return _beziehungen;
	}

	public String get_eigenschaften() {
		return _eigenschaften;
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
	public void set_beziehungen(ArrayList<Relationship> _beziehungen) {
		this._beziehungen = _beziehungen;
	}
	public void set_eigenschaften(String _eigenschaften) {
		this._eigenschaften = _eigenschaften;
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

	public int get_ursprungsid() {
		return _ursprungsid;
	}

	public void set_ursprungsid(int _ursprungsid) {
		this._ursprungsid = _ursprungsid;
	}

	public String get_geburtsdatum() {
		return _geburtsdatum;
	}

	public void set_geburtsdatum(String _geburtsdatum) {
		this._geburtsdatum = _geburtsdatum;
	}

	public int get_weltid() {
		return _weltid;
	}

	public void set_weltid(int _weltid) {
		this._weltid = _weltid;
	}

	public String get_geschlecht() {
		return _geschlecht;
	}

	public void set_geschlecht(String _geschlecht) {
		this._geschlecht = _geschlecht;
	}

}
