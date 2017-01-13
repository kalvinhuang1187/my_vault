/*
204. Count Primes
---
Description:

Count the number of prime numbers less than a non-negative number, n.
---
For example, if n is 10, the output should be 4. 
 */

public class countPrime {
    public int countPrimes(int n) {
        boolean prime[] = new boolean[n+1];
        int count = 0;
        
        // go through every number
        for (int i = 2; i < n; i++) {
            // found a prime number, increment count
            if (prime[i] == false) {
                count++;
                // find all multiples of the prime number and mark them
                for (int j = 2; i*j < n; j++) {
                    prime[i*j] = true;
                }
            }
        }
        
        return count;
    }
}

