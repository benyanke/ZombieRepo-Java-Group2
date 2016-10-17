package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

public class Predator extends Character implements IZombie{
	Predator(){
		this(75, 25);
	}
	
	Predator(int health, int attack){
		super(health, attack);
	}
	
	@Override
	public void attack(ISurvivor survivor){
		survivor.decreaseHealth(attack);
	}
}
