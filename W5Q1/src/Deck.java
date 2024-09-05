public class Deck extends DeQLinkedList {
	// queue; FIFO
	
	// If there is no card to remove, return -1.
	// remove a card from the top of the deck. Return the value of that card.
	public int draw() {
		try {
			int data = removeFirst();
			return data;
		} catch (Exception e) {
			return -1;
		}
	}
	
	
	// remove the nth card (and return its value).
	// The top card is the 0th card. Assume n is always non-negative.
	// If the nth card does not exist, return -1 and do nothing.
	public int removeNth(int n) {
		try {
			int data = theList.findKth(n);
			DListIterator p = (DListIterator) theList.findPrevious(data);
			if (p == null) {
				return -1;
			}
			theList.remove(p);
			return data;
		} catch (Exception e){
			return -1;
		}
	}
	
	public void putBottom(int n) {
		// Put card with value n at the bottom of the deck.
		// This is used to create a deck in the test cases.
		try {
			insertLast(n);
		} catch (Exception e) {
			return;
		}
	}
	
	public void reverseTopN(int n) {
		// reverse the order of the top n cards (position 0 to position n-1, inclusive).
		// Assume n is positive.
		// If n is too large, just reverse the entire deck.
		//If the deck is empty, do nothing.
		try {
			if (n >= theList.size()) {
				reverseWholeList();
				return;
			}
			int data = theList.findKth(n);
			DListIterator p = (DListIterator) theList.findPrevious(data); //the last card being reversed
			DListNode header = theList.header;
			DListNode top = header.nextNode;
			DListNode last = p.currentNode;
			DListNode afterlast = p.currentNode.nextNode; //the node after original last i.e. the n-th node originally
//			DListIterator p2 = new DListIterator(afterlast);
			
			header.nextNode = p.currentNode;
			while (p.currentNode != top) {
				p.currentNode.nextNode = p.currentNode.previousNode;
				p.next();
			}
			p.currentNode.nextNode = afterlast;
		
			
			p.currentNode = last; //go to last
			while (p.currentNode != header.nextNode) { //while currentNode is not the node after original last i.e. the n-th node originally
				DListNode temp = p.currentNode;
				p.previous();
				p.currentNode.previousNode = temp;
			}
			last.previousNode = header;
			afterlast.previousNode = top;
			// p.currentNode.previousNode = p2.currentNode;

		} catch (Exception e) {
			return;
		}
	}
	
	public void reverseWholeList() throws Exception {
		DListNode header = theList.header;
		DListIterator p = new DListIterator(header);
		
		do {
			p.currentNode.previousNode = p.currentNode.nextNode;
			p.next();
		} while (p.hasNext() && p.currentNode != header);

		do {
			DListNode node = p.currentNode;
			p.previous();
			p.currentNode.nextNode = node;
		} while (p.hasNext() && p.currentNode != header);
		
	}
}
