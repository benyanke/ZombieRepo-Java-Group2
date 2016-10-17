package impl;

import intf.ISurvivor;
import intf.IZombie;

public class Soldier extends Character implements ISurvivor {
	
	private static int health = 100;
	private static int attackDamage = 10;
	public String name = "Soldier";

	Soldier() {
		super(health);
	}

	@Override
	public void attack(IZombie zombie) {
		zombie.decreaseHealth(attackDamage);
	}
	
	// Added by Ben Yanke for debugging purposes
	@Override
	public String toString() {
		//return "SOLDIER | Health=" + health;
		return "Soldier";
	}
	
	
} //end class
