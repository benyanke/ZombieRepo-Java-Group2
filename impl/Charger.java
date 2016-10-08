package impl;

import intf.ISurvivor;
import intf.IZombie;

//Charger Class designed by Jessaca Summers

public class Charger extends Character implements IZombie {
	
	Charger() {
		int health = 80;
		super(health);
	}

	@Override
	public void attack(ISurvivor target) {
		int whichAttack = (int)(Math.random() * 20);
		if (whichAttack != 13) //95% of the time, just charges into survivors
			target.decreaseHealth(15);
		else //But unlucky number 13 gets slammed into the wall repeatedly
			target.decreaseHealth(75);
	}
	
} //end class
