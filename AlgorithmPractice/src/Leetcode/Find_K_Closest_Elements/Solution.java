package Leetcode.Find_K_Closest_Elements;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> list = new LinkedList<>();
        int l=0, h=arr.length-k,m;
        
        while(l<h){
            m = l+(h-l)/2;
            if(x-arr[m]>arr[m+k]-x)
                l=m+1;
            else
                h=m;
        }
        for(int i=l+0;i<l+k+0;i++)
            list.add(arr[i]);
        
        return list;
    }
}
