package com.practice.linkedList;

public class LinkedListFromArray {
    public static ListNode[] getList(){
        int[][] arr = {
                {1,4,5},
                {1,3,4},
                {2,6}
        };

        ListNode[] lists = new ListNode[arr.length];

        for (int i = 0; i < arr.length; i++) {
            lists[i] = buildList(arr[i]);
        }

        return lists;
    }
    // Helper to build linked list
    private static ListNode buildList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int num : nums) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }

        return dummy.next;
    }
}
