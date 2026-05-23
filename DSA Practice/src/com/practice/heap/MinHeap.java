package com.practice.heap;
// parent<=child
public class MinHeap {
    int [] heap;
    int size;
    int capacity;

    public MinHeap(int capacity){
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    // insertion in min heap
    // In min heap we insert at the last position then we heapify up
    public void insert(int val){
        // checking if the heap is full
        if(size == capacity) throw new RuntimeException("heap is full!");
        // otherwise let's insert at the last
        heap[size] = val;
        int curr = size;
        size++;
        //not let's heapify up(if current is less than the parent then swap otherwise no problem
        while(curr>0 && heap[curr]<heap[(curr-1)]/2){
            // let's swap the curr with parent
            swap(curr,(curr-1)/2);
            // now curr will refer to the parent position
            curr = (curr-1)/2;
        }
    }

    // removal from the heap
    // In min heap we remove the top element and then copy last element to first and then heapify down
    public int remove(){
        // checking if the heap is empty
        if(size == 0) throw new RuntimeException("Oops!, Heap is empty.....");
        // else remove the first element then copy the last to the first then heapify down
        int min = heap[0]; // took the first element
        heap[0] = heap[size-1]; // copied the last element to the first
        size--; // reduced the size
        //now let's heapify down
        int curr = 0;
        while(true){
            int left  = 2*curr+1;
            int right = 2*curr+2;
            int smallest = curr;
            if(left<size && heap[left]<heap[smallest]) smallest = left;
            if(right<size && heap[right]<heap[smallest]) smallest = right;
            // if the curr is itself the smallest from the children then break;
            if(smallest == curr) break;
            // now let's swap the curr with the smallest child
            swap(curr,smallest);
            // let's update the current
            curr = smallest;
        }
        return min;
    }

    // we will just return the top element from the heap
    public int peek(){
        // if there is no element in the heap
        if(size == 0) throw new RuntimeException("Oops!, There is no element in the heap!");
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
