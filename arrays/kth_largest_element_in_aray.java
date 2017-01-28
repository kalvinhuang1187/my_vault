/*
215. Kth Largest Element in an Array
---
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
 */

/*
The basic idea is to use Quick Select algorithm to partition the array with pivot:

Put numbers < pivot to pivot's left
Put numbers > pivot to pivot's right
Then

if indexOfPivot == k, return A[k]
else if indexOfPivot < k, keep checking left part to pivot
else if indexOfPivot > k, keep checking right part to pivot
*/

/* Time complexity

Average Case = O(n)
Discard half each time: n+(n/2)+(n/4)..1 = n + (n-1) = O(2n-1) = O(n), because n/2+n/4+n/8+..1=n-1.

Worst Case = O(n^2)
*/
public class KthElementArray {
    // k is the Kth largest elem from end of array
    // input k = 2, num.length = 5, k (in params) = 4 (2nd last elem from back of array)
    public int findKthLargestHelper(int[] nums, int start, int end, int k) {
        if (start > end)
            return Integer.MAX_VALUE;
            
        // Take last element (A[end]) as the pivot
        int pivot = nums[end];
        int left = start;
        
        for (int i = start; i < end; i++) {
        // Put numbers < pivot to pivot's left
        if (nums[i] <= pivot) {
          swap(nums, left, i);
          left++;
        }
      }
      
      swap(nums, left, end);  // Finally, swap A[end] with A[left]
      
      if (left == k) // Found kth smallest number
        return nums[left];
      else if (left < k) // Check right part
        return findKthLargestHelper(nums, left + 1, end, k);
      else // Check left part
        return findKthLargestHelper(nums, start, left - 1, k);
    }
    
    public void swap(int[] a, int i, int j) {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;        
    }
    
    //use shuffle to randomize the elements to avoid worst case
    private void shuffle(int a[]) {
        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            swap(a, ind, r);
        }
    }
    
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return Integer.MAX_VALUE;
            
        shuffle(nums);
            
        return findKthLargestHelper(nums, 0, nums.length - 1, nums.length - k);
    }
}

