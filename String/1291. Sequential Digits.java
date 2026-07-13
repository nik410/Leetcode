// Task:An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
// Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

// Constraint:
//     10 <= low <= high <= 10^9


// Approach: Onservation based as the string/number can be only a finite and calculabel set from the string  "123456789". The rest is simulation.
//   >> We can use digitDP as well but will be tricker to implement. Will require global variable for the list and hashset i suppose. [ TODO ].


  class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String s = "123456789";

        //Finding the length or number of digits in low
        int lenLow = 0;
        int tempLow = low;
        while(tempLow > 0){
            tempLow /= 10;
            lenLow++;
        }

        int lenHigh = 0;
        int tempHigh = high;
        while(tempHigh > 0){
            tempHigh /= 10;
            lenHigh++;
        }
        List<Integer> al = new ArrayList();
        for(int j = lenLow; j <= lenHigh; j++){
            for(int i = 0; i < 10 - j; i++){
                String num = s.substring(i, i + j);

                int windNum = Integer.parseInt(num);

                if(windNum >= low && windNum <= high){
                    al.add(windNum);
                }
            }
         }

         return al;
        
    }
}
