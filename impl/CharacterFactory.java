
package impl;

import intf.ICharacter;
import intf.ICharacterFactory;
/**
 *
 * @author thaoc
 */
public class CharacterFactory implements ICharacterFactory{
  
  public static final ICharacterFactory instance = new CharacterFactory();
  
  private CharacterFactory(){
   
  }

  /**
   * Make the character.  To support more characters,
   * simply implement a type and then add a case statement
   * to this method.
   * 
   * @param type The type of character to make.
   * @return 
   */
  
  
  // Temp method to allow to compile
  @Override
  public ICharacter make(String type) {
	    switch(type){
	      case "soldier"  : return new Soldier();
	      
	      // Commenting out tank since it hasn't been written
	      //case "tank"     : return new Tank();
	      case "tank"     : return new Soldier();
	      case "charger"  : return new Charger();
	      case "common"  : return new CommonInfected();
	    }
	    return null;
	  }
   
}
