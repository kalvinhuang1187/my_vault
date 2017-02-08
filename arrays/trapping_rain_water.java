/*
42. Trapping Rain Water
---
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

 */

public class TrappingRainWater {
    // Idea: Begin scan from beginning and end of array. Compare value of left and right pointer,
    //    hold the greater one and move the other and compute passed area.
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        
        int secHeight = 0;
        int area = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                // secHeight keeps track of the highest wall on either side
                secHeight = Math.max(height[left], secHeight);
                // water trapped in unit is difference between highest wall and current height
                area += (secHeight - height[left]);
                left++;
            }
            else {
                secHeight = Math.max(secHeight, height[right]);
                area += (secHeight - height[right]);
                right--;
            }
        }
        
        return area;
    }
}

