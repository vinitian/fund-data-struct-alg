public class MainForTest {
	public static void main(String[] args) throws Exception {
		
		// wrote for my own testing
		
		Deck d = new Deck();
		d.putBottom(3);
		d.putBottom(1);
		d.putBottom(6);
		d.putBottom(9);
		d.putBottom(4);
		
		Deck d2 = new Deck();
		d2.putBottom(3);
		d2.putBottom(1);
		d2.putBottom(6);
		d2.putBottom(9);
		d2.putBottom(5);
		d2.putBottom(7);
		d2.putBottom(10);
		d2.putBottom(8);
		d2.putBottom(2);
		
		Deck d3 = new Deck();
		d3.putBottom(1);
		d3.putBottom(2);
		d3.putBottom(3);
		d3.putBottom(4);
		d3.putBottom(5);
		d3.putBottom(6);
		d3.putBottom(7);
		d3.putBottom(8);
		d3.putBottom(9);
		d3.putBottom(10);
		
		String b1 = d.theList.printList();
		String b2 = d2.theList.printList();
		String b3 = d3.theList.printList();
		
		System.out.println("d1: " + b1);
		System.out.println("d2: " + b2);
		System.out.println("d3: " + b3);
		System.out.println("-------------------");
		// ----------------------
		d.reverseTopN(8);
		d2.reverseTopN(20);
		d3.reverseTopN(13);
		
		String r1 = d.theList.printList();
		String r2 = d2.theList.printList();
		String r3 = d3.theList.printList();
		
		System.out.println("d1: " + r1);
		System.out.println("d2: " + r2);
		System.out.println("d3: " + r3);
	}
}
