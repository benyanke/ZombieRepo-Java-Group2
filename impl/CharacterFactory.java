package zombiewar.impl;

import zombiewar.intf.ICharacter;
import zombiewar.intf.ICharacterFactory;

/**
 * 
 * @author thaoc
 */
public class CharacterFactory implements ICharacterFactory {

	public static final ICharacterFactory instance = new CharacterFactory();

	private CharacterFactory() {

	}

	/**
	 * Make the character. To support more characters, simply implement a type
	 * and then add a case statement to this method.
	 * 
	 * @param type
	 *            The type of character to make.
	 * @return
	 */

	@Override
	public ICharacter make(String type) {

		if (type.equals("tank")) {
			return new Tank();
		}

		if (type.equals("common")) {
			return new Common();
		}

		if (type.equals("predator")) {
			return new Predator();
		}

		if (type.equals("soldier")) {
			return new Soldier();
		}

		if (type.equals("teacher")) {
			return new Teacher();
		}

		if (type.equals("student")) {
			return new Student();
		}

		if (type.equals("child")) {
			return new Child();
		}

		if (type.equals("charger")) {
			return new Charger();
		}

		return null;

		// switch (type) {
		// case "tank":
		// return new Tank();
		// case "common":
		// return new Common();
		// case "predator":
		// return new Predator();
		// case "soldier":
		// return new Soldier();
		// case "teacher":
		// return new Teacher();
		// case "student":
		// return new Student();
		// case "child":
		// return new Child();
		// default:
		// return null;
		//
		// }
	}

}
