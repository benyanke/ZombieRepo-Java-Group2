package impl;

import intf.ICharacter;

public abstract class Character implements ICharacter{
	
	public int health;
	

	Character(){
		this.health = 100;
	}

	Character(int health){
		this.health = health;
	}

	@Override
	public void decreaseHealth(int increment) {
		health-=increment;
	}

	@Override
	public boolean isAlive() {
		return (health > 0);
	}
	
	// Added by Ben Yanke for debugging purposes
	@Override
	public String toString() {
		return "CHARACTER | Health=" + health;
	}
	
}
