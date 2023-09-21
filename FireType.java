package for_pokemon;

public class FireType extends Pokemon {
	
	public FireType(String theName) {
		super(theName);
		type = "FIRE";
		weakness = "WATER";
		switch (name) {
		case "CHARMANDER": hp = 12; maxHP = 12; base = 3;
		break;
		case "CHIMCHAR": hp = 15; maxHP = 15; base = 2;
		break;
		case "CHARIZARD": hp = 25; maxHP = 25; base = 5;
		break;
		default:;
		}
	}
	
	@Override
	public String attack(Pokemon enemy) {
		String toReturn = super.attack(enemy);
		toReturn += this.name + " used fireball for " + damage + " damage! ";
		toReturn += enemy.getAttacked(damage);
		return toReturn;
	}
}
