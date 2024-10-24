
public class HashIterator implements Iterator {

	OpenAddressing h; // the associated hash table
	int currentPos;   // position in the table's array that is currently marked.

	
	//Create an iterator that marks the leftmost actual data in the hash table.
	//Assume actual data are not 0 and DELETED.
	//If there are no actual data in the table, set currentPos to -1.
	public HashIterator(OpenAddressing o) {
		h = o;
		int i = 0;
		for (; i < o.array.length; i++) {
			if (o.array[i] != 0 && o.array[i] != OpenAddressing.DELETED) {
				currentPos = i;
				break;
			}
		}
		if (i >= o.array.length) {
			currentPos = -1;
		}
	}

	@Override
	public boolean hasNext() {
		
		for (int nextPos = currentPos+1; nextPos < h.array.length; nextPos++) {
			if (h.array[nextPos] != 0 && h.array[nextPos] != OpenAddressing.DELETED) {
				return true;
			}
		}
		return false;


	}

	@Override
	public boolean hasPrevious() {
		for (int prev = currentPos-1; prev >= 0; prev--) {
			if (h.array[prev] != 0 && h.array[prev] != OpenAddressing.DELETED) {
				return true;
			}
		}
		return false;

	}

	@Override
	public int next() throws Exception {
		
		for (int nextPos = currentPos+1; nextPos < h.array.length; nextPos++) {
			if (h.array[nextPos] != 0 && h.array[nextPos] != OpenAddressing.DELETED) {
				currentPos = nextPos;
				return h.array[nextPos];
			}
		}
		throw new Exception();

	}

	@Override
	public int previous() throws Exception {
		for (int prev = currentPos-1; prev >= 0; prev--) {
			if (h.array[prev] != 0 && h.array[prev] != OpenAddressing.DELETED) {
				int data = h.array[currentPos];
				currentPos = prev;
				return data;
			}
		}
		throw new Exception();

	}
	

	@Override
	public void set(int value) {
		// does not do anything,
		//because it will break hash table definition

	}

}
