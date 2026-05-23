package com.practice.binarySearch;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args){
        int[] arr1 = {1,3,4,7,10,12};
        int[] arr2 = {2,3,6,15};
        // output : (4+6)/2 -> 5
        System.out.println(findMedianSortedArrays(arr1,arr2));
    }
    public static double findMedianSortedArrays(int[] arr1,int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        // Always performing binary search on smaller array
        if(n1>n2) return findMedianSortedArrays(arr2,arr1);
        int low = 0;
        int high = n1;
        int left = (n1+n2+1)/2;
        int n = n1+n2;
        while(low<=high){
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if(mid1<n1) r1=arr1[mid1];
            if(mid2<n2) r2=arr2[mid2];
            if(mid1-1>=0) l1 = arr1[mid1-1];
            if(mid2-1>=0) l2 = arr2[mid2-1];
            if(l1<=r2 && l2<=r1){
                // if the total length is even
                if(n % 2 == 1)  return Math.max(l1,l2);
                return ((double)(Math.max(l1,l2) + Math.min(r1,r2)))/2.0;
            }
            else if(l1>r2) high = mid1-1;
            else low = mid1+1;
        }
    return 0;
    }
}
