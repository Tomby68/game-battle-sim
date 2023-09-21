package for_pokemon;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class PokemonGUI implements ActionListener {
	Pokemon user;
	Pokemon enemy;
	
	JFrame window;
	
	PokemonStartGUI pokStart;
	PokemonTypeGUI pokChoice;
	PokemonChoiceGUI pok;
	PokemonBattleGUI pokBattle;
	PokemonEndGUI pokEnd;
	//frame 0: Start button, frame 1: Pokemon type choice, frame 2: Pokemon choice
	//frame 3: Action menu, frame 4: "Battle is Over! You win/lose!""
	
	String pType;
	
	public PokemonGUI() {
		
		window = new JFrame("Pokemon Battle Simulator");
		window.setSize(400, 400);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new FlowLayout());

		pokStart = new PokemonStartGUI();
		pokStart.setListeners(this);
		
		window.setContentPane(pokStart.getPanel());
		window.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pokStart.getButton()) {
			pokChoice = new PokemonTypeGUI();
			pokChoice.setListeners(this);
			window.setContentPane(pokChoice.getPanel());
			window.revalidate();
		} else if (e.getSource() == pokChoice.getFButton() || e.getSource() == pokChoice.getWButton() || e.getSource() == pokChoice.getEButton()) {
			pType = e.getActionCommand();
			pok = new PokemonChoiceGUI(pType);
			pok.setListeners(this);
			window.setContentPane(pok.getPanel());
			window.revalidate();
		} else if (e.getSource() == pok.get1Button() || e.getSource() == pok.get2Button() || e.getSource() == pok.get3Button()) {
			String pokemon = e.getActionCommand();
			switch (pType) { 
			case "FIRE": user = new FireType(pokemon); break;
			case "WATER": user = new WaterType(pokemon); break;
			case "ELECTRIC": user = new ElectricType(pokemon); break;
			default:;
			}
			enemy = pok.chooseRandomPok();
			enemy.setIsEnemy(true);
			pokBattle = new PokemonBattleGUI();
			pokBattle.setListeners(this);
			pokBattle.setText("You encountered a " + enemy.getName() + "!");
			pokBattle.setText2("What will your " + user.getName() + " do next?");
			window.setContentPane(pokBattle.getPanel());
			window.revalidate();
		} else if (e.getSource() == pokBattle.getAttack()) {
			String userAction = user.attack(enemy);
			pokBattle.setText(userAction);
			String enemyAction = enemy.makeMove(user);
			pokBattle.setText2(enemyAction);
			pokBattle.setText3("");
			if (!user.getInBattle()) {
				pokEnd = new PokemonEndGUI();
				pokEnd.setListeners(this);
				pokEnd.setText(userAction);
				if (user.getHP() == 0) {
					pokEnd.setText2(enemyAction);
					pokEnd.appendText3(" You lost.");
				} else {
					pokEnd.appendText3(" You win!");
				}
				window.setContentPane(pokEnd.getPanel());
				window.revalidate();
			}
			
		} else if (e.getSource() == pokBattle.getHeal()) {
			String userAction = user.heal();
			pokBattle.setText(userAction);
			String enemyAction = enemy.makeMove(user);
			pokBattle.setText2(enemyAction);
			pokBattle.setText3("");
			if (!user.getInBattle()) {
				pokEnd = new PokemonEndGUI();
				pokEnd.setListeners(this);
				pokEnd.setText(userAction);
				pokEnd.setText2(enemyAction);
				pokEnd.appendText3(" You lost.");
				window.setContentPane(pokEnd.getPanel());
				window.revalidate();
			}
		} else if (e.getSource() == pokBattle.getCheck()) {
			pokBattle.setText3(user.toString());
			window.revalidate();
		} else if (e.getSource() == pokBattle.getFlee()) {
			pokEnd = new PokemonEndGUI();
			pokEnd.setListeners(this);
			pokEnd.setText(user.flee());
			window.setContentPane(pokEnd.getPanel());
			window.revalidate();
		}
	}
	
}
