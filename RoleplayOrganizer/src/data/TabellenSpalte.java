package data;

public class TabellenSpalte {
	public enum Typ {
		VARCHAR, INT;
	}

	private String _name;
	private Typ _typ;
	private int _groesse;
	private boolean _notNull;
	private boolean _primaryKey;

	
	/**
	 * Ein TabellenString speichert den Text, der beim erstellen einer Tabelle für eine Spalte benötigt wird. 
	 * @param name der Name der Spalte
	 * @param typ der Datentyp der Spalte
	 * @param groesse die maximale anzahl von Symbolen
	 */
	public TabellenSpalte(String name, Typ typ, int groesse) {
		_name = name;
		_typ = typ;
		_groesse = groesse;
		_notNull = false;
	}

	/**
	 * Legt fest ob ein eintrag in der Spalte leer sein darf
	 * @param value
	 */
	public void setNotNull(boolean value) {
		_notNull = value;
	}
	/**
	 * Legt fest ob die Spalte der Primärschlüssel sein soll
	 * @param value
	 */
	public void setPrimary(boolean value) {
		_primaryKey = value;
	}
	/**
	 * Gibt den Text zum erstellen der Spalte zurück
	 * @return
	 */
	public String getText() {
		String text = _name + " "+ _typ.toString()+"("+_groesse+")";
		if (_primaryKey == true) {
			text = text+ " PRIMARY KEY";
		}
		if (_notNull == true) {
			text  = text+ " NOT NULL";
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
