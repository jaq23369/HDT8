package uvg.edu.gt;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase que implementa una cola de prioridad usando un heap binario.
 * Esta estructura de datos mantiene sus elementos en un orden tal que
 * el valor más pequeño (según su orden natural) siempre está en la raíz.
 * 
 * @param <E> El tipo de elementos que la cola de prioridad va a manejar,
 *            debe ser un tipo que extienda Comparable.
 */
public class VectorHeap<E extends Comparable<E>> {
    
    // Estructura interna para almacenar los elementos del heap.
    private ArrayList<E> heap;

    /**
     * Constructor que inicializa un nuevo VectorHeap vacío.
     */
    public VectorHeap() {
        heap = new ArrayList<>();
    }

    /**
     * Calcula el índice del padre de un nodo en el heap.
     *
     * @param pos El índice del nodo.
     * @return El índice del padre del nodo.
     */
    protected int parent(int pos) {
        return (pos - 1) / 2;
    }

    /**
     * Calcula el índice del hijo izquierdo de un nodo en el heap.
     *
     * @param pos El índice del nodo.
     * @return El índice del hijo izquierdo del nodo.
     */
    protected int leftChild(int pos) {
        return 2 * pos + 1;
    }

    /**
     * Calcula el índice del hijo derecho de un nodo en el heap.
     *
     * @param pos El índice del nodo.
     * @return El índice del hijo derecho del nodo.
     */
    protected int rightChild(int pos) {
        return 2 * pos + 2;
    }

    /**
     * Función que mantiene la propiedad de heap al desplazar un nodo hacia arriba.
     *
     * @param pos El índice del nodo que se está desplazando hacia arriba.
     */
    protected void percolateUp(int pos) {
        while (pos > 0 && heap.get(pos).compareTo(heap.get(parent(pos))) < 0) {
            Collections.swap(heap, pos, parent(pos));
            pos = parent(pos);
        }
    }

    /**
     * Añade un nuevo elemento al heap.
     *
     * @param value El elemento a añadir.
     */
    public void add(E value) {
        heap.add(value);
        percolateUp(heap.size() - 1);
    }

    /**
     * Función que mantiene la propiedad de heap al desplazar un nodo hacia abajo.
     *
     * @param pos El índice del nodo que se está desplazando hacia abajo.
     */
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

    /**
     * Determina si un nodo es una hoja en el heap.
     *
     * @param pos El índice del nodo.
     * @return Verdadero si el nodo es una hoja, falso en caso contrario.
     */
    protected boolean isLeaf(int pos) {
        return (pos >= heap.size() / 2) && (pos < heap.size());
    }

    /**
     * Elimina y devuelve el elemento en la raíz del heap (el elemento mínimo).
     *
     * @return El elemento mínimo del heap.
     */
    public E remove() {
        Collections.swap(heap, 0, heap.size() - 1);
        E temp = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            pushDownRoot(0);
        }
        return temp;
    }

    /**
     * Verifica si el heap está vacío.
     *
     * @return Verdadero si el heap está vacío, falso en caso contrario.
     */
    public boolean isEmpty() {
        return heap.size() == 0;
    }

    /**
     * Devuelve el elemento en la raíz del heap sin eliminarlo.
     *
     * @return El elemento mínimo del heap si existe, nulo en caso contrario.
     */
    public E peek() {
        if (!heap.isEmpty()) {
            return heap.get(0);
        }
        return null; // O considera lanzar una excepción si se prefiere manejar de esa manera.
    }
}


