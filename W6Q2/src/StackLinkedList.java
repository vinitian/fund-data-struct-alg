
public class StackLinkedList implements MyStack {
	private CDLinkedList theList;
	
	public StackLinkedList(){ // create an empty stack
		theList = new CDLinkedList();
	}
	
	public StackLinkedList(CDLinkedList l) throws Exception {
		super();
		DListIterator iparam = new DListIterator(l.header);
		DListIterator ithis = new DListIterator(theList.header);
		while (iparam.hasNext()) {
			int v = iparam.next();
			if (iparam.currentNode == l.header)
				return;
			theList.insert(v, ithis);
			ithis.next();
		}	
	}
	
	public CDLinkedList getTheList() {
		return theList;
	}

	public void setTheList(CDLinkedList theList) {
		this.theList = theList;
	}

	public boolean isEmpty(){
		return theList.isEmpty();
	}
	
	public boolean isFull(){
		return false;
	}
	
	public void makeEmpty(){
		theList.makeEmpty();
	}
	
	public int top() throws MyStackException{
		if(isEmpty())
			throw new MyStackException();
		return theList.header.nextNode.data;
	}
	
	public void pop() throws MyStackException{
		if(isEmpty())
			throw new MyStackException();
		Iterator itr = new DListIterator(theList.header);
		theList.remove(itr);
	}
	
	public void push(int data) throws Exception{
		Iterator itr = new DListIterator(theList.header);
		theList.insert(data, itr);
	}

	public void removeRange(int i, int j) throws Exception {
		theList.size -= j-i+1;
		DListIterator p1 = new DListIterator(theList.header); //pointing i		
		for (int m = -1; m < i-1; m++) {
			p1.next();
		}
		System.out.println(p1.currentNode.data);
		//p1 is now pointing to the node before i
		
		DListIterator p2 = new DListIterator(p1.currentNode); //pointing j		
		for (int n = i; n <= j+1; n++) {
			p2.next();
		}
		System.out.println(p2.currentNode.data);
		System.out.println("-------------");

		//p2 is now pointing to the node after j
		
		p1.currentNode.nextNode = p2.currentNode;
		p2.currentNode.previousNode = p1.currentNode;	
	}

}
