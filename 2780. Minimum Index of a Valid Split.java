class Solution {
    public int minimumIndex(List<Integer> nums) {
        int len = nums.size();
      

        int maxCand = -1;
        int count = 0;
        for(int i = 0; i < len; i ++){
            int val = nums.get(i);
            
            if(maxCand == -1 || count == 0){
                maxCand = val;
                count ++;
            }
            else if( val == maxCand){
                count ++;
            }
            else if(val != maxCand){
                count --;
            }
        }

        System.out.println("maxCAnd: " + maxCand);

        // Making sure the max Candidate is actually having more than half
        
        count = 0;
        for(int i: nums){
            if(i == maxCand)count ++;
        }

        if(count < ((len +(2) - 1)/ 2)) return -1;
        else{
              int countMaxCand[] = new int[len];

                if(nums.get(0) == maxCand){
                    countMaxCand[0] =  1;

                    if(count - 1 > (len - 1) / 2)return 0;
                }

              for(int i = 1; i < len; i ++){
                    int val = nums.get(i);
                    int sizeG1 = i + 1;
                    int sizeG2 = len - sizeG1;
                    if(val == maxCand){
                        countMaxCand[i] = countMaxCand[i - 1] + 1;
                        if(countMaxCand[i] > sizeG1/ 2 &&
                            count - countMaxCand[i] > sizeG2 / 2)return i;
                    }
                    else{
                         countMaxCand[i] = countMaxCand[i - 1];
                        if(countMaxCand[i] > sizeG1/ 2 &&
                            count - countMaxCand[i] > sizeG2 / 2)return i;
                    }
              }

              return -1;
        }  
      
    }
}
