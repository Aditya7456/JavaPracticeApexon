package com.practice.heap;

public class Main {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(5);
        for(int i=0; i<5; i++){
            heap.insert(i+1);
        }
        heap.print();
        heap.remove();
        heap.print();
    }
}
