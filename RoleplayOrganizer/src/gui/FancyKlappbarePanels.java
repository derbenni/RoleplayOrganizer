package gui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FancyKlappbarePanels extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel _feldName;
	private JPanel _inhalt;

	public FancyKlappbarePanels(String name){
		this.setBackground(Color.red);
		BoxLayout box = new BoxLayout(this, BoxLayout.PAGE_AXIS);
		this.setLayout(box);
		this.setAlignmentX(LEFT_ALIGNMENT);
		_feldName = new JLabel(name);
		_feldName.setAlignmentX(CENTER_ALIGNMENT);
		_inhalt = new JPanel();
		_inhalt.setBackground(Color.yellow);
		this.add(_feldName);
		this.add(_inhalt);
	}
	
	public JPanel getInhaltsPanel(){
		return _inhalt;
	}
	
}
