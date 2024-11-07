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

		// modified part is to be written below
		
		//step 1: find largest data
		int max = size - 1; //index of largest data
		for (int i = size/2; i < size; i++) { // iterate only the leaves
			if (mData[max] < mData[i]) {
				max = i;
			}
		}
		
		
		//step 2: swap last with max
		int temp = mData[size - 1];
		mData[size - 1] = mData[max];
		mData[max] = temp;
		
		//step 3: percolate up
		percolateUpSpecify(max); 
		
	}
	
	protected void percolateUpSpecify(int index) {
		// just like percolateUp but not the last data
		// we specify index for child
		int parent;
		int child = index;
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

	// never get called in our program
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


}
