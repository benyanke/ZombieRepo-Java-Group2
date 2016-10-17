import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import impl.CharacterFactory;
import impl.Charger;
import impl.CommonInfected;
import impl.Soldier;
import intf.ICharacter;
import intf.ICharacterFactory;
import intf.ISurvivor;
import intf.IZombie;

/**
 *
 * @author thaoc
 */

public class Main {

	private static final ICharacterFactory factory = CharacterFactory.instance;

	public static IZombie[] randomZombies() {
		int numZombies = (int) (Math.random() * 10);
		if (numZombies == 0)
			numZombies = 1;
		IZombie[] zombies = new IZombie[numZombies];
		for (int i = 0; i < zombies.length; i++) {
			int zombieType = (int) (Math.random() * 3);
			switch (zombieType) {

				case 0:
					zombies[i] = (IZombie) factory.make("common");
					break;
				case 1:
					// commented out since tank hasn't been written yet
					// zombies[i] = (IZombie) factory.make("tank");
					zombies[i] = (IZombie) factory.make("common");
					break;
				case 2:
					// commented out since tank hasn't been written yet
					//zombies[i] = (IZombie) factory.make("predator");
					zombies[i] = (IZombie) factory.make("charger");
					break;
				case 3:
					zombies[i] = (IZombie) factory.make("charger");
					break;

			}
		}
		return zombies;
	}

	public static ISurvivor[] randomSurvivors() {
		int numSurvivor = (int) ((Math.random() * 19) + 1);
		ISurvivor[] survivors = new ISurvivor[numSurvivor];
		for (int i = 0; i < survivors.length; i++) {
			int type = (int) (Math.random() * 3);
			
			//survivors[i] = (ISurvivor) factory.make("soldier");
			// Always returns soldier, since no one has written teacher/student/child
			/*
			switch (type) {
				case 0:
					survivors[i] = (ISurvivor) factory.make("soldier");
					break;
				case 1:
					survivors[i] = (ISurvivor) factory.make("teacher");
					break;
				case 2:
					survivors[i] = (ISurvivor) factory.make("student");
					break;
				case 3:
					survivors[i] = (ISurvivor) factory.make("child");
					break;
			} */
		}
		return survivors;
	}

	public static boolean allDead(ICharacter[] characters) {

		// reworked to be more efficient: if a single char is alive,
		// no need to check the rest. -BY

		for (int i = 0; i < characters.length; i++) {
			if (characters[i].isAlive()) {
				return false;
			}
		}

		return true;
	}

	public static int readInput() {

		Scanner in = new Scanner(System.in);

		int i = in.nextInt();

		return i;
	}

	public static String stats(Object[] obj) {
		String output;
		output = "";

		HashMap stats = new HashMap();

		// Adding elements to HashMap

		stats.put("soldier", 0);
		// tank isn't written yet
		// stats.put("tank", 0);
		stats.put("charger", 0);
		stats.put("commonInf", 0);

		for (int i = 0; i < obj.length; i++) {
			Object thisObj = obj[i];

			if (thisObj instanceof Charger) {
				int count = (int) stats.get("charger") + 1;
				stats.put("charger", count);
			} else if (thisObj instanceof Soldier) {
				int count = (int) stats.get("soldier") + 1;
				stats.put("soldier", count);
			} else if (thisObj instanceof CommonInfected) {
				int count = (int) stats.get("commonInf") + 1;
				stats.put("commonInf", count);
				// Commented out since tank isn't written....
				// } else if (thisObj instanceof Tank) {
				// int count = (int) stats.get("tank") + 1;
				// stats.put("tank", count);
			}

		}

		Set<String> keyset = stats.keySet();

		// check key set values
		for (String key : keyset) {
			String keyStr = (String) key;
			output += stats.get(keyStr) + " " + keyStr + "s, ";
		}

		return output.substring(0, output.length() - 2);
	}

	// Performs all of the zombie attacks
	public static void zombiesAttack(IZombie zombies[], ISurvivor[] survivors) {
		for (int i = 0; i < survivors.length; i++) {
			for (int z = 0; z < zombies.length; z++) {
				if (survivors[i].isAlive() && zombies[z].isAlive()) {
					zombies[z].attack(survivors[i]);
				}
			}
		}
	}

	// Performs all of the survivor attacks
	public static void survivorsAttack(ISurvivor[] survivors, IZombie zombies[]) {
		for (int z = 0; z < zombies.length; z++) {
			for (int i = 0; i < survivors.length; i++) {
				if (survivors[i].isAlive() && zombies[z].isAlive()) {
					survivors[i].attack(zombies[z]);
				}
			}
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {

		IZombie[] zombies = randomZombies();
		ISurvivor[] survivors = randomSurvivors();

		System.out.print("Do you want to run release 1.0 or 2.0? [1,2]: ");
		int version = readInput();

		// Version 1 goes here
		if (version == 1) {

			System.out.println("\nWe have " + survivors.length + " survivors trying to make it to safety.");
			System.out.println("But there are " + zombies.length + " zombies waiting for them.");

			// TODO: the survivors attack first. One characte attack each
			// zombie.
			// When all the survivors have done attacking, it's the zombies'
			// turn to attack. For each zombie that is still alive, attack
			// each suvivor that is still alive. Repeat this cycle until
			// all the zombies are all dead or all the survivors are all dead.
			
			while (!allDead(zombies) && !allDead(survivors)) {
				survivorsAttack(survivors, zombies);
				if (allDead(zombies)) {
					break;
				}
				zombiesAttack(zombies, survivors);
				if (allDead(survivors)) {
					break;
				}
			}

			if (allDead(survivors)) {
				System.out.println("None of the survivors made it.");
			} else {
				int count = 0;
				for (int i = 0; i < survivors.length; i++) {
					if (survivors[i].isAlive())
						count++;
				}
				System.out.println(
						"It seems " + count + " out of " + survivors.length + " survivors have made it to safety.");
			}

			// Release version 2.0 goes here
		} else if (version == 2) {
			System.out.println("\nWe have " + survivors.length + " survivors trying to make it to safety ("
					+ stats(survivors) + ").");
			System.out.println(
					"But there are " + zombies.length + " zombies waiting for them (" + stats(zombies) + ").\n\n");

			// Attack
			while (!allDead(zombies) && !allDead(survivors)) {
				survivorsAttack(survivors, zombies);
				if (allDead(zombies)) {
					break;
				}
				zombiesAttack(zombies, survivors);
				if (allDead(survivors)) {
					break;
				}
			}
			
//			dumpArray(zombies);
//			dumpArray(survivors);


			if (allDead(survivors)) {
				System.out.println("None of the survivors made it.");
			} else {
				int count = 0;
				for (int i = 0; i < survivors.length; i++) {
					if (survivors[i].isAlive())
						count++;
				}
				System.out.println(
						"It seems " + count + " out of " + survivors.length + " survivors have made it to safety.");
			}

		} else {
			System.out.println("That's not a valid version.");
		}

	}

	// Debugging method to view array contents
	public static void dumpArray(Object[] input) {
		for (int i = 0; i < input.length; i++) {
			System.out.println("\t" + input[i]);
		}
		System.out.println("################");
	}
}
