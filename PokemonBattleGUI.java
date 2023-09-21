package for_pokemon;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class PokemonBattleGUI extends Panel {
	private JPanel battle;
	private JPanel actionButtons;
	
	private JButton attack;
	private JButton heal;
	private JButton checkStats;
	private JButton flee;
	
	private JTextPane pane;
	private JTextPane pane2;
	private JTextPane pane3;
	
	public PokemonBattleGUI() {
		battle = new JPanel();
		battle.setLayout(new BoxLayout(battle, BoxLayout.PAGE_AXIS));
		
		attack = new JButton("ATTACK");
		heal = new JButton("HEAL");
		checkStats = new JButton("CHECK STATS");
		flee = new JButton("RUN AWAY");
		
		actionButtons = new JPanel();
		actionButtons.setLayout(new GridLayout(2, 2));
		actionButtons.add(attack);
		actionButtons.add(heal);
		actionButtons.add(checkStats);
		actionButtons.add(flee);
		
		pane = new JTextPane();
		StyledDocument docStyle = pane.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center,  StyleConstants.ALIGN_CENTER);
		docStyle.setParagraphAttributes(0, docStyle.getLength(), center, false);
		pane.setAlignmentX(Component.CENTER_ALIGNMENT);
		pane.setOpaque(false);
		pane.setEditable(false);
		pane.setMargin(new Insets(5, 5, 5, 5));
		
		pane2 = new JTextPane();
		docStyle = pane2.getStyledDocument();
		StyleConstants.setAlignment(center,  StyleConstants.ALIGN_CENTER);
		docStyle.setParagraphAttributes(0,  docStyle.getLength(), center, false);
		pane2.setAlignmentX(Component.CENTER_ALIGNMENT);
		pane2.setOpaque(false);
		pane2.setEditable(false);
		
		pane3 = new JTextPane();
		docStyle = pane3.getStyledDocument();
		StyleConstants.setAlignment(center,  StyleConstants.ALIGN_CENTER);
		docStyle.setParagraphAttributes(0, docStyle.getLength(), center, false);
		pane3.setAlignmentX(Component.CENTER_ALIGNMENT);
		pane3.setOpaque(false);
		pane3.setEditable(false);
		
		battle.add(pane);
		battle.add(pane2);
		battle.add(actionButtons);
		battle.add(pane3);
	}
	
	@Override
	public JPanel getPanel() {
		return battle;
	}
	
	@Override 
	public JPanel getButtons() {
		return actionButtons;
	}
	
	public void setText(String str) {
		pane.setText(str);
	}
	
	public void setText2(String str) {
		pane2.setText(str);
	}
	
	public void setText3(String str) {
		pane3.setText(str);
	}
	
	public JButton getAttack() {
		return attack;
	}
	
	public JButton getHeal() {
		return heal;
	}
	
	public JButton getCheck() {
		return checkStats;
	}
	
	public JButton getFlee() {
		return flee;
	}
}
