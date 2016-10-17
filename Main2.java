package zombiewar;

import java.util.ArrayList;
import java.util.List;

import zombiewar.impl.CharacterFactory;
import zombiewar.intf.ICharacter;
import zombiewar.intf.ICharacterFactory;
import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

/**
 * 
 * @author thaoc
 */
public class Main2 {

	private static final ICharacterFactory factory = CharacterFactory.instance;

	public static List<IZombie> randomZombies() {
		int numZombies = (int) (Math.random() * 10);
		List<IZombie> zombies = new ArrayList<IZombie>();
		for (int i = 0; i < numZombies; i++) {
			int zombieType = (int) (Math.random() * 2);
			switch (zombieType) {
			case 0:
				zombies.add((IZombie) factory.make("common"));
				break;
			case 1:
				zombies.add((IZombie) factory.make("tank"));
				break;
			case 2:
				zombies.add((IZombie) factory.make("predator"));
				break;
			}
		}
		return zombies;
	}

	public static List<ISurvivor> randomSurvivors() {
		int numZombies = (int) (Math.random() * 20);
		List<ISurvivor> survivors = new ArrayList<ISurvivor>();
		for (int i = 0; i < numZombies; i++) {
			int type = (int) (Math.random() * 3);
			switch (type) {
			case 0:
				survivors.add((ISurvivor) factory.make("soldier"));
				break;
			case 1:
				survivors.add((ISurvivor) factory.make("teacher"));
				break;
			case 2:
				survivors.add((ISurvivor) factory.make("student"));
				break;
			case 3:
				survivors.add((ISurvivor) factory.make("child"));
				break;
			}
		}
		return survivors;
	}

	public static boolean allDeadZ(List<IZombie> characters) {
		boolean allDead = true;
		for (int i = 0; i < characters.size(); i++) {
			allDead &= !characters.get(i).isAlive();
		}
		return allDead;
	}

	public static boolean allDeadS(List<ISurvivor> characters) {
		boolean allDead = true;
		for (int i = 0; i < characters.size(); i++) {
			allDead &= !characters.get(i).isAlive();
		}
		return allDead;
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {

		List<IZombie> zombies = randomZombies();
		List<ISurvivor> survivors = randomSurvivors();

		System.out.println("We have " + survivors.size()
				+ " survivors trying to make it to safety.");
		System.out.println("But there are " + zombies.size()
				+ " zombies waiting for them.");

		// TODO: the survivors attack first. One characte attack each zombie.
		// When all the survivors have done attacking, it's the zombies'
		// turn to attack. For each zombie that is still alive, attack
		// each suvivor that is still alive. Repeat this cycle until
		// all the zombies are all dead or all the survivors are all dead.

		List<ICharacter> killed = new ArrayList<ICharacter>();

		while (!allDeadS(survivors) || !allDeadZ(zombies)) {
			for (ISurvivor s : survivors) {
				for (IZombie z : zombies) {
					if (s.isAlive())
						s.attack(z);
					if (!z.isAlive() && !killed.contains(z)) {
						System.out.println(classString(s.getClass().toString())
								+ " killed "
								+ classString(z.getClass().toString()));
						killed.add(z);

					}
				}
			}

			if (allDeadZ(zombies)) {
				break;
			}

			for (IZombie z : zombies) {
				for (ISurvivor s : survivors) {
					if (z.isAlive())
						z.attack(s);
					if (!s.isAlive() && !killed.contains(s)) {
						System.out.println(classString(z.getClass().toString())
								+ " killed "
								+ classString(s.getClass().toString()));
						killed.add(s);
					}
				}
			}

			if (!allDeadS(survivors)) {
				break;
			}
		}

		if (allDeadS(survivors)) {
			System.out.println("None of the survivors made it.");
		} else {
			int count = 0;
			for (int i = 0; i < survivors.size(); i++) {
				if (survivors.get(i).isAlive())
					count++;
			}
			System.out
					.println("It seems " + count + " have made it to safety.");
		}
	}

	public static String classString(String className) {

		return className.substring(className.lastIndexOf('.') + 1);

	}

}
