package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

	public class Teacher extends Character implements ISurvivor {

		Teacher(){
			this(50, 2);
		}
		
		Teacher(int health, int attack) {
			super(health, attack);
		}
		
		@Override
		public void attack(IZombie zombie){
			zombie.decreaseHealth(attack);
		}
	}
