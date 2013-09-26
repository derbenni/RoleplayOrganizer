package charakter;

public class Relationship {

	private int _id1;
	private int _id2;

	private int _beziehungstypid;
	private String _beziehungsname;
	private String _beschreibung;
	private String _bildpfad;

	public Relationship(int id1, int id2, int beziehungstypid) {
		_id1 = id1;
		_id2 = id2;
		_beziehungstypid = beziehungstypid;
	}
	
	public int get_id1() {
		return _id1;
	}

	public void set_id1(int _id1) {
		this._id1 = _id1;
	}

	public int get_id2() {
		return _id2;
	}

	public void set_id2(int _id2) {
		this._id2 = _id2;
	}

	public String get_beschreibung() {
		return _beschreibung;
	}

	public void set_beschreibung(String _beschreibung) {
		this._beschreibung = _beschreibung;
	}

	public String get_bildpfad() {
		return _bildpfad;
	}

	public void set_bildpfad(String _bildpfad) {
		this._bildpfad = _bildpfad;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String get_beziehungsname() {
		return _beziehungsname;
	}

	public void set_beziehungsname(String _beziehungsname) {
		this._beziehungsname = _beziehungsname;
	}

	public int get_beziehungstypid() {
		return _beziehungstypid;
	}

	public void set_beziehungstypid(int _beziehungstypid) {
		this._beziehungstypid = _beziehungstypid;
	}

}
