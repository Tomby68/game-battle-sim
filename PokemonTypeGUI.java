package for_pokemon;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.*;

public class PokemonTypeGUI extends Panel {
	private JPanel pokChoice;
	private JPanel pokTypes;
	
	private JLabel text;
	
	private JButton fireB;
	private JButton waterB;
	private JButton elecB;
	
	public PokemonTypeGUI() {
		pokChoice = new JPanel();
		pokChoice.setLayout(new BoxLayout(pokChoice, BoxLayout.PAGE_AXIS));
		
		pokTypes = new JPanel();
		pokTypes.setLayout(new FlowLayout());
		
		fireB = new JButton("FIRE");
		waterB = new JButton("WATER");
		elecB = new JButton("ELECTRIC");
		
		pokTypes.add(fireB);
		pokTypes.add(waterB);
		pokTypes.add(elecB);
		
		text = new JLabel("What type of Pokemon do you want?");
		text.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		pokChoice.add(text);
		pokChoice.add(pokTypes);
	}
	
	@Override
	public JPanel getButtons() {
		return pokTypes;
	}
	public JPanel getPanel() {
		return pokChoice;
	}
	
	public JButton getFButton() {
		return fireB;
	}
	public JButton getWButton() {
		return waterB;
	}
	public JButton getEButton() {
		return elecB;
	}
}
