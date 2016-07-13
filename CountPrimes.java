/*Count the number of prime numbers less than a non-negative number, n.*/

public class Solution {
    public int countPrimes(int n) {
        if (n < 3) return 0;
        boolean[] notPrimes = new boolean[n];

        // first mark off even numbers
        for (int i = 4; i < n; i = i + 2) {
            notPrimes[i] = true;
        }

        // mark off other non-primes, skip the even numbers
        for (int i = 3; i < Math.sqrt(n); i++) {
            if (!notPrimes[i]) {
                for (int j = i * i; j < n; j += 2 * i) {
                    notPrimes[j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrimes[i]) count++;
        }
        return count;
    }
}