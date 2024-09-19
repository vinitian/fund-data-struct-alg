
public class SimulateQueue {

	CustomerInfo[][] allEvents; //events in each and every queue
 
	MyQueue[] allQueues; // queues of people, corresponding to the events

	public SimulateQueue(CustomerInfo[][] allEvents, MyQueue[] allQueues) {
		super();
		this.allEvents = allEvents;
		this.allQueues = allQueues;
	}

	public void stateBeforeTimeT(int t) throws Exception {
		//TODO: implement this method.
				
		for (int line = 0; line < allEvents.length; line ++) {
			for (CustomerInfo customer : allEvents[line]) {
				if (customer.getTime() < t) {
					if (customer.getEvent() == 1) {
						allQueues[line].insertLast(1);;
					}
					else if (customer.getEvent() == -1) {
						allQueues[line].removeFirst();
					}
				}
			}
		}


	}

}
