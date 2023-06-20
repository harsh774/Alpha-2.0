package priorityQueue;

import java.util.*;

public class HeapProperties {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            // adding at last
            arr.add(data);

            int child = arr.size() - 1; // child index
            int parent = (child - 1) / 2; // parent index

            while (arr.get(child) < arr.get(parent)) { // O{logn}

                // swapping
                int temp = arr.get(child);

                // using set method
                arr.set(child, arr.get(parent));
                arr.set(parent, temp);

                child = parent;
                parent = (child - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = (2 * i) + 1;
            int right = (2 * i) + 2;
            int minIdx = i;

            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }

            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            if (minIdx != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(arr.get(minIdx), temp);

                heapify(minIdx);
            }
        }

        public int remove() {
            int data = arr.get(0);

            // swap 1st and last node values
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // delete last
            arr.remove(arr.size() - 1);

            // heapify
            heapify(0);
            return data;

        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap pq = new Heap();
        pq.add(2);
        pq.add(3);
        pq.add(4);
        pq.add(5);
        pq.add(10);
        pq.add(6);

        while (!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.remove();
        }

    }
}
