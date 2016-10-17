package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

public class Student extends Character implements ISurvivor {

	Student(){
		this(40, 3);
	}
	
	Student(int health, int attack) {
		super(health, attack);
	}
	
	@Override
	public void attack(IZombie zombie){
		zombie.decreaseHealth(attack);
	}
}
