package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import charakter.Relationship;
import charakter.SubCharakter;
import data.TabellenSpalte.Typ;

public class Datenbank {

	/**
	 * Die Enums benutzen um Tippfehler beim Tabellennamen zu vermeiden
	 * 
	 * @author benny_000
	 * 
	 */
	private static enum Tables {
		maincharacter, subcharacter, relationships, relationshiptype, world, characterpictures, ;
	}

	private String _dbName;
	private Connection _conn;

	public Datenbank() {
		_dbName = "data/RPODB";
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialisiereDatenbank();
	}

	/**
	 * Erstellt das Grundger�st der Datenbank, falls sie noch nicht existiert
	 */
	private void initialisiereDatenbank() {
		// String text = "CREATE TABLE IF NOT EXISTS " +
		// Tables.maincharacter.toString()
		// +
		// "(ID INT PRIMARY KEY AUTO_INCREMENT(1,1) NOT NULL, NAME VARCHAR(255))";
		// fuereAus(text);
		initialisiereMaincharacter();
		initialisiereSubcharacter();
		initialisiereRelationships();
		initialisiereRelationshipType();
		initialisiereWorld();
		initialisiereCharacterpictures();

	}

	private void initialisiereRelationshipType() {
		ArrayList<TabellenSpalte> spalten = new ArrayList<TabellenSpalte>();
		TabellenSpalte idTabelle = new TabellenSpalte("id", Typ.INT, 20);
		idTabelle.setPrimary(true);
		idTabelle.setAutoInk(true);
		spalten.add(idTabelle);
		spalten.add(new TabellenSpalte("beziehungsname", Typ.VARCHAR, 255));
		spalten.add(new TabellenSpalte("beziehungsicon", Typ.VARCHAR, 255));
		spalten.add(new TabellenSpalte("beziehungsbeschreibung", Typ.TEXT, 0));
		erstelleTabelle(Tables.relationshiptype, spalten);

	}

	private void initialisiereCharacterpictures() {
		ArrayList<TabellenSpalte> spalten = new ArrayList<TabellenSpalte>();
		TabellenSpalte idTabelle = new TabellenSpalte("id", Typ.INT, 20);
		idTabelle.setPrimary(true);
		idTabelle.setAutoInk(true);
		spalten.add(idTabelle);
		spalten.add(new TabellenSpalte("refid", Typ.INT, 20));
		spalten.add(new TabellenSpalte("speicherort", Typ.VARCHAR, 255));
		erstelleTabelle(Tables.characterpictures, spalten);

	}

	private void initialisiereWorld() {
		ArrayList<TabellenSpalte> spalten = new ArrayList<TabellenSpalte>();
		TabellenSpalte idTabelle = new TabellenSpalte("id", Typ.INT, 20);
		idTabelle.setPrimary(true);
		idTabelle.setAutoInk(true);
		spalten.add(idTabelle);
		spalten.add(new TabellenSpalte("name", Typ.VARCHAR, 255));
		spalten.add(new TabellenSpalte("beschreibung", Typ.TEXT, 0));
		erstelleTabelle(Tables.world, spalten);

	}

	private void initialisiereRelationships() {
		ArrayList<TabellenSpalte> spalten = new ArrayList<TabellenSpalte>();
		TabellenSpalte idTabelle = new TabellenSpalte("id", Typ.INT, 20);
		idTabelle.setPrimary(true);
		idTabelle.setAutoInk(true);
		spalten.add(idTabelle);
		spalten.add(new TabellenSpalte("id1", Typ.INT, 20));
		spalten.add(new TabellenSpalte("id2", Typ.INT, 20));
		spalten.add(new TabellenSpalte("beziehungsid", Typ.INT, 20));
		erstelleTabelle(Tables.relationships, spalten);

	}

	private void initialisiereSubcharacter() {
		ArrayList<TabellenSpalte> spalten = new ArrayList<TabellenSpalte>();
		TabellenSpalte idTabelle = new TabellenSpalte("id", Typ.INT, 20);
		idTabelle.setPrimary(true);
		idTabelle.setAutoInk(true);
		spalten.add(idTabelle);
		spalten.add(new TabellenSpalte("refid", Typ.INT, 20));
		spalten.add(new TabellenSpalte("name", Typ.VARCHAR, 255));
		spalten.add(new TabellenSpalte("nachname", Typ.VARCHAR, 255));
		spalten.add(new TabellenSpalte("geschlecht", Typ.VARCHAR, 255));
		spalten.add(new TabellenSpalte("geburtsdatum", Typ.VARCHAR, 255));
		spalten.add(new TabellenSpalte("sternzeichen", Typ.VARCHAR, 255));
		spalten.add(new TabellenSpalte("haarfarbe", Typ.VARCHAR, 255));
		spalten.add(new TabellenSpalte("augenfarbe", Typ.VARCHAR, 255));
		spalten.add(new TabellenSpalte("groesse", Typ.VARCHAR, 255));
		spalten.add(new TabellenSpalte("beruf", Typ.VARCHAR, 255));
		spalten.add(new TabellenSpalte("beschreibung", Typ.TEXT, 0));
		spalten.add(new TabellenSpalte("eigenschaften", Typ.TEXT, 0));
		spalten.add(new TabellenSpalte("story", Typ.TEXT, 0));
		spalten.add(new TabellenSpalte("weltid", Typ.INT, 20));
		erstelleTabelle(Tables.subcharacter, spalten);

	}

