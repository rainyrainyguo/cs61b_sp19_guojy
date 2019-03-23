public class ArrayDeque<T> {

    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 7; //nextFirst -= 1;
        nextLast = 0; //nextLast += 1;
    }

//    public ArrayDeque(ArrayDeque<T> other){
//        /**deep copy*/
//        nextFirst = other.nextFirst;
//        nextLast = other.nextLast;
//        size = other.size;
//        items = (T[]) new Object[other.items.length];
//        for( int i=0; i < other.items.length; i++){
//            items[i] = other.items[i];
//        }
//    }

    /*the other way of copying*/
    public ArrayDeque(ArrayDeque other){
        /**deep copy*/
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;
        size = other.size;
        items = (T[]) new Object[other.items.length];
        for( int i=0; i < other.items.length; i++){
            items[i] = (T) other.items[i];
        }
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int rightsize = items.length - nextFirst - 1;
        System.arraycopy(items, 0, a, 0, nextFirst + 1);
        System.arraycopy(items, nextFirst + 1, a, capacity - rightsize, rightsize);
        items = a;
        nextFirst = capacity - rightsize - 1;
    }

    public void addFirst(T item){
        if (size == items.length){
            resize(size*2);
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length)%items.length;
        size += 1;
    }

    public void addLast(T item){
        if (size == items.length){
            resize(size*2);
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1 )%items.length;
        size += 1;
    }

    public boolean isEmpty(){
        /**returns true if empty*/
        return (size==0);
    }

    public int size(){
        return size;
    }

    public void printDeque() {
        /**Prints the items in the deque from first to last,
         *  separated by a space. Once all the items have been printed, print out a new line.*/
        for(int i = (nextFirst + 1) % items.length; i < items.length; i++) {
            System.out.print(items[i] + " ");
        }
        for (int j = 0; j < nextLast; j++) {
            System.out.print(items[j] + " ");
        }
        System.out.print("\n");
    }

    public T removeLast(){
        /**Removes and returns the item at the back of the deque. If no such item exists, returns null.*/
        if (size == 0){
            System.out.println("can't remove last, size is 0!");
            return null;
        }
        int Last = (nextLast - 1 + items.length)%items.length;
        T x = items[Last];
        items[Last] = null;
        nextLast = Last;
        size -= 1;
        return x;
    }

    public T removeFirst(){
        if (size == 0){
            System.out.println("can't remove first, size is 0!");
            return null;
        }
        int First = (nextFirst + 1)%items.length;
        T x = items[First];
        items[First] = null;
        nextFirst = First;
        size -= 1;
        return x;
    }

    public T get(int index){
        if (index >= size) {
            System.out.println("wrong index: longer than list");
            return null;
        } else if (index < items.length - nextFirst - 1) {
            return items[nextFirst + 1 + index];
        } else{
            return items[index - (items.length - nextFirst - 1)];
        }
    }
}
