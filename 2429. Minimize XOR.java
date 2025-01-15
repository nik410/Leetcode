class Solution {
    public int minimizeXor(int num1, int num2) {
        int setBitsInNum2 = 0;

        for(int i = 0; i < 32; i ++){
            if(((num2) & (1 << i)) != 0)setBitsInNum2 ++;
        }

        // for(int i = 0; i < 32; i ++){
        //     if(((num2 >> i) & 1) != 0)setBitsInNum2 ++;
        // }

        // System.out.println(setBitsInNum2 +" :Set Bits");
        
        int currBits = setBitsInNum2;

        int x = 0;
        
        for(int i = 31; i >= 0 && currBits > 0; i --){
            if(((num1) & (1 << i)) != 0){
                x +=(int) Math.pow(2, i);
                currBits --;
            }
        }

        System.out.println(currBits +" :Current Bits" + " xVal: " + x);


        for(int i = 0; i < 32 && currBits > 0; i ++){
            if(((num1) & (1 << i)) == 0){
                x += (int) Math.pow(2, i);
                currBits --;
            }
        }


        return x;
    }
}
