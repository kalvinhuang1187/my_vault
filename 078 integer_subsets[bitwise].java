/*
78. Subsets
---
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
      Arrays.sort(nums);
      int totalNumber = 1 << nums.length;
        
      List<List<Integer>> result = new ArrayList<List<Integer>>(totalNumber);
      
      for (int i = 0; i < totalNumber; i++) { //8
        List<Integer> subset = new LinkedList<Integer>();
        
        for (int j = 0; j < nums.length; j++) { //3
          //System.out.println( "i:" + i + " j:" + j + " (1<<j):" + (1<<j) + " (i & (1<<j)):" + (i & (1<<j)));
          if ((i & (1<<j)) != 0) {
            subset.add(nums[j]);
          }
        }
        result.add(subset);
      }
      return result;
    }
}

/*
                                    1       1<<j     i      i & (1<<j)
i:0 j:0 (1<<j):1 (i & (1<<j)):0    0001     0001    0000    = 0          
i:0 j:1 (1<<j):2 (i & (1<<j)):0    0001     0010    0000    = 0
i:0 j:2 (1<<j):4 (i & (1<<j)):0    0001     0100    0000    = 0
i:1 j:0 (1<<j):1 (i & (1<<j)):1    0001     0001    0001    = 1
i:1 j:1 (1<<j):2 (i & (1<<j)):0    0001     0010    0001    = 0
i:1 j:2 (1<<j):4 (i & (1<<j)):0    0001     0100    0001    = 0
i:2 j:0 (1<<j):1 (i & (1<<j)):0             0001    0010    = 0
i:2 j:1 (1<<j):2 (i & (1<<j)):2             0010    0010    = 2
i:2 j:2 (1<<j):4 (i & (1<<j)):0             0100    0010    = 0
i:3 j:0 (1<<j):1 (i & (1<<j)):1             0001    0011    = 1
i:3 j:1 (1<<j):2 (i & (1<<j)):2             0010    0011    = 2
i:3 j:2 (1<<j):4 (i & (1<<j)):0             0100    0011    = 0
i:4 j:0 (1<<j):1 (i & (1<<j)):0             0001    0100    = 0
i:4 j:1 (1<<j):2 (i & (1<<j)):0             0010    0100    = 0
i:4 j:2 (1<<j):4 (i & (1<<j)):4             0100    0100    = 4
i:5 j:0 (1<<j):1 (i & (1<<j)):1             0001    0101    = 1
i:5 j:1 (1<<j):2 (i & (1<<j)):0             0010    0101    = 0
i:5 j:2 (1<<j):4 (i & (1<<j)):4             0100    0101    = 4
i:6 j:0 (1<<j):1 (i & (1<<j)):0             0001    0110    = 0
i:6 j:1 (1<<j):2 (i & (1<<j)):2             0010    0110    = 2
i:6 j:2 (1<<j):4 (i & (1<<j)):4             0100    0110    = 4
i:7 j:0 (1<<j):1 (i & (1<<j)):1             0001    0111    = 1
i:7 j:1 (1<<j):2 (i & (1<<j)):2             0010    0111    = 2
i:7 j:2 (1<<j):4 (i & (1<<j)):4             0100    0111    = 4
*/
                    

/*
 Number of subsets for {1 , 2 , 3 } = 2^3 .
 why ? 
case    possible outcomes for the set of subsets
  1   ->          Take or dont take = 2 
  2   ->          Take or dont take = 2  
  3   ->          Take or dont take = 2 

therefore , total = 2*2*2 = 2^3 = { { } , {1} , {2} , {3} , {1,2} , {1,3} , {2,3} , {1,2,3} }

Lets assign bits to each outcome  -> First bit to 1 , Second bit to 2 and third bit to 3
Take = 1
Dont take = 0
 
0) 0 0 0  -> Dont take 3 , Dont take 2 , Dont take 1    = { } 
1) 0 0 1  -> Dont take 3 , Dont take 2 ,    take 1      = { 1 } 
2) 0 1 0  -> Dont take 3 ,    take 2   , Dont take 1    = { 2 } 
3) 0 1 1  -> Dont take 3 ,    take 2   ,    take 1      = { 1 , 2 } 
4) 1 0 0  ->    take 3   , Dont take 2 , Dont take 1    = { 3 } 
5) 1 0 1  ->    take 3   , Dont take 2 ,    take 1      = { 1 , 3 } 
6) 1 1 0  ->    take 3   ,    take 2   , Dont take 1    = { 2 , 3 } 
7) 1 1 1  ->    take 3   ,    take 2   ,    take 1      = { 1 , 2 , 3 } 

In the above logic ,Insert S[i] only if (j>>i)&1 ==true   { j E { 0,1,2,3,4,5,6,7 }   i = ith element in the input array }

element 1 is inserted only into those places where 1st bit of j is 1 
   if( j >> 0 &1 )  ==> for above above eg. this is true for sl.no.( j )= 1 , 3 , 5 , 7 

element 2 is inserted only into those places where 2nd bit of j is 1 
   if( j >> 1 &1 )  == for above above eg. this is true for sl.no.( j ) = 2 , 3 , 6 , 7

element 3 is inserted only into those places where 3rd bit of j is 1 
   if( j >> 2 & 1 )  == for above above eg. this is true for sl.no.( j ) = 4 , 5 , 6 , 7 

Time complexity : O(n*2^n) , for every input element loop traverses the whole solution set length i.e. 2^n
*/

