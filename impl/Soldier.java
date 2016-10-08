package impl;

import intf.ISurvivor;
import intf.IZombie;

public class Soldier extends Character implements ISurvivor {
	
	private static int health = 100;
	private static int attackDamage = 10;

	Soldier() {
		super(health);
	}

	@Override
	public void attack(IZombie zombie) {
		zombie.decreaseHealth(attackDamage);
	}
	
} //end class