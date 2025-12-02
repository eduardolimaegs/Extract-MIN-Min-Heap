import java.util.NoSuchElementException;

public class Main {
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


