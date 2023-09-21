package for_pokemon;

import java.awt.Component;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PokemonChoiceGUI extends Panel {
	private JPanel pok;
	private JPanel pokButtons;
	private JButton pok1;
	private JButton pok2;
	private JButton pok3;
	private JLabel text;
	private JLabel text2;
	
	public PokemonChoiceGUI(String type) {
		pok = new JPanel();
		pok.setLayout(new BoxLayout(pok, BoxLayout.PAGE_AXIS));
		
		switch (type) {
		case "FIRE": pok1 = new JButton("CHARMANDER"); pok2 = new JButton("CHIMCHAR"); pok3 = new JButton("CHARIZARD");
		break;
		case "WATER": pok1 = new JButton("PIPLUP"); pok2 = new JButton("OSHAWATT"); pok3 = new JButton("WAILORD");
		break;
		case "ELECTRIC": pok1 = new JButton("PIKACHU"); pok2 = new JButton("PLUSLE"); pok3 = new JButton("ZAPDOS");
		break;
		default:;
		}
		
		pokButtons = new JPanel();
		pokButtons.add(pok1);
		pokButtons.add(pok2);
		pokButtons.add(pok3);
		
		
		text = new JLabel("Alright, a " + type + " type Pokemon!");
		text.setAlignmentX(Component.CENTER_ALIGNMENT);
		text2 = new JLabel("Which " + type + " type Pokemon do you want?");
		text2.setAlignmentX(Component.CENTER_ALIGNMENT);
		pok.add(text);
		pok.add(text2);
		pok.add(pokButtons);
	}
	
	public JButton get1Button() {
		return pok1;
	}
	public JButton get2Button() {
		return pok2;
	}
	public JButton get3Button() {
		return pok3;
	}
	
	@Override
	public JPanel getPanel() {
		return pok;
	}
	
	public Pokemon chooseRandomPok() {
		Random rand = new Random();
		int randInt = rand.nextInt(9);
		Pokemon enemy = null;
		switch (randInt) {
		case 0: {enemy = new WaterType("PIPLUP");}; 
		break;
		case 1: {enemy = new WaterType("OSHAWATT");}; 
		break;
		case 2: {enemy = new WaterType("WAILORD");}; 
		break;
		case 3: {enemy = new FireType("CHARMANDER");}; 
		break;
		case 4: {enemy = new FireType("CHIMCHAR");}; 
		break;
		case 5: {enemy = new FireType("CHARIZARD");}; 
		break;
		case 6: {enemy = new ElectricType("PIKACHU");}; 
		break;
		case 7: {enemy = new ElectricType("PLUSLE");}; 
		break;
		case 8: {enemy = new ElectricType("ZAPDOS");}; 
		break;
		}
		return enemy;
	}
	
	@Override
	public JPanel getButtons() {
		return pokButtons;
	}
	
	
}
