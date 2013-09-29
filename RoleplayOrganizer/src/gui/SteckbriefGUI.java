package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SteckbriefGUI {

	private JPanel _hauptpanel;
	private JTextField _name;
	private JTextField _nachname;
	private JTextField _relevance;
	private JTextField _beruf;
	private JTextField _alter;
	private JTextField _sternzeichen;
	private JLabel _bildLabel;
	private JTextArea _tags;
	private JTextArea _beschreibung;
	private JTextArea _eigenschaften;
	private JTextArea _story;
	private JTextField _haarfarbe;
	private JTextField _augenfarbe;
	private JTextField _groesse;

	private FancyKlappbarePanels _beschreibungsPanel;
	private FancyKlappbarePanels _eigenschaftsPanel;
	private FancyKlappbarePanels _storyPanel;
	private FancyKlappbarePanels _beziehungsPanel;
	private FancyKlappbarePanels _familienPanel;
	private FancyKlappbarePanels _tagPanel;

	public SteckbriefGUI() {
		_hauptpanel = new JPanel();
		BoxLayout box = new BoxLayout(_hauptpanel, BoxLayout.PAGE_AXIS);
		_hauptpanel.setBackground(Color.green);
		_hauptpanel.setLayout(box);
		_hauptpanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		_hauptpanel.add(initialisiereOberesPanel());
		_hauptpanel.add(initialisiereBeschreibungsPanel());
		_hauptpanel.add(initialisiereEigenschaftenPanel());
		_hauptpanel.add(initialisiereStoryPanel());
		_hauptpanel.add(initialisiereTagPanel());
		_hauptpanel.add(initialisiereBeziehungsPanel());
		_hauptpanel.add(initialisiereFamilienPanel());

	}

	public JTextArea get_tags() {
		return _tags;
	}

	public JTextField get_alter() {
		return _alter;
	}

	public JTextField get_beruf() {
		return _beruf;
	}

	public JTextField get_name() {
		return _name;
	}

	public JTextField get_nachname() {
		return _nachname;
	}

	public JTextField get_sternzeichen() {
		return _sternzeichen;
	}

	public JPanel getBeschreibungsPanel() {
		return _beschreibungsPanel.getInhaltsPanel();
	}

	public JPanel getBeziehungsPanel() {
		return _beziehungsPanel.getInhaltsPanel();
	}

	public JPanel getEigenschaftsPanel() {
		return _eigenschaftsPanel.getInhaltsPanel();
	}

	public JPanel getFamilienPanel() {
		return _familienPanel.getInhaltsPanel();
	}

	public JPanel getPanel() {
		return _hauptpanel;
	}

	public JPanel getStoryPanel() {
		return _storyPanel.getInhaltsPanel();
	}

	public JTextArea getBeschreibungsFeld() {
		return _beschreibung;
	}

	public JTextArea getEigenschaftsFeld() {
		return _eigenschaften;
	}

	public JTextArea getStoryFeld() {
		return _story;
	}

	public JTextField get_haarfarbe() {
		return _haarfarbe;
	}

	public JTextField get_augenfarbe() {
		return _augenfarbe;
	}

	public JTextField get_groesse() {
		return _groesse;
	}
	
	public JTextField get_relevance() {
		return _relevance;
	}
	

	private FancyKlappbarePanels initialisiereBeschreibungsPanel() {
		_beschreibungsPanel = new FancyKlappbarePanels("Beschreibung");
		_haarfarbe = new JTextField();
		_augenfarbe = new JTextField();
		_groesse = new JTextField();
		JPanel irgendeinPanel = new JPanel();
		irgendeinPanel.setLayout(new GridLayout(0,1));
		irgendeinPanel.add(_groesse);
		irgendeinPanel.add(_haarfarbe);
		irgendeinPanel.add(_augenfarbe);
		irgendeinPanel.setMaximumSize(new Dimension(500,70));
		_beschreibung = new JTextArea();
		_beschreibung.setPreferredSize(new Dimension(500, 70));
		_beschreibung.setMaximumSize(new Dimension(500,70));
		_beschreibung.setLineWrap(true);
		_beschreibung.setWrapStyleWord(true);
		BoxLayout box = new BoxLayout(_beschreibungsPanel.getInhaltsPanel(),1);
		_beschreibungsPanel.getInhaltsPanel().setLayout(box);
		_beschreibungsPanel.getInhaltsPanel().setAlignmentX(JPanel.CENTER_ALIGNMENT);
		_beschreibungsPanel.getInhaltsPanel().add(irgendeinPanel);
		_beschreibungsPanel.getInhaltsPanel().add(_beschreibung);
		return _beschreibungsPanel;
	}

	private FancyKlappbarePanels initialisiereBeziehungsPanel() {
		_beziehungsPanel = new FancyKlappbarePanels("Beziehungen");
		return _beziehungsPanel;
	}

	private FancyKlappbarePanels initialisiereEigenschaftenPanel() {
		_eigenschaftsPanel = new FancyKlappbarePanels("Eigenschaften");
		_eigenschaften = new JTextArea();
		_eigenschaften.setPreferredSize(new Dimension(500, 70));
		_eigenschaften.setLineWrap(true);
		_eigenschaften.setWrapStyleWord(true);
		BoxLayout box = new BoxLayout(_eigenschaftsPanel.getInhaltsPanel(),1);
		_eigenschaften.setMaximumSize(new Dimension(500, 70));
		_eigenschaftsPanel.getInhaltsPanel().setLayout(box);
		_eigenschaftsPanel.getInhaltsPanel().add(_eigenschaften);
		return _eigenschaftsPanel;
	}

	private FancyKlappbarePanels initialisiereFamilienPanel() {
		_familienPanel = new FancyKlappbarePanels("Familie");
		return _familienPanel;
	}

	private FancyKlappbarePanels initialisiereTagPanel() {
		_tagPanel = new FancyKlappbarePanels("Tags");
		_tags = new JTextArea("Text");
		_tagPanel.getInhaltsPanel().add(_tags);
		return _tagPanel;
	}

	private JPanel initialisiereOberesPanel() {
		JPanel panel = new JPanel(new FlowLayout());
		panel.setAlignmentX(JPanel.LEFT_ALIGNMENT);
		JPanel infoPanel = new JPanel();
		JPanel bildPanel = new JPanel();
		_name = new JTextField("Hansfriederich");
		_nachname = new JTextField("Peter");
		_relevance = new JTextField();
		_beruf = new JTextField("Lümmel");
		_alter = new JTextField("50");
		_sternzeichen = new JTextField("Fische");
		JPanel vollerName = new JPanel(new GridLayout(1, 1));
		vollerName.add(_name);
		vollerName.add(_nachname);
		infoPanel.add(vollerName);
		infoPanel.add(_relevance);
		infoPanel.add(_beruf);
		infoPanel.add(_alter);
		infoPanel.add(_sternzeichen);
		infoPanel.setLayout(new GridLayout(0, 1));
		_bildLabel = new JLabel();
		_bildLabel.setIcon(new ImageIcon("bildplatzhalter.jpg"));
		bildPanel.add(_bildLabel);
		panel.add(infoPanel);
		panel.add(bildPanel);

		return panel;
	}

	private JPanel initialisiereStoryPanel() {
		_storyPanel = new FancyKlappbarePanels("Story");
		_story = new JTextArea();
		_story.setPreferredSize(new Dimension(500, 150));
		_story.setLineWrap(true);
		_story.setWrapStyleWord(true);
		_storyPanel.getInhaltsPanel().add(_story);
		return _storyPanel;
	}

}
