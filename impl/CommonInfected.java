package impl;

import intf.ISurvivor;
import intf.IZombie;

public class CommonInfected extends Character implements IZombie {
    static int health = 30;
    CommonInfected() {
        super(health);
    }

    @Override
    public void attack(ISurvivor target) {
        target.decreaseHealth(5);
    }
    
	// Added by Ben Yanke for debugging purposes
	@Override
	public String toString() {
		return "CommonInfected | Health=" + health;
	}

}
