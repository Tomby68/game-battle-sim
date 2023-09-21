package for_pokemon;

public class ElectricType extends Pokemon {

	public ElectricType(String theName) {
		super(theName);
		type = "ELECTRIC";
		weakness = "FIRE";
		switch (name) {
		case "PIKACHU": hp = 12; maxHP = 12; base = 4;
		break;
		case "PLUSLE": hp = 8; maxHP = 8; base = 2;
		break;
		case "ZAPDOS": hp = 15; maxHP = 15; base = 8;
		break;
		default:;
		}
	}
	
	@Override
	public String attack(Pokemon enemy) {
		String toReturn = super.attack(enemy);
		toReturn += this.name + " used lightning bolt for " + damage + " damage! ";
		toReturn += enemy.getAttacked(damage);
		return toReturn;
	}

	
}
