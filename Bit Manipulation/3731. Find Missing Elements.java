// Task: You are given an integer array nums consisting of unique integers.
//       Originally, nums contained every integer within a certain range. However, some integers might have gone missing from the array.
//       The smallest and largest integers of the original range are still present in nums.
//       Return a sorted list of all the missing integers in this range. If no integers are missing, return an empty list.

// Constraint: 2 <= nums.length <= 100
//             1 <= nums[i] <= 100

// Approach: Make use of the BitSet class. Very cool data structure, uses math and bit manipulation internally. Implementation checked.

// Time and Space Complexity: 
//   TC: O(n)
//   SC: O(n)

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        BitSet b = new BitSet();

        for(int i: nums){
            minVal = Math.min(i, minVal);
            maxVal = Math.max(i, maxVal);
            b.set(i);
        }

        List<Integer> missingEle = new ArrayList();
        for(int i = minVal; i <= maxVal; i ++){
            if(!b.get(i)){
                missingEle.add(i);
            }
        }

        return missingEle;
    }
}