	public void addSubCharakter(SubCharakter subcharakter) {
		String text = "INSERT INTO " + Tables.subcharacter
				+ "(refid,name,nachname,geschlecht,geburtsdatum,sternzeichen,haarfarbe,augenfarbe,"
				+ "groesse,beruf,beschreibung,eigenschaften,story,weltid)" + " VALUES("
				+ subcharakter.get_ursprungsid() + ", '" + subcharakter.get_name() + "', '"
				+ subcharakter.get_nachname() + "', '" + subcharakter.get_geschlecht() + "', '"
				+ subcharakter.get_geburtsdatum() + "', '" + subcharakter.get_sternzeichen() + "', '"
				+ subcharakter.get_haarfarbe() + "', '" + subcharakter.get_augenfarbe() + "', '"
				+ subcharakter.get_groesse() + "', '" + subcharakter.get_beruf() + "', '"
				+ subcharakter.get_beschreibung() + "', '" + subcharakter.get_eigenschaften() + "', '"
				+ subcharakter.get_story() + "', " + subcharakter.get_weltid() + ")";
		fuereAus(text);

		for (Relationship relationship : subcharakter.get_beziehungen()) {
			text = "INSERT INTO " + Tables.relationships + "(id1,id2,beziehungsid)" + " VALUES("
					+ relationship.get_id1() + ", " + relationship.get_id2() + ", "
					+ relationship.get_beziehungstypid() + ")";
			fuereAus(text);
		}

	}

