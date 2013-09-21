package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.TabellenSpalte.Typ;

public class Datenbank {

	/**
	 * Die Enums benutzen um Tippfehler beim Tabellennamen zu vermeiden
	 * 
	 * @author benny_000
	 * 
	 */
	private static enum Tables {
		maincharacter, subcharacter, relationships, world, characterpictures, ;
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
	 * Erstellt das Grundgerüst der Datenbank, falls sie noch nicht existiert
	 */
	private void initialisiereDatenbank() {
		String text = "CREATE TABLE IF NOT EXISTS " + Tables.maincharacter.toString()
				+ "(ID INT PRIMARY KEY AUTO_INCREMENT(1,1) NOT NULL, NAME VARCHAR(255))";
		fuereAus(text);
		ArrayList<TabellenSpalte> spalten = new ArrayList<TabellenSpalte>();
		TabellenSpalte idTabelle = new TabellenSpalte("id", Typ.INT, 20);
		idTabelle.setNotNull(true);
		idTabelle.setPrimary(true);
		spalten.add(idTabelle);
		spalten.add(new TabellenSpalte("name", Typ.VARCHAR, 255));
		erstelleTabelle(Tables.maincharacter, spalten);

	}

	/**
	 * Führt einen beliebigen SQL Befehl aus
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
	 * @param name der Name der Tabelle
	 * @param spalten Liste der Spalten als TabellenSpalte
	 */
	private void erstelleTabelle(Tables name, ArrayList<TabellenSpalte> spalten) {
		String text = "CREATE TABLE IF NOT EXISTS " + name.toString() + " (";

		for (TabellenSpalte t : spalten) {
			text = text + t.getText() + ", ";
		}
		text = text.substring(0, text.length() - 2);
		text = text + ")";
		System.out.println(text);
		fuereAus(text);
		gebeTabelleAufKonsoleAus(Tables.maincharacter);
	}

	/**
	 * Löscht eine Tabelle aus der Datenbank
	 * @param tabelle
	 */
	private void loescheTabelle(Tables tabelle) {
		fuereAus("DROP TABLE IF EXISTS " + tabelle);
	}

	/**
	 * Gibt eine vorhandene Tabelle auf der Konsole aus
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
	}
}
