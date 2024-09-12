public class StackUtility {
	public static MyStack removeRange(MyStack s, int i, int j) throws Exception {
		MyStack s2 = (MyStack) new StackLinkedList();
		int k = 0;
		while (!s.isEmpty()) {
			if ((k >= i) && (k <= j)) {
				s.pop();
				k++;
				continue;
			}
			
			s2.push(s.top());
			s.pop();
			k++;
		}
		
		s.makeEmpty();
		while (!s2.isEmpty()) {
			s.push(s2.top());
			s2.pop();
		}
		
		return s;
	}
}