public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<E>();
    }

    public int getSize() {
        return maxHeap.size();
    }

    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    public E getFront() {
        return maxHeap.findMax();
    }

    public E dequeue() {
        return maxHeap.extractMax();
    }

    public void enqueue(E e) {
        maxHeap.add(e);
    }

}
