package uvg.edu.gt;


import java.util.ArrayList;
import java.util.Collections;

public class VectorHeap<E extends Comparable<E>>{    
    private ArrayList<E> heap;

    public VectorHeap() {
        heap = new ArrayList<E>();
    }

    protected int parent(int pos) {
        return (pos - 1) / 2;
    }

    protected int leftChild(int pos) {
        return 2 * pos + 1;
    }

    protected int rightChild(int pos) {
        return 2 * pos + 2;
    }

    protected void percolateUp(int pos) {
        while (pos > 0 && heap.get(pos).compareTo(heap.get(parent(pos))) < 0) {
            Collections.swap(heap, pos, parent(pos));
            pos = parent(pos);
        }
    }

    public void add(E value) {
        heap.add(value);
        percolateUp(heap.size() - 1);
    }

    protected void pushDownRoot(int pos) {
        int smallestChild;
        while (!isLeaf(pos)) {
            smallestChild = leftChild(pos);
            if (smallestChild < heap.size() - 1 && heap.get(smallestChild).compareTo(heap.get(smallestChild + 1)) > 0) {
                smallestChild = smallestChild + 1;
            }
            if (heap.get(pos).compareTo(heap.get(smallestChild)) <= 0) {
                return;
            }
            Collections.swap(heap, pos, smallestChild);
            pos = smallestChild;
        }
    }

    protected boolean isLeaf(int pos) {
        return (pos >= heap.size() / 2) && (pos < heap.size());
    }

    public E remove() {
        Collections.swap(heap, 0, heap.size() - 1);
        E temp = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            pushDownRoot(0);
        }
        return temp;
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }
}

