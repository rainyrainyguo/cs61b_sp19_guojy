public class LinkedListDeque<T> {
    /** private helper class for node in Linked-List-Deque.
     * Circular Sentinel
     */
    private class ListNode {
        private ListNode prev;
        private T item;
        private ListNode next;

        public ListNode(ListNode p, T i, ListNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private ListNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new ListNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

//    public LinkedListDeque(LinkedListDeque<T> other){
//        /**deep copy*/
//        sentinel = new ListNode(null,null,null);
//        sentinel.prev = sentinel;
//        sentinel.next = sentinel;
//        size = 0;
//        ListNode p = other.sentinel;
//        for(int i=0; i<other.size(); i++){
//            addLast(other.getIterative(i));
//        }
//    }

    /*the other way of copying*/
    public LinkedListDeque(LinkedListDeque other) {
        /**deep copy*/
        sentinel = new ListNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
        ListNode p = other.sentinel;
        for (int i = 0; i < other.size(); i++) {
            addLast((T) other.getIterative(i));
        }
    }


    public void addFirst(T item) {
        sentinel.next = new ListNode(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T item) {
        sentinel.prev.next = new ListNode(sentinel.prev, item, sentinel);
        sentinel.prev = sentinel.prev.next;
        size += 1;
    }

    public boolean isEmpty() {
        /**returns true if empty*/
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        /**Prints the items in the deque from first to last,
         *  separated by a space. Once all the items have been printed, print out a new line.*/
        ListNode p = sentinel.next;
        while (p != sentinel) {
            System.out.println(p.item + " ");
            p = p.next;
        }
        System.out.println('\n');
    }

    public T removeLast() {
        /**Removes and returns the item at the back of the deque.
         * If no such item exists, returns null.*/
        T x = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        return x;
    }

    public T removeFirst() {
        T x = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        return x;
    }

    public T getIterative(int index) {
        /**Gets the item at the given index, where 0 is the front, 1 is the next item,
        *and so forth. If no such item exists, returns null. Must not alter the deque!
         * use iteration, not recursion*/
        if (index >= size) {
            return null;
        }
        int i = 0;
        ListNode p = sentinel.next;
        while (i < index) {
            i += 1;
            p = p.next;
        }
        return p.item;
    }

    public T getHelper(ListNode n, int ind) {
        if (ind == 0) {
            return n.item;
        } else if (n == null) {
            return null;
        }
        return getHelper(n.next, ind - 1);
    }
    public T getRecursive(int index) {
        /**recursion for get*/
        return getHelper(sentinel.next, index);
    }
}
