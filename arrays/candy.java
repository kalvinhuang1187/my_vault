/*
135 candy[array/greedy]
---
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Example 1:

Input: [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

Example 2:

Input: [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
             The third child gets 1 candy because it satisfies the above two conditions.

*/

public static int candy(int[] ratings) {
    int[] candies = new int[ratings.length];
    Arrays.fill(candies, 1);
    
    // Scan from left to right, make sure current is greater than left-lower-child and gets 1 more candy
    for (int i = 1; i < candies.length; i++) {
      if (ratings[i] > ratings[i-1]) {
        candies[i] = candies[i-1] + 1;
      }
    }
    
    // Scan from right to left, make sure current is greater than right-lower-child and gets 1 more candy
    for (int j = candies.length - 2; j >= 0; j--) {
      if (ratings[j] > ratings[j+1]) {
        candies[j] = Math.max(candies[j], candies[j+1] + 1);
      }
    }

    int sum = 0;
    for (int c : candies) {
      sum += c;
    }
    
    return sum;
}
