Task: Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).

 

Constraint: 2 <= nums.length <= 500
            1 <= nums[i] <= 10^3

Approach: Use a priorty queue or sorting. Optimal way iterate through once and find max and secondMax val

Time and Space Complexity: 
  TC: O(n)
  SC: O(1)

class Solution {
    public int maxProduct(int[] nums) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        // for(int i: nums)pq.add(i);
      
        // return (pq.remove() - 1) * (pq.remove() - 1);

        int maxVal = 0;
        int secondMaxVal = 0;

        for(int i: nums){
            if(i > maxVal){
                secondMaxVal = maxVal;
                maxVal = i;
            }
            else if(i > secondMaxVal){
                secondMaxVal = i;
            }
        }

        return (secondMaxVal - 1) * (maxVal - 1);
    }
}
