public class AVLSet<E extends Comparable<E>> implements Set<E> {

    private AVL<E, Object> avl;

    public AVLSet() {
        avl = new AVL<E, Object>();
    }

    public void add(E e) {
        avl.add(e, null);
    }

    public void remove(E e) {
        avl.remove(e);
    }

    public boolean contains(E e) {
        return avl.contains(e);
    }

    public int getSize() {
        return avl.getSize();
    }

    public boolean isEmpty() {
        return avl.isEmpty();
    }
}
