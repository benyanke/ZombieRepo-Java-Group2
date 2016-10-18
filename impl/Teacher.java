package zombiewar.impl;
package impl;

import zombiewar.intf.IChararacter;
import inf.ICharacter;


public class Teacher extends Character implements ICharacter{

	public static int Health = 50;
	public static int Attack = 5;
	
	Teacher(int Health){
		this.Health = Health;
	}
	
	
	@Override
	public void decreaseHealth(int increment){
		Health-=increment;
	}
	
	public void attack(IZombie character){
		character.health -= Attack;
	}
	
	
	public boolean isAlive(){
		return (Health > 0);
	}
	
}
