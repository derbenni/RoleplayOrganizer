package worlds;

import java.util.ArrayList;

import charakter.SubCharakter;

public class World {

	private String _name;
	private int _id;
	private String _beschreibung; 
	private ArrayList<SubCharakter> _charakterListe;
	
	public World () {
		_charakterListe = new ArrayList<SubCharakter>();
	}
	
	
	
	public void addCharakter(SubCharakter subcharakter) {
		_charakterListe.add(subcharakter);
	}
	
	public void deleteCharakter(SubCharakter subcharakter) {
		_charakterListe.remove(subcharakter);
	}
	
	public ArrayList<SubCharakter> showCharakter() {
		return _charakterListe;
	}
	

	public String get_name() {
		return _name;
	}


	public void set_name(String _name) {
		this._name = _name;
	}


	public int get_id() {
		return _id;
	}


	public void set_id(int _id) {
		this._id = _id;
	}


	public String get_beschreibung() {
		return _beschreibung;
	}


	public void set_beschreibung(String _beschreibung) {
		this._beschreibung = _beschreibung;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
