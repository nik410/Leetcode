Task : You are given an integer array nums.
      A XOR triplet is defined as the XOR of three elements nums[i] XOR nums[j] XOR nums[k] where i <= j <= k.
      Return the number of unique XOR triplet values from all possible triplets (i, j, k).

Contraint : 1 <= nums.length <= 1500
            1 <= nums[i] <= 1500

Approach : Use brute as contraint is small. But pure brute force will still give Time Limit Exceeded. Get all unique nums 
          then find all the unique xor with unique number and add at last the nums array numbers.

Time and Space complexity :  
  TC: O(n^2)
  SC: O(2048)

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        HashSet<Integer> hs = new HashSet();
        HashSet<Integer> xor = new HashSet();

        for(int i: nums){
            hs.add(i);
        }

        int numsUnique[] = new int[hs.size()];
        int lenUn = hs.size();

        int ind = 0;
        for(int i : hs){
            numsUnique[ind ++] = i;
        }

        for(int i = 0; i < lenUn; i ++){
            for(int j = i + 1; j < lenUn; j ++){
                int xorAB = (numsUnique[i] ^ numsUnique[j]);
                xor.add(xorAB);
            }
        }

        HashSet<Integer> finalXor = new HashSet();

        for(int i: xor){
            for(int j: numsUnique){
                int xorABC = (i ^ j);
                finalXor.add(xorABC);
            }
        }

        for(int i: nums){
            finalXor.add(i);
        }

        return finalXor.size();        
    }
}
