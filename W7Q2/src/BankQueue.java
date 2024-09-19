
public class BankQueue { // must work for any implementation of DeQ
	DeQ[] counters;
	DeQ special;

	public BankQueue(DeQ[] counters, DeQ special) {
		super();
		this.counters = counters;
		this.special = special;
	}

	//Write this method
	public void distribute() throws Exception {
		int totalPeople = 0; 
		for (DeQ q : counters) {
			totalPeople += q.size();
		}
		
		int neededQLength = totalPeople/counters.length;
		
		if (neededQLength%1 < 0.5) {
			neededQLength -= neededQLength%1;
		} else {
			neededQLength = (neededQLength - neededQLength%1) + 1;
		}
		
		int toMove = 0; // the counter number to move customer to special queue
		int customerNumber;
		int countersCompleted = 0; // regular counters that can't be moved no more (because it's <= neededQLength)
		
		// while special is not yet at neededQLength,
		// or while not all regular counters are <= neededQLength
		while ((special.size() < neededQLength) || (countersCompleted == counters.length)) {
			if (toMove > counters.length) {
				toMove = 0; // revolve back to first counter
			}
			if (counters[toMove].size() <= neededQLength) {
				toMove++;
				countersCompleted++;
				continue; //don't move people from this queue
			} else {
				countersCompleted = 0; //reset
			}
			
			// move people after neededQLength
			
			int indexPerson = 0; //the ordinal position of a person in the queue counters[toMove]
			while (indexPerson < neededQLength) { // "rotate" the queue
				int toBack = counters[toMove].removeFirst();
				counters[toMove].insertLast(toBack);
				indexPerson++;
			}
			// now the first person of counters[toMove] is the one we need to move to special
			
			// move that person to special
			customerNumber = counters[toMove].removeFirst();
			special.insertLast(customerNumber);
			
			// "rotate" the queue back to original (without the moved person)
			while (indexPerson < counters[toMove].size()) {
				int toBack = counters[toMove].removeFirst();
				counters[toMove].insertLast(toBack);
				indexPerson++;
			}
			
			// move to the next counter
			toMove++;
			
			//example
			//
			//neededQLength = 3, so we need to move 4
			//1 2 3 *4* 5 ||      indexPerson = 0
			//*4* 5 || 1 2 3      indexPerson = 3 (out of 5)
			//removeFirst();
			//5 || 1 2 3          indexPerson = 3
			//1 2 3 5 ||          indexPerson = 4 (out of 4)
			
		}
		
		if (special.size() == 0) {
			customerNumber = counters[counters.length-1].removeLast();
			special.insertLast(customerNumber);
		}
	}

}
