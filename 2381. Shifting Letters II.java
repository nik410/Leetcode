class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int len = s.length();
        int prefArr[] = new int[len + 1];

        for(int i = 0; i < shifts.length; i ++){
            int l = shifts[i][0];
            int r = shifts[i][1];
            int direction = shifts[i][2];

            if(direction == 0){
                prefArr[l] -= 1;
                prefArr[r  + 1] += 1;
            }
            else{
                prefArr[l] += 1;
                prefArr[r + 1] -= 1;
            }            
        }

        for(int i = 1; i < len + 1; i ++){
            prefArr[i] += prefArr[i - 1];
            System.out.print(prefArr[i] + " ");
        }

        // The newInd operation is important as it assigns the new shifted character at that index
        // + (26 * 100000) is done to negate negative shift values as the negative cycle shift
        // in worse case can be till the max length of the string possible so a number
        // that is multiple of 26 and greater than the upper bound of length of string possible is chosen
        // So it is not to have that exact value you can look at constrainst and change accordingly to your wish 


        String ans = "";

        for(int i = 0; i < len; i ++){
            int newInd = (int) ((s.charAt(i) + prefArr[i] - 'a' + (26 * 100000)) % 26 + 'a');
            ans += (char)(newInd);
        }

        return ans;

    }
}
