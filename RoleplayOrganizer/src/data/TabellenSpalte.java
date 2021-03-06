package data;

public class TabellenSpalte {
	public enum Typ {
		VARCHAR, INT, TEXT;
	}

	private String _name;
	private Typ _typ;
	private int _groesse;
	private boolean _notNull;
	private boolean _primaryKey;
	private boolean _autoInk;

	/**
	 * Ein TabellenString speichert den Text, der beim erstellen einer Tabelle
	 * f�r eine Spalte ben�tigt wird.
	 * 
	 * @param name
	 *            der Name der Spalte
	 * @param typ
	 *            der Datentyp der Spalte
	 * @param groesse
	 *            die maximale anzahl von Symbolen
	 */
	public TabellenSpalte(String name, Typ typ, int groesse) {
		_name = name;
		_typ = typ;
		_groesse = groesse;
		_notNull = false;
	}

	/**
	 * Legt fest ob ein eintrag in der Spalte leer sein darf
	 * 
	 * @param value
	 */
	public void setNotNull(boolean value) {
		_notNull = value;
	}

	/**
	 * Legt fest ob der Wert automatisch zugewiesen werden soll
	 * 
	 * @param value
	 */
	public void setAutoInk(boolean value) {
		_autoInk = value;
	}

	/**
	 * Legt fest ob die Spalte der Prim�rschl�ssel sein soll
	 * 
	 * @param value
	 */
	public void setPrimary(boolean value) {
		_primaryKey = value;
	}

	/**
	 * Gibt den Text zum erstellen der Spalte zur�ck
	 * 
	 * @return
	 */
	public String getText() {
		String text = "";
		if ((_typ.equals(Typ.TEXT))||(_typ.equals(Typ.INT))) {
			text = _name + " " + _typ.toString();
		} else {
			text = _name + " " + _typ.toString() + "(" + _groesse + ")";
		}

		if (_primaryKey == true) {
			text = text + " PRIMARY KEY";
		}
		if (_notNull == true) {
			text = text + " NOT NULL";
		}
		if (_autoInk == true) {
			text = text + " AUTO_INCREMENT";
		}

		return text;
	}

	public static void main(String args[]) {
		TabellenSpalte s = new TabellenSpalte("Name", Typ.VARCHAR, 255);
		s.setNotNull(false);
		s.setPrimary(false);
		System.out.println(s.getText());
	}
}
