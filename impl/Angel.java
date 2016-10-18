
import intf.ISurvivor;
import intf.IZombie;


public class Angel extends Character implements ISurvivor {

	Angel(){
		this(80, 20);
	}
	
	Angel(health, int attack) {
		super(health, attack);
	}
	
	@Override
	public void attack(IZombie zombie){
		zombie.decreaseHealth(attack);
	}
}