package for_pokemon;

import java.util.Random;

public abstract class Pokemon {
	Random rand = new Random();
	private int randInt = rand.nextInt(5);
	protected String name;
	protected int hp;
	protected int maxHP;
	protected String type;
	protected String weakness;
	protected static boolean inBattle = true;
	protected boolean enemyAction = true;
	protected boolean isEnemy = false;
	protected int base;
	protected int damage;
	private int toHeal = 2;
	
	public Pokemon(String theName) {
		name = theName;
	}
	
	public void setIsEnemy(boolean val) {
		isEnemy = val;
		if (isEnemy) {
			name = "Wild " + name;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public boolean getInBattle() {
		return inBattle;
	}
	
	public int getHP() {
		return hp;
	}
	
	public int getMax() {
		return maxHP;
	}
	
	public String getType() {
		return type;
	}
	
	public String getWeakness() {
		return weakness;
	}
	
	public String attack(Pokemon enemy) {
		String toReturn = "";
		
		if (this.type.equals(enemy.getWeakness())) {
			damage = this.base + rand.nextInt(5);
		} else if (this.type.equals(enemy.getType())) {
			damage = this.base + rand.nextInt(3);
		} else {
			damage = this.base;
		}
		return toReturn;
	}
	
	public String getAttacked(int damage) {
		String toReturn = "";
		if(hp - damage <= 0) {
			hp = 0;
			toReturn += name + " now has " + hp + "hp. ";
			toReturn += name + " has fainted! ";
			inBattle = false;
		} else {
			hp -= damage;
			toReturn += name + " now has " + hp + "hp. ";
		}
		return toReturn;
	}
	
	public String heal() {
		String toReturn = "";
		toHeal += randInt;
		toReturn += name + " healed for " + toHeal + ". ";
		if (hp + toHeal > maxHP) {
			hp = maxHP;
			toReturn += name + " tried to heal past their max health! ";
			toReturn += name + " now has " + hp + "hp. ";
		} else {
			hp += toHeal;
			toReturn += name + " now has " + hp + "hp. ";
		}
		return toReturn;
	}
	public String flee() {
		inBattle = false;
		return name + " ran away!";
	}
	
	public String toString() {
		return name + " is a " + type + " type. " + name + " has a weakness to " + weakness + " types. " 
				+ name + " has\na max hp of " + maxHP + "hp and has " + hp + "hp right now.";
	}
	
	public String makeMove(Pokemon user) {
		String toReturn = "";
		if (this.getHP() <= this.getMax() / 2) {
			if (enemyAction) {
				toReturn += this.heal();
				enemyAction = false;
			} else {
				toReturn += this.attack(user);
				enemyAction = true;
			}
		} else {
			toReturn += this.attack(user);
		}
		return toReturn;
	}
	
	
	//Pokemon should be able to: attack, run away, heal, check stats
}
