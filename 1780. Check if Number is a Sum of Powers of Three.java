class Solution {

    public boolean solve(int arr[], int index, int val){
        if(index >= arr.length)return false;
        if(val < 0) return false;
        if(val == 0) return true;


        if(index == arr.length - 1){
            if(val == arr[index] || val == 0)return true;
            else return false;
        }

        boolean take = false, notTake = false;

         if(arr[index] <= val){
            take =  solve(arr, index + 1, val - arr[index]);
         }

         notTake = solve(arr, index + 1, val);

         return (take || notTake);
    }

    public boolean checkPowersOfThree(int n) {
        // Generating a array containing all the powers of 3 ^ x where x is non negative integers
        // As the n ranges from 1 to 1e7  we take 

        // int power = 0;
        // int index = 0;
        // int arr[] = new int[20];
        // arr[0] = 1; // 3 ^ 0 == 1
        // for(int i = 1; i < 20; i ++){
        //     arr[i] = arr[i - 1] * 3; 
        // }   

        // Using recursion
        // return solve(arr, 0, n);

        // Using Memoization

        // Usage of an array is not suggested as such array size result in memory limit exceeded and tle
        // boolean dp[][] = new boolean[20][(int)(1e7 + 2)];
        // Use of hashmap can be done in stead
        // HashMap<Integer, Boolean> dp = new HashMap();
        
        // for(int i = 0; i < 20; i ++){
        //    dp.put(arr[i], true);
        // } 
        // return memoSolve(arr, 0, n, dp);  

        // TC: O(2^(log3 n))    

        // Mathematical approach is to find the ternary representation of the number
        // Ternary representaion(0, 1, 2) is similar to binary

        // If we get 2 in the representation it means we need 2 times of that 3^ position


        while(n > 0){
            if(n %  3 == 2)return false;
            n /= 3;
        } 

        return true;

    }

    public boolean memoSolve(int arr[], int index, int val, HashMap<Integer, Boolean> dp){
        if(index == arr.length) return false;

        // the extra and condition makes sure that a specific element
        if(dp.containsKey(val) && val / arr[index] > 0)return true;


        if(val < 0)return false;
        if(val == 0)return true;       

        if(index == arr.length - 1){            
            if(arr[index] == val || val == 0)return true;
            else return false;
        }

        boolean take = false, notTake = false;
    
        if(arr[index] <=  val){
            
            take = memoSolve(arr, index + 1, val - arr[index], dp);
        }

        notTake = memoSolve(arr, index + 1, val, dp);

        dp.put(val, (take || notTake));
        return (take || notTake);
    }
}
