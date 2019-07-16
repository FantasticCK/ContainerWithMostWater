package com.CK;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        int[] height = new int[]{1, 1};
        Solution solution = new Solution();
        System.out.println(solution.maxArea(height));
    }
}

class Solution {
    public int maxArea(int[] height) {
        int left, right, max = Integer.MIN_VALUE, surveyor[], newH;
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < height.length; i++) {
            heap.offer(new int[]{i, height[i]});
        }
        surveyor = heap.poll();
        left = surveyor[0];
        right = surveyor[0];
        for (int j = heap.size(); j > 0; j--) {
            surveyor = heap.poll();
            right = surveyor[0] > right ? surveyor[0] : right;
            left = surveyor[0] < left ? surveyor[0] : left;
            newH = surveyor[1];
            if (newH * (right - left) > max) max = newH * (right - left);
        }
        return max;
    }
}

// Two Pointers
class Solution2 {
    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}