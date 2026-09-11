// Task: You are given an array of digits called digits. Your task is to determine the number of distinct three-digit even numbers that can be formed using these digits.
//       Note: Each copy of a digit can only be used once per number, and there may not be leading zeros.

// Constraint: 3 <= digits.length <= 10
//             0 <= digits[i] <= 9

// Approach: The intial intution was wrong and very complex. The answer was in the question itself the answer space is very small.
//           The answer space can be traversed one by one

// Time and Space Complexity: 
//   TC: O(1)
//   SC: O(1)

class Solution {
    public int totalNumbers(int[] digits) {
        // int zeroCount = 0;
        // int even = 0;
        // int odd = 0;
        // int count[] = new int[10];

        // for(int i: digits){
        //     count[i] ++;
        //     if(i == 0){
        //         zeroCount ++;
        //     }
        //     if(i % 2 == 0){
        //         even ++;
        //     }
        //     if(i % 2 == 1){
        //         odd ++;
        //     }
        // }

        // int nonZeroDigitCount = digits.length - zeroCount;

        // // Use counting approach 
        // // Basically multipliaction role of which digits are allowed at a specific place
        // // At first digit all non - zero can be put and at last digit only even can be put
        
        // if(even == 0){
        //     return 0;
        // }

        // int ways = 1;
        // int remainNonZero = nonZeroDigitCount;
        // int remainEven = even;
        // int totalDigit = digits.length;

        // // First we will fix the last figit to be a even number(0, 2, 4, 6, 8)
        // ways *= even;
        // totalDigit --;

        // // Fix the first digit

        // ways *= remainNonZero - 1;

        // // Then second

        // ways *= totalDigit - 1;

        
        // // Remove duplicates 

        // for(int i = 0; i < 10; i ++){
        //     int freq = count[i];

        //     if(freq == 0)continue;

        //     for(int j = 0; j < freq; j ++){
        //         ways /= (j + 1);
        //     }
        // }

        // return ways;

        // First instinct was to use permutation and combination but it fails.
        // Upon looking into the contrainst we can simply build all the answer search space for 3 digit
        // from 100 to 999 and then see if the specific 3 digit term is possible or not

        int len = digits.length;

        int count[] = new int[10];

        for(int i: digits){
            count[i] ++;
        }

        int ans = 0;

    loop: for(int i = 100; i <= 999; i ++){
            int firstDig = (i / 100);
            int secDig = (i / 10) % 10;  
            int thirdDig = i % 10;

            if(thirdDig % 2 == 1)continue;

            HashMap<Integer, Integer> hm = new HashMap();

            hm.put(firstDig, hm.getOrDefault(firstDig, 0) + 1);
            hm.put(secDig, hm.getOrDefault(secDig, 0) + 1);
            hm.put(thirdDig, hm.getOrDefault(thirdDig, 0) + 1);

            for(int j: hm.keySet()){
                if(count[j] < hm.get(j)){
                    continue loop;
                } 
            }

            ans ++;
        }

        return ans;

    }
}
