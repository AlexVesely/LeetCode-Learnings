package DataStructures;
import java.util.Arrays;

public class HeapsLearning {

    static class BinaryHeap {
        private final int[] heap;
        private int size;
        private final int capacity;

        public BinaryHeap(int capacity) {
            this.capacity = capacity;
            this.heap = new int[capacity];
            this.size = 0;
        }

        private int parent(int index) {
            return (index - 1) / 2;
        }

        private int leftChild(int index) {
            return 2 * index + 1;
        }

        private int rightChild(int index) {
            return 2 * index + 2;
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        public void insert(int value) {
            if (size == capacity) {
                throw new IllegalStateException("Heap is full");
            }
            heap[size] = value; // Place the value at the end
            size++;
            int current = size - 1;

            while (current > 0 && heap[current] < heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
        }

        public int extractMin() {
            if (size == 0) {
                throw new IllegalStateException("Heap is empty");
            }
            int min = heap[0];
            heap[0] = heap[size - 1]; // Move the last element to the root
            size--;
            heapify(0);
            return min;
        }

        private void heapify(int index) {
            int smallest = index;
            int left = leftChild(index);
            int right = rightChild(index);

            if (left < size && heap[left] < heap[smallest]) {
                smallest = left;
            }
            if (right < size && heap[right] < heap[smallest]) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                heapify(smallest);
            }
        }

        public static void heapSort(int[] array) {
            int n = array.length;
            BinaryHeap minHeap = new BinaryHeap(n);

            // Build the heap
            for (int value : array) {
                minHeap.insert(value);
            }

            // Extract elements from the heap in sorted order
            for (int i = 0; i < n; i++) {
                array[i] = minHeap.extractMin();
            }
        }

        public static void main(String[] args) {
            int[] array = {12, 11, 13, 5, 6, 7};

            System.out.println("Original array:");
            System.out.print(Arrays.toString(array));

            heapSort(array);

            System.out.println("Sorted array:");
            System.out.print(Arrays.toString(array));
        }
    }
}
