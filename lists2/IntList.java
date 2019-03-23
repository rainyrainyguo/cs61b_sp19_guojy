public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size() {
		if (rest == null) {
			return 1;
		}
		return 1 + this.rest.size();
	}

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
		IntList p = this;
		int totalSize = 0;
		while (p != null) {
			totalSize += 1;
			p = p.rest;
		}
		return totalSize;
	}

	/** Returns the ith item of this IntList. */
	public int get(int i) {
		if (i == 0) {
			return first;
		}
		return rest.get(i - 1);
	}

	/**	We want to add a method to IntList so that if 2 numbers in a row are the same, we add them together and
	make one large node. For example:1 → 1 → 2 → 3 becomes 2 → 2 → 3 which becomes 4 → 3*/
	public void addAdjacent(){
		IntList p = this;
		while(p.rest!=null){
			while(p.rest.first == p.first){
				p.first *= 2;
				p.rest = p.rest.rest;
			}
			p = p.rest;
		}
	}

	public static IntList square(IntList L){
		if(L==null){
			return null;
		} else{
			IntList B = new IntList(L.first*L.first,square(L.rest));
			return B;
		}
	}

	public static IntList squareIterative(IntList L){
		if(L==null){
			return null;
		} else{
			IntList B = new IntList(L.first*L.first,null);
			IntList p = B;
			L = L.rest;
			while(L!=null){
				p.rest = new IntList(L.first*L.first,null);
				p = p.rest;
				L = L.rest;
			}
			return B;
		}
	}

	public static IntList squareDestructive(IntList L){
		IntList p = L;
		while(p.rest!=null){
			p.first = p.first*p.first;
			p = p.rest;
		}
		return L;
	}

	public static IntList squareDestructiveRecursive(IntList L){
		if(L==null) {
			return null;
		}
		L.first = L.first*L.first;
		squareDestructiveRecursive(L.rest);
		return L;
	}


	public static void main(String[] args) {
		IntList L = new IntList(3, null);
		L = new IntList(2, L);
		L = new IntList(5, L);
		L = new IntList(6,L);
		//IntList B = IntList.square(L);
		//IntList D = IntList.squareIterative(L);
		IntList E = IntList.squareDestructiveRecursive(L);
		//IntList C = IntList.squareDestructive(L);
		//L.addAdjacent();
		//System.out.println(L.get(100));
	}
} 