package for_pokemon;

public class Driver {
	public static void main(String[] args) {
		// fire -> electric -> water -> fire
		
		java.awt.EventQueue.invokeLater(new Runnable() {
		    public void run() {
		        PokemonGUI click = new PokemonGUI();
		    }
		} ); 
	}
}
