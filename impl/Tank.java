package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

public class Tank extends Character implements IZombie{
	Tank(){
		this(150, 20);
	}
	
	Tank(int health, int attack){
		super(health, attack);
	}
	
	@Override
	public void attack(ISurvivor survivor){
		survivor.decreaseHealth(attack);
	}
}
