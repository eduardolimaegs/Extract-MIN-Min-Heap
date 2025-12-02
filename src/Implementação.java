import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MinHeap {
    private List<Integer> heap;
    private int size;

    public MinHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(null);
        this.size = 0;
    }
    public int size() {
        return size;
    }
    private int parent(int i) {
        return i / 2;
    }
    private int leftChild(int i) {
        return 2 * i;
    }
    private int rightChild(int i) {
        return 2 * i + 1;
    }
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    private void minHeapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;

        if (left <= size && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }
        if (right <= size && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }
    public void insert(int key) {
        heap.add(key);
        size++;
        int i = size;
        while (i > 1 && heap.get(parent(i)) > heap.get(i)) {
            swap(i, parent(i));
            i = parent(i);
        }
    }
    public int extractMin() {
        if (size == 0) {
            throw new NoSuchElementException("Heap está vazio.");
        }
        int minVal = heap.get(1);

        heap.set(1, heap.get(size));

        heap.remove(size);
        size--;

        if (size > 0) {
            minHeapify(1);
        }

        return minVal;
    }
    @Override
    public String toString() {
        return heap.subList(1, heap.size()).toString();
    }
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        System.out.println("Inserindo elementos: 10, 5, 15, 3, 7, 20");
        for (int val : new int[]{10, 5, 15, 3, 7, 20}) {
            minHeap.insert(val);
        }
        System.out.println("Heap após inserções: " + minHeap);

        System.out.println("\nExtraindo o mínimo (extractMin):");

        int min1 = minHeap.extractMin();
        System.out.println("Mínimo extraído: " + min1);
        System.out.println("Heap após 1ª extração: " + minHeap);

        int min2 = minHeap.extractMin();
        System.out.println("Mínimo extraído: " + min2);
        System.out.println("Heap após 2ª extração: " + minHeap);

        int min3 = minHeap.extractMin();
        System.out.println("Mínimo extraído: " + min3);
        System.out.println("Heap após 3ª extração: " + minHeap);

        System.out.println("\nExtraindo o restante:");
        while (minHeap.size() > 0) {
            System.out.println("Mínimo extraído: " + minHeap.extractMin());
        }
        System.out.println("Heap final: " + minHeap);

        try {
            System.out.print("\nTentando extrair de um heap vazio: ");
            minHeap.extractMin();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}
