// Task : You are given a positive integer n.
//         Return the maximum product of any two digits in n.
//         Note: You may use the same digit twice if it appears more than once in n.

// Constraint : 10 <= n <= 109

// Approach : Iterate through all digits and use second biggest and largest number finding method for minimal space usage.

// Time and Space Complexity : TC : O(1) SC: O(1)

class Solution {
    public int maxProduct(int n) {
        int nCopy = n;
        int biggest = -1;
        int secBig = -1;
        
        while(nCopy != 0){
            int digit = nCopy % 10;

            if(digit >= biggest){
                secBig = biggest;  
                biggest = digit;
            }
            else if(digit > secBig){
                secBig = digit;
           }

            nCopy /= 10;            
        }

        return biggest * secBig; 
    }
}
