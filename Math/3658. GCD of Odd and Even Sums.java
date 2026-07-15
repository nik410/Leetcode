// Task : You are given an integer n. Your task is to compute the GCD (greatest common divisor) of two values:
//     sumOdd: the sum of the smallest n positive odd numbers.
//     sumEven: the sum of the smallest n positive even numbers.
// Return the GCD of sumOdd and sumEven.

// Constraint : 1 <= n <= 10​​​​​​​00

// Approach: Use Arithmatic progression to genrate formuleas foe the two sequence and use euclidean gcd concept

class Solution {
    public int gcdOfOddEvenSums(int n) {
        // We can generate the formula for the sumOdd sequence using Arithmatic progression
        // sigma (2i + 1) = (2 * n^2 + 2 * n + 2 *n) / 2 = (n^2 + 2 * n)

        int oddSum = (n * n + 2 * n);

        // sigma (2i) = 2 sigma(i) = 2 * (n * (n + 1)) / 2 = n * (n + 1)

        int evenSum = ((n) * (n + 1));

        int gcd = gcdIte(oddSum, evenSum);

        // System.out.println("Odd:" + oddSum + " Even: " + evenSum + " gcd: "+ gcd);

        return gcd;
    }

    int gcdIte(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    int gcdRecur(int a, int b){
        if(b == 0)return a;

        return gcdRecur(b, a % b);
    }
}
