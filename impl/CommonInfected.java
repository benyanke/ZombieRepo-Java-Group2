package impl;

import intf.ISurvivor;
import intf.IZombie;

public class CommonInfected extends Character implements IZombie {

    CommonInfected() {
        int health = 30;
        super(health);
    }

    @Override
    public void attack(ISurvivor target) {
        target.decreaseHealth(5);
    }

}