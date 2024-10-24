public class Sort {
	//Hint: You can create other methods and then use sortFrequency to call them.
	static Pair[] p = new Pair[10];
	
	public static int[] sortFrequency(int[] x) {
		countFrequency(x);
		
		for (int j = 1; j <= 9; j++) {
			for (int e = 0; e <= 8; e++) {
				if (p[e].freq < p[e+1].freq) {
					swap(p, e, e+1);
				}
			}
		}
		
		int len = 0;
		for (Pair a : p) {
			if (a.freq != 0) {
				len++;;
			}
		}
		
		int[] sorted = new int[len];
		int n = 0;
		for (Pair a : p) {
			if (a.freq != 0) {
				sorted[n] = a.value;
				
//				System.out.print(sorted[n]);
//				System.out.print(",");
				
				n++;
			}
		}
		
//		System.out.println();

		return sorted;
		
	}
	
	public static void swap (Pair[] pairs, int a, int b) {
		Pair temp = pairs[a];
		pairs[a] = pairs[b];
		pairs[b] = temp;
	}
	
	public static void countFrequency(int[] x) {
		// create p where all f = 0
		for (int i = 0; i < 10; i++) {
			p[i] = new Pair(i+1, 0); // p[] 0 1 2 ... 9 has v = 1 2 3 ... 10
		}
		
		for (int j = 0; j<x.length; j++) {
			p[x[j]-1].add1(); // if j = 6 -> addfreq at p[5]
		}
	}
	
	

}
