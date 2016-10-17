package zombiewar.impl;

import zombiewar.intf.ICharacter;
import zombiewar.intf.IZombie;

public abstract class Character implements ICharacter{
	
	public int health;
	public int attack;
	
	Character(int health, int attack){
		this.health = health;
		this.attack = attack;
	}

	@Override
	public void decreaseHealth(int increment) {
		health-=increment;
	}

	@Override
	public boolean isAlive() {
		return (health > 0);
	}
}
