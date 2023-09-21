package for_pokemon;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public abstract class Panel {

	public abstract JPanel getPanel();
	
	public abstract JPanel getButtons();
	
	public void setListeners(ActionListener act) {
		Component[] c = this.getButtons().getComponents();
		for (int i = 0; i < c.length; i++) {
			if (c[i] instanceof JButton) {
				JButton tmp = (JButton) c[i];
				tmp.addActionListener(act);
			}
		}
	}
}
