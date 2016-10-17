package impl;

import intf.ISurvivor;
import intf.IZombie;

//Charger Class designed by Jessaca Summers

public class Charger extends Character implements IZombie {
	
	Charger() {
		super(80); //80 refers to health
	}

	@Override
	public void attack(ISurvivor target) {
		int whichAttack = (int)(Math.random() * 20);
		if (whichAttack != 13) //95% of the time, just charges into survivors
			target.decreaseHealth(15);
		else //But unlucky number 13 gets slammed into the wall repeatedly
			target.decreaseHealth(75);
	}
	
	// Added by Ben Yanke for debugging purposes
	@Override
	public String toString() {
		//return "CHARGER | Health=" + health;
		return "Charger";
	}
	
	
} //end class
