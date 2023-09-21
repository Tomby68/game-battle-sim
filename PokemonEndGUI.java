package for_pokemon;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class PokemonEndGUI extends Panel {
	private JPanel pokEnd;
	
	private JTextPane pane1;
	private JTextPane pane2;
	private JTextPane pane3;
	
	public PokemonEndGUI() {
		pokEnd = new JPanel();
		pokEnd.setLayout(new BoxLayout(pokEnd, BoxLayout.Y_AXIS));
		
		
		pane1 = new JTextPane();
		StyledDocument docStyle = pane1.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		docStyle.setParagraphAttributes(0, docStyle.getLength(), center, false);
		pane1.setOpaque(false);
		pane1.setEditable(false);
		
		pane2 = new JTextPane();
		docStyle = pane2.getStyledDocument();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		docStyle.setParagraphAttributes(0, docStyle.getLength(), center, false);
		pane2.setOpaque(false);
		pane2.setEditable(false);
		
		pane3 = new JTextPane();
		pane3.setText("The battle is over. ");
		docStyle = pane3.getStyledDocument();
		StyleConstants.setAlignment(center,  StyleConstants.ALIGN_CENTER);
		docStyle.setParagraphAttributes(0, docStyle.getLength(), center, false);
		pane3.setOpaque(false);
		pane3.setEditable(false);
		
		
		pokEnd.add(pane1);
		pokEnd.add(pane2);
		pokEnd.add(pane3);
	}

	public void setText(String str) {
		pane1.setText(str);
	}
	public void setText2(String str) {
		pane2.setText(str);
	}
	public void appendText3(String str) {
		pane3.setText(pane3.getText() + str);
	}
	
	@Override
	public JPanel getPanel() {
		return pokEnd;
	}

	@Override
	public JPanel getButtons() {
		return pokEnd;
	}
}
