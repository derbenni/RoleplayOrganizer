package charakter;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class SubCharakter extends MainCharakter {

	private String _beruf;
	private String _beschreibung;
	private String _eigenschaften;
	private String _story;
	private int _ursprungsid;
	private int _weltid;
	private ArrayList<Relationship> _beziehungen;
	private ArrayList<Relationship> _familienbeziehungen;
	private ArrayList<String> _tags;
	private Relevance _relevance;

	public SubCharakter() {
		_beziehungen = new ArrayList<Relationship>();
		_tags = new ArrayList<String>();
		_relevance = new Relevance();
		_relevance.set_id(1);
	}

	public void set_relevance(Relevance relevance) {
		_relevance = relevance;
	}

	public Relevance getRelevance() {
		return _relevance;
	}

	public ArrayList<String> get_tags() {
		return _tags;
	}

	public void set_tags(ArrayList<String> _tags) {
		this._tags = _tags;
	}

	private ImageIcon _bild;

	public String get_beruf() {
		return _beruf;
	}

	public String get_beschreibung() {
		return _beschreibung;
	}

	public ArrayList<Relationship> get_beziehungen() {
		return _beziehungen;
	}

	public ArrayList<Relationship> get_familienbeziehungen() {
		return _familienbeziehungen;
	}

	public String get_eigenschaften() {
		return _eigenschaften;
	}

	public String get_story() {
		return _story;
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

	public void set_familienbeziehungen(ArrayList<Relationship> _familienbeziehungen) {
		this._familienbeziehungen = _familienbeziehungen;
	}

	public void set_eigenschaften(String _eigenschaften) {
		this._eigenschaften = _eigenschaften;
	}

	public void set_story(String _story) {
		this._story = _story;
	}

	public void set_bild(String pfad) {
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

	public int get_weltid() {
		return _weltid;
	}

	public void set_weltid(int _weltid) {
		this._weltid = _weltid;
	}

}
