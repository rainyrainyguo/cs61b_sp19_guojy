import org.junit.Test;

/** An SLList is a list of integers, which hides the terrible truth
 * of the nakedness within. */
public class SLList {
	private static class IntNode {
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode n) {
			item = i;
			next = n;
		}
	}

	/* The first item (if it exists) is at sentinel.next. */
	private IntNode sentinel;
	private int size;

//	private static void lectureQuestion() {
//		SLList L = new SLList();
//		IntNode n = IntNode(5, null);
//	}

	/** Creates an empty SLList. */
	public SLList() {
		sentinel = new IntNode(63, null);
		size = 0;
	}

	public SLList(int x) {
		sentinel = new IntNode(63, null);
		sentinel.next = new IntNode(x, null);
		size = 1;
	}

	public SLList(int[] arr){
		sentinel = new IntNode(63,null);
		IntNode p = sentinel;
		size = 0;
		for(int node: arr){
			p.next = new IntNode(node,null);
			p = p.next;
			size += 1;
		}
	}

	/** Adds x to the front of the list. */
	public void addFirst(int x) {
		sentinel.next = new IntNode(x, sentinel.next);
		size = size + 1;
	}

	/** Returns the first item in the list. */
	public int getFirst() {
		return sentinel.next.item;
	}

	/** Adds x to the end of the list. */
	public void addLast(int x) {
		size = size + 1;

		IntNode p = sentinel;

		/* Advance p to the end of the list. */
		while (p.next != null) {
			p = p.next;
		}

		p.next = new IntNode(x, null);
	}

	/** Returns the size of the list. */
	public int size() {
		return size;
	}

	public void deleteFirst(){
		size -= 1;
		sentinel.next = sentinel.next.next;
	}

	public void insert(int item, int position){
		int i=-1;
		IntNode p = sentinel;
		while(p.next!=null){
			if(i==position-1){
				IntNode newNode = new IntNode(item,p.next);
				p.next = newNode;
				return;
			}
			p = p.next;
			i += 1;
		}
		p.next = new IntNode(item,null);
	}

	public void reverse(){
		/** use existing IntNode object, do not use new
		 * reverse iteratively*/
		IntNode p = sentinel;
		IntNode p1 = sentinel.next;
		IntNode p2 = p1.next;
		p1.next = null;
		IntNode temp;
		while(p2.next!=null){
			temp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = temp;
		}
		p2.next = p1;
		sentinel.next = p2;
	}

	private IntNode reverseHelper(IntNode p){
		if(p.next==null){
			return p;
		}
		IntNode EndofReversed = p.next;
		IntNode reversed = reverseHelper(p.next);
		EndofReversed.next = p;
		p.next = null;
		return reversed;
	}

	public void reverseRecursive(){
		/**reverse recursively*/
		sentinel.next = reverseHelper(sentinel.next);
	}

	public static void main(String[] args) {
		/* Creates a list of one integer, namely 10 */
		int[] arr = new int[]{1,2,3};
		SLList L = new SLList(arr);
//		L.addLast(20);
//		L.addFirst(3);
//		L.deleteFirst();
//		System.out.println("size is: " + L.size());
//		L.insert(10,0);
//		L.insert(11,2);
//		L.insert(9,10);
//		L.reverse();
		L.reverseRecursive();
	}

}