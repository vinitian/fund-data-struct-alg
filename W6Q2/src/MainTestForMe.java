
public class MainTestForMe {
	public static void main(String[] args) throws Exception {
//		StackArray multiA = new StackArray();
//		multiA.push(35);
//		multiA.push(30);
//		multiA.push(25);
//		multiA.push(20);
//		multiA.push(15);
//		multiA.push(10);
//		multiA.push(5);
//
////		MyStack ans = StackUtility.removeRange(multiA, 0, 0);
////		
////		while(!ans.isEmpty()) {
////			System.out.println(ans.top());
////			ans.pop();
////		}	
//
//		
//		multiA.removeRange(6, 6);
//		
//		while(!multiA.isEmpty()) {
//			System.out.println(multiA.top());
//			multiA.pop();
//		}
		
		
		StackLinkedList multiL = new StackLinkedList();
		multiL.push(10);
		multiL.push(20);
		multiL.push(30);
		multiL.push(40);
		multiL.push(50);
		multiL.push(60);
		
		multiL.removeRange(0, 0);
		CDLinkedList list = multiL.getTheList();
		DListIterator t = new DListIterator(list.header);
		for (int i = 0; i< list.size; i++) {
			t.next();
			System.out.println(t.currentNode.data);
		}
		
//		multiL.removeRange(0, 0);
//		CDLinkedList list = multiL.getTheList();
//		list.printList();

		

	}
}
