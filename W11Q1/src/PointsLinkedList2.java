
public class PointsLinkedList2 extends PointsLinkedList{
	// Write this method
		// Find if there is a point in a linked list with the same value as p,
		// but with different nextValue or different preValue

		public boolean pointValueExist(Point p) throws Exception {
			System.out.println(printList());
			
//			if (size == 0) {
//				return false;
//			}
			PointListIterator it = new PointListIterator(header);
			while (it.hasNext()) {
				it.next();
				if (it.currentNode.data == null) {
					return false;
				}
				if ((!it.currentNode.data.equals(p)) && (it.currentNode.data.value == p.value)) {
//					System.out.println(it.currentNode.data.value);
					return true;
				}
				
			}
			return false;
		}
	
	
}
