public class Heap {
	int[] mData;
	int size = 0;

	public Heap() {
		final int DEFAULT_CAPACITY = 11;
		mData = new int[DEFAULT_CAPACITY];
	} // default constructor

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(int element) {
		if (++size == mData.length) {
			int[] newHeap = new int[2 * mData.length];
			System.arraycopy(mData, 0, newHeap, 0, size);
			mData = newHeap;
		}
		mData[size - 1] = element;
		percolateUp();
		
	}

	protected void percolateUp() {
		int parent;
		int child = size - 1;
		int temp;
		while (child > 0) {
			parent = (child - 1) / 2;
			if (mData[parent] <= mData[child])
				break;
			temp = mData[parent];
			mData[parent] = mData[child];
			mData[child] = temp;
			child = parent;
		}
	}

	public int top() throws Exception {
		if (size == 0)
			throw new Exception("Empty");
		return mData[0];
	}

	public int pop() throws Exception {
		if (size == 0)
			throw new Exception("Priority queue empty.");
		int minElem = mData[0];
		mData[0] = mData[size - 1];
		size--;
		percolateDown(0);
		return minElem;
	}

	protected void percolateDown(int start) {
		int parent = start;
		int child = 2 * parent + 1;
		int temp;
		while (child < size) {
			if (child < size - 1 && mData[child] > mData[child + 1])
				child++;
			if (mData[parent] <= mData[child])
				break;
			temp = mData[child];
			mData[child] = mData[parent];
			mData[parent] = temp;
			parent = child;
			child = 2 * parent + 1;
		}
	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	//write this method!!!
	public static boolean isAHeap(Heap h) {
		
		//for debug
//		for (int i = 0; i<h.size; i++) {
//			System.out.print(h.mData[i]);
//			System.out.print(",");
//		}
//		System.out.println();
		
		for (int i = h.size-1; i>0; i--) {
//			System.out.println(Integer.toString(h.mData[i]) + " " + Integer.toString(h.mData[(i-1)/2]));
			if (h.mData[i] < h.mData[(i-1)/2]) {
				return false;
			}
		}
		return true;
		
		
	}

	

}
