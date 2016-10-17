package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

public class Child extends Character implements ISurvivor {

	Child(){
		this(20, 2);
	}
	
	Child(int health, int attack) {
		super(health, attack);
	}
	
	@Override
	public void attack(IZombie zombie){
		zombie.decreaseHealth(attack);
	}
}
