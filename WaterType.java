package for_pokemon;

public class WaterType extends Pokemon{
	
	public WaterType(String theName) {
		super(theName);
		type = "WATER";
		weakness = "ELECTRIC";
		switch (name) {
		case "PIPLUP": hp = 12; maxHP = 12; base = 3;
		break;
		case "OSHAWATT": hp = 15; maxHP = 15; base = 4;
		break;
		case "WAILORD": hp = 30; maxHP = 30; base = 10;
		break;
		default:;
		}
	}
	
	@Override
	public String attack(Pokemon enemy) {
		String toReturn = super.attack(enemy);
		toReturn += this.name + " used wave blast for " + damage + " damage! ";
		toReturn += enemy.getAttacked(damage);
		return toReturn;
	}
}
