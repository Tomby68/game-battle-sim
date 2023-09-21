package for_pokemon;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PokemonStartGUI extends Panel {
	private JPanel pokStart;
	private JButton startB;
	private JLabel text;
	
	public PokemonStartGUI() {
		pokStart = new JPanel();
		pokStart.setLayout(new BoxLayout(pokStart, BoxLayout.Y_AXIS));
		startB = new JButton("Start");
		startB.setAlignmentX(Component.CENTER_ALIGNMENT);
		text = new JLabel("Press \"START\" to begin");
		text.setAlignmentX(Component.CENTER_ALIGNMENT);
		pokStart.add(Box.createRigidArea(new Dimension(0, 15)));
		pokStart.add(text);
		pokStart.add(Box.createRigidArea(new Dimension(0, 15)));
		pokStart.add(startB);
	}
	
	public JPanel getPanel() {
		return pokStart;
	}
	
	public JButton getButton() {
		return startB;
	}
	
	public void setButtonListener(ActionListener act) {
		startB.addActionListener(act);
	}

	@Override
	public JPanel getButtons() {
		return pokStart;
	}
	
}
