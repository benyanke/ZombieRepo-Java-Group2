package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

public class Soldier extends Character implements ISurvivor {

	Soldier(){
		this(100, 10);
	}
	
	Soldier(int health, int attack) {
		super(health, attack);
	}
	
	@Override
	public void attack(IZombie zombie){
		zombie.decreaseHealth(attack);
	}
}
