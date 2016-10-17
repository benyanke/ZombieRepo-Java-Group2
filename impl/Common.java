package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

public class Common extends Character implements IZombie{
	Common(){
		this(30, 5);
	}
	
	Common(int health, int attack){
		super(health, attack);
	}
	
	@Override
	public void attack(ISurvivor survivor){
		survivor.decreaseHealth(attack);
	}
}
