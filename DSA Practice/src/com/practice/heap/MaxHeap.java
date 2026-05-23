package com.practice.heap;
// parent >= child
public class MaxHeap {
    int[] heap;
    int size;
    int capacity;

    public MaxHeap(int capacity){
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    // insertion in the maxHeap
    public void insert(int val){
        // if heap is already full then we can't insert
        if(size == capacity) throw new RuntimeException("Heap is already full!");
        // else insert at the last
        heap[size] = val;
        int curr = size;
        size++;
        // now let's heapify up
        while(curr>0 && heap[curr]>heap[(curr-1)/2]){
            swap(curr,(curr-1)/2);
            curr=(curr-1)/2;
        }
    }

    // remove from the maxHeap
    public int remove(){
        // if the heap is empty, you can't remove
        if(size == 0) throw new RuntimeException("Oops! Heap is empty....");
        // else remove the first element and copied last to first
        int max = heap[0];
        heap[0] = heap[size-1];
        size--;

        // now let's heapify down
        int curr = 0;
        while(true){
            int left = 2 * curr + 1;
            int right = 2 * curr + 2;
            int largest = curr;
            if(left<size && heap[largest]<heap[left]) largest = left;
            if(right<size && heap[largest]<heap[right]) largest = right;
            // now check if the curr is itself the largest element then break from here
            if(curr == largest) break;
            // else swap both, curr with the largest of the child
            swap(curr,largest);
            curr=largest;
        }
        return max;
    }
    // we will return the first element of the heap
    public int peek(){
        // if the heap is empty then no element to peek
        if(size == 0) throw new RuntimeException("Oops! no element to peek...");
        // else return the first element
        return heap[0];
    }
    public void print(){
        for(int i=0; i<size; i++){
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
    public void swap(int i, int j){
        int temp = heap[j];
        heap[j] = heap[i];
        heap[i] = temp;
    }
}
