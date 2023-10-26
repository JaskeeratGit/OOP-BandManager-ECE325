

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/** 
 * Finish this class.
 */
public class EquipmentInventory {

	/** The list of all your equipment objects */
	ArrayList<Equipment> inventory;
	/** The number of objects per type of equipment, grouped by the String description of a type */
	HashMap<String, Integer> inventoryCount;

	/** 
	 * Create an EquipmentInventory object by initializing the inventory and inventoryCount objects.
	 */
	public EquipmentInventory() {
		inventory = new ArrayList<Equipment>();				//Initializing arrayList and HashMap with default values
		inventoryCount = new HashMap<String, Integer>();
	}

	/**
	 * Add e to the inventory, and if the add is successful, increase the number of that equipment type in your inventoryCount.
	 * Make sure that you cannot accidentally add the same object twice.
	 * @param e The equipment object to add
	 */
	public void add(Equipment e) {
		if (inventory.contains(e)) {		//Checking if equipment instance is already in the arrayList
			System.out.println("You have entered an object that already exists in the inventory");
		}
		else {
			inventory.add(e);				//If not, then adding to inventory and calling increaseInventoryCount
			increaseInventoryCount(e);
		}
	}

	/**
	 * Remove e from the inventory and if successful, decrease the number of that equipment type in your inventoryCount.
	 * @param e The equipment object to remove
	 */
	public void remove(Equipment e) {
		if (inventory.contains(e)) {		//Only calling remove function and decreaseInventoryCount if object in inventory
			inventory.remove(e);
			decreaseInventoryCount(e);
		}
		else {								//Otherwise throwing message
			System.out.println("You tried removing an object that was not in the inventory in the first place");
		}
	}

	/**
	 * Increase the inventoryCount for the type of equipment of e by 1.
	 * If it does not exist in the inventoryCount yet, add the type to the inventoryCount.
	 * Note: this method should be private, but to allow running unit tests on it (and make our lives easier when marking),
	 * we made this method protected. The method should never be called outside of the class. 	 
	 * @param e The type of equipment for which we want to increase the inventoryCount
	 */
	protected void increaseInventoryCount(Equipment e) {
		String type = e.toString();					//Finding type of object (Guitar/Chair/Keyboard,etc)
		if (inventoryCount.containsKey(type)){
			inventoryCount.replace(type,inventoryCount.get(type)+1);	//Increasing count of type if already exists
		}
		else {
			inventoryCount.put(type, 1);		//If not existing, adding the type to HashMap and setting count to 1
		}
	}

	/**
	 * Decrease the inventoryCount for the type of equipment of e by 1.
	 * If the inventoryCount for this type is now 0, remove the type from the inventoryCount.
	 * If the inventoryCount does not contain this type of equipment, do nothing.
	 * Note: this method should be private, but to allow running unit tests on it (and make our lives easier when marking),
	 * we made this method protected. The method should never be called outside of the class. 	 
	 * @param e The type of equipment for which we want to decrease the inventoryCount
	 */
	protected void decreaseInventoryCount(Equipment e) {
		String type = e.toString();			//Find the type
		if (inventoryCount.containsKey(type) && inventoryCount.get(type)>=1){		//If the count is 1 or more, decrease the count by 1
			inventoryCount.replace(type,inventoryCount.get(type)-1);
		}
		if (inventoryCount.containsKey(type) && inventoryCount.get(type)==0){		//If the count is 0, remove the key from hashmap
			inventoryCount.remove(type);
		}

	}

	/** 
	 * Return the number of times this type of equipment occurs in the inventory.
	 * If it doesn't occur in the inventory, return -1 (to indicate that something went wrong somewhere).
	 * @param e
	 * @return
	 */
	public Integer getInventoryCount(Equipment e) {
		String type = e.toString();
		 if (inventoryCount.containsKey(type)) {		//returning value of equipment type, returning -1 if not in inventory
			 return inventoryCount.get(type);
		 }
		 else {
			 return -1;
		 }
	}
	
	/**
	 * Return the String representation of the EquipmentInventory.
	 * It should look similarly to the following:
	 * [EquipmentInventory: Guitar: 3, Stool: 3, Chair: 1, Keyboard: 2]
	 * (after adding 3 guitars, 3 stools, 1 chair and 2 keyboards).
	 * The order in which the types are printed does not matter.
	 * @return the string representation of the EquipmentInventory
	 */
	public String toString() {
		String result = "[EquipmentInventory:";
		String finalResult = "";						//Setting up final string to be returned as output
		if (!inventoryCount.isEmpty()) {
			Set<String> keys = inventoryCount.keySet();
			for (String key: keys) {
				result = result + " " + key + ": " + (inventoryCount.get(key)).toString() + ",";			
			}
		
		}
		if (result.length() == 20) {
			finalResult = result + " ]";
		}
		else {
			finalResult = result.substring(0,result.length()-1) + "]";
		}
		return finalResult;
	}

	public static void main(String[] args) {
		EquipmentInventory inv = new EquipmentInventory();
		
		Guitar g1 = new Guitar();		//Creating and adding all objects required
		Guitar g2 = new Guitar();
		Guitar g3 = new Guitar();
		inv.add(g1);
		inv.add(g2);
		inv.add(g3);

		Keyboard k1 = new Keyboard();
		Keyboard k2 = new Keyboard();
		inv.add(k1);
		inv.add(k2);

		Stool s1 = new Stool();
		Stool s2 = new Stool();
		Stool s3 = new Stool();
		inv.add(s1);
		inv.add(s2);
		inv.add(s3);

		Chair c1 = new Chair();
		inv.add(c1);

		/**for (int i = 0; i < inv.inventory.size(); i++) {
			System.out.println(inv.inventory.get(i));
		}**/
		
		//System.out.println(inv.getInventoryCount(g1));
		
		System.out.println(inv.toString());
		inv.remove(k1);					//Removing 1 keyboard and 1 stool
		inv.remove(s1);
		
		System.out.println(inv.toString());
		String s ="";
		for (int i = 0; i < inv.inventory.size(); i++) {
			s = s + inv.inventory.get(i) + " ";
		}
		System.out.println(s);
	}
	
}
