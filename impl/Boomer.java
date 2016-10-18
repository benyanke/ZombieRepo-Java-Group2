package zombiewar.impl;

import intf.ISurvivor;
import intf.IZombie;

public class Boomer extends Character implements IZombie {


	public int health = 60;


	Boomer(int health) {

		this.health = health;

	}


	public void decreaseHealth(int increment) {

		health -= increment;

	}


	public boolean isAlive() {

		return (health > 0);

	}


	public void attack(ISurvivor character) {

		character.decreaseHealth(25);

	}

}​
