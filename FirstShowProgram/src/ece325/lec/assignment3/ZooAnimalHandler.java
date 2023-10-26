package ece325.lec.assignment3;

import java.util.ArrayList;

public class ZooAnimalHandler implements DanceTherapist, AnimalHandler {
	private ArrayList<ZooAnimal> animals;
	
	public ZooAnimalHandler(ArrayList<ZooAnimal> animals) {
		this.animals = animals;			//Initializing ArrayList
		}

	@Override
	public ZooAnimal selectRandomAnimal() {
		int randomIndex = (int) Math.floor(Math.random()*animals.size());		//Getting random index from ArrayList.
		// TODO Auto-generated method stub
		//System.out.println(this.animals.get(randomIndex).getName());
		return this.animals.get(randomIndex);			//Returning the random ZooAnimal object from ArrayList.
	}

	@Override
	public void feedRandomAnimal() throws AlreadyFedException, DidNotDanceException {
		// TODO Auto-generated method stub
		ZooAnimal random = selectRandomAnimal();
		feed(random);
		
	}

	@Override
	public void feed(ZooAnimal a) throws DidNotDanceException, AlreadyFedException {
		// TODO Auto-generated method stub
		try {
			if (!a.hasDanced()) {			//Throwing exception if they haven't danced and therefore should not be fed.
				throw new DidNotDanceException(a.getName() + " did not dance yet!");
			}	
			if (a.isFed()) {				//Throwing exception if they already ate and therefore should not be fed.
				throw new AlreadyFedException(a.getName() + " already ate and may get a belly ache!");

			}
			else {
				a.feed();
			}
		}
		catch (DidNotDanceException e){
			e.printStackTrace();	
		}
		catch (AlreadyFedException e){
			e.printStackTrace();	
		}
		
		
	}

	@Override
	public void inviteRandomAnimalToDance() throws AlreadyFedException {
		// TODO Auto-generated method stub
		ZooAnimal random = selectRandomAnimal();

		inviteAnimalToDance(random);
		
	}

	@Override
	public void inviteAnimalToDance(ZooAnimal animal) throws AlreadyFedException {
		// TODO Auto-generated method stub
		try {
			if (animal.isFed()) {				//Throwing exception if they already ate and therefore should not dance or else will vomit
				throw new AlreadyFedException(animal.getName() + " already ate and is about to vomit");
			}
			else {								// If not then inviting to dance.
				animal.inviteToDance();
			}
		}
		catch (AlreadyFedException e){
			e.printStackTrace();				//Printing exception message
		}
		
	}


}
