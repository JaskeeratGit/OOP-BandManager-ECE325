package ece325.lec.assignment3;

/**
 * Finish the implementation of this class. No need to add any instance variables or methods
 *
 */
public class ZooAnimal {
	/**
	 * True iff the animal was fed already.
	 */
	private boolean isFed;
	
	/**
	 * True iff the animal has danced already.
	 */
	private boolean hasDanced;
	
	/**
	 * The name of the animal.
	 */
	private String name;
	
	public ZooAnimal(String name) {		//Initializing constructor with defaults
		isFed = false;
		hasDanced = false;
		this.name = name;
	}
			
	/**
	 * Returns true iff the animal was fed already during the concert.
	 * @return true if the animal was fed
	 */
	public boolean isFed() {
		if (this.isFed == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Feed the animal.
	 */
	public void feed() {
		this.isFed = true;
	}	
	
	
	/**
	 * Invite an animal to dance. There's a 50% chance they actually start to dance when they are invited.
	 */	
	public void inviteToDance() {			// Setting 50% chance for dancing when invited
		if (Math.random()<0.5) {
			this.hasDanced = true;
		}
	}
	
	/** 
	 * Return true iff the animal has already danced.
	 * @return true if the animal has danced
	 */
	public boolean hasDanced() {
		if (this.hasDanced == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/** 
	 * Return the name of the animal.
	 * @return the name of the animal
	 */
	public String getName() {			//Getter for name of ZooAnimal object
		return this.name;
	}
}
