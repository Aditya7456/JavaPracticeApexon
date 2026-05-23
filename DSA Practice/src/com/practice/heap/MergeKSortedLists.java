package com.practice.heap;

import com.practice.linkedList.LinkedListFromArray;
import com.practice.linkedList.ListNode;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args){
        ListNode[] lists = LinkedListFromArray.getList();
        ListNode root = mergeKLists(lists);
        while(root!=null){
            System.out.print(root.val + " ");
            root=root.next;
        }
    }
    public static ListNode mergeKLists(ListNode[] lists){
        if(lists==null || lists.length == 0) return null;
        // now let's create min Heap for this
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->
                a.val-b.val);
        // adding all head into the heap
        for(ListNode node:lists){
            minHeap.offer(node);
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!minHeap.isEmpty()){
            ListNode smallest = minHeap.poll();
            // making the new node
            curr.next=smallest;
            // now updating curr to the next node
            curr = curr.next;
            if(smallest.next!=null){
                minHeap.offer(smallest.next);
            }
        }
        return dummy.next;
    }
}