	public SubCharakter getSubCharakter(int id) {
		SubCharakter charakter = new SubCharakter();
		try {
			_conn = DriverManager.getConnection("jdbc:h2:" + _dbName, "", "");
			Statement statement = _conn.createStatement();
			ResultSet rset = statement.executeQuery("SELECT * FROM " + Tables.subcharacter.toString()
					+ " WHERE refid = " + id);
			rset.next();
			charakter.set_ursprungsid(rset.getInt(2));
			charakter.set_name(rset.getString(3));
			charakter.set_nachname(rset.getString(4));
			charakter.set_geschlecht(rset.getString(5));
			charakter.set_geburtsdatum(rset.getString(6));
			charakter.set_sternzeichen(rset.getString(7));
			charakter.set_haarfarbe(rset.getString(8));
			charakter.set_augenfarbe(rset.getString(9));
			charakter.set_groesse(rset.getString(10));
			charakter.set_beruf(rset.getString(11));
			charakter.set_beschreibung(rset.getString(12));
			charakter.set_eigenschaften(rset.getString(13));
			charakter.set_story(rset.getString(14));
			charakter.set_weltid(rset.getInt(15));

			_conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (_conn != null)
				try {
					_conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return charakter;
	}

	private void initialisiereMaincharacter() {
		ArrayList<TabellenSpalte> spalten = new ArrayList<TabellenSpalte>();
		TabellenSpalte idTabelle = new TabellenSpalte("id", Typ.INT, 20);
		idTabelle.setPrimary(true);
		idTabelle.setAutoInk(true);
		spalten.add(idTabelle);
		spalten.add(new TabellenSpalte("name", Typ.VARCHAR, 255));
		spalten.add(new TabellenSpalte("nachname", Typ.VARCHAR, 255));
		spalten.add(new TabellenSpalte("geschlecht", Typ.VARCHAR, 255));
		spalten.add(new TabellenSpalte("geburtsdatum", Typ.VARCHAR, 255));
		spalten.add(new TabellenSpalte("sternzeichen", Typ.VARCHAR, 255));
		spalten.add(new TabellenSpalte("haarfarbe", Typ.VARCHAR, 255));
		spalten.add(new TabellenSpalte("augenfarbe", Typ.VARCHAR, 255));
		spalten.add(new TabellenSpalte("groesse", Typ.VARCHAR, 255));
		erstelleTabelle(Tables.maincharacter, spalten);
	}

	public void addRelationshipType(String beziehungsname, String beziehungsicon, String beziehungsbeschreibung) {
		String text = "INSERT INTO " + Tables.relationshiptype
				+ "(beziehungsname,beziehungsicon,beziehungsbeschreibung)" + " VALUES(" + beziehungsname + ", '"
				+ beziehungsicon + ", '" + beziehungsbeschreibung + ")";
		fuereAus(text);
	}

	/**
	 * F�hrt einen beliebigen SQL Befehl aus
	 * 
	 * @param text
	 */
	private void fuereAus(String text) {
		// String text = "INSERT INTO maincharacter VALUES(1,'peter')";
		try {
			_conn = DriverManager.getConnection("jdbc:h2:" + _dbName, "", "");
			Statement stmt = _conn.createStatement();
			stmt.executeUpdate(text);
			_conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (_conn != null)
				try {
					_conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}

	/**
	 * Erstellt eine Tabelle
	 * 
	 * @param name
	 *            der Name der Tabelle
	 * @param spalten
	 *            Liste der Spalten als TabellenSpalte
	 */
	private void erstelleTabelle(Tables name, ArrayList<TabellenSpalte> spalten) {
		String text = "CREATE TABLE IF NOT EXISTS " + name.toString() + " (";

		for (TabellenSpalte t : spalten) {
			text = text + t.getText() + ", ";
		}
		text = text.substring(0, text.length() - 2);
		text = text + ")";
		// System.out.println(text);
		fuereAus(text);
	}

	/**
	 * L�scht eine Tabelle aus der Datenbank
	 * 
	 * @param tabelle
	 */
	private void loescheTabelle(Tables tabelle) {
		fuereAus("DROP TABLE IF EXISTS " + tabelle);
	}

	/**
	 * Gibt eine vorhandene Tabelle auf der Konsole aus
	 * 
	 * @param table
	 */
	public void gebeTabelleAufKonsoleAus(Tables table) {

		try {
			_conn = DriverManager.getConnection("jdbc:h2:" + _dbName, "", "");
			Statement statement = _conn.createStatement();
			ResultSet rset = statement.executeQuery("SELECT * FROM " + table.toString());
			int spalten = rset.getMetaData().getColumnCount();
			while (rset.next()) {
				String str = "";
				for (int k = 1; k <= spalten; ++k) {
					str = str + rset.getString(k) + "-";
				}
				str = str.substring(0, str.length() - 1);
				System.out.println(str);
			}

			_conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (_conn != null)
				try {
					_conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}

	public static void main(String[] a) throws Exception {
		Datenbank data = new Datenbank();
		SubCharakter derbenni = new SubCharakter();
		derbenni.set_alter("21");
		derbenni.set_geschlecht("M���NLICH");
		derbenni.set_augenfarbe("braun");
		derbenni.set_beruf("Student");
		derbenni.set_beschreibung("Der Benni sieht total gut aus, und beobachtet sich f�r gew�hnlich selbst gerne in Spiegeln. Deswegen stehen in seinem Zimmer auch 20 Spiegel an jeder Seite. Kann ich verstehen.");
		derbenni.set_bild("bildplatzhalter.jpg");
		derbenni.set_eigenschaften("Der Benni ist sehr hilfsbereit und kann total gut programmieren. Er kann au�erdem toll singen. Und ich glaube er kann noch viele weitere Dinge die ich noch nicht gesehen habe, aber das werde ich noch herausfinden! Er kann wie ein Dinosaurier schreien und auch wie ein Vogel. Er sammelt M�NNLICHE FILME. Und er spielt M�NNLICHE SPIELE.");
		derbenni.set_sternzeichen("Skorpion");
		derbenni.set_groesse("2,50");
		derbenni.set_haarfarbe("Blau");
		derbenni.set_nachname("von Wollmer");
		derbenni.set_name("DER Benni");
		derbenni.set_weltid(42);
		derbenni.set_story("Eines Tages wurde Benni gefragt, ob er coole Smileys kennt. Daraufhin fragte er Wat und war dennoch sehr hilfsbereit. Dann ging er weg, und kramte hinter seinem Sofa nach Dingen. Man h�rte es knistern. Und dann fragte er mich, ob ich an meinen Nulltagen nur Wasser trinke, woraufhin ich genickt habe. Und er bot mir an, dass ich dennoch andere Dinge trinken k�nnte wenn ich es wollte. Das war sehr nett von ihm. Er glaubte, dass das Flugzeug abst�rzt, deswegen sah er aus dem Fenster, aber er sah nichts. W�hrrenddessen trank er gen�sslich seine Cola und stellte fest, dass seine Nachbarn was kochten. Er nahm sich eine sehr m�nnliche Hantel und stellte sich vor den Spiegel.");
		ArrayList<Relationship> beziehung = new ArrayList<Relationship>();
		beziehung.add(new Relationship(0, 3, 12));
		derbenni.set_beziehungen(beziehung);
		ArrayList<String> liste = new ArrayList<String>();
		liste.add("#yolo");
		liste.add("#swag");
		liste.add("#gangser");
		liste.add("#thug live");
		liste.add("#money");
		liste.add("#$$$");
		derbenni.set_tags(liste);
		data.addSubCharakter(derbenni);
		data.gebeTabelleAufKonsoleAus(Tables.subcharacter);
		SubCharakter chara = data.getSubCharakter(0);
		data.gebeTabelleAufKonsoleAus(Tables.relationships);
	}
}
