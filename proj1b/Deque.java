public interface Deque<Item> {
    public void addFirst(Item item);
    public void addLast(Item item);
    public int size();
    public void printDeque();
    public Item getIterative(int index);
    public Item removeFirst();
    public Item removeLast();
    default public boolean isEmpty(){
        return (size() == 0);
    }
}
