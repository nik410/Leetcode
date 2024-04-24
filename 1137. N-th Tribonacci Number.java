class Solution {
    
    // public static int tribonacciRecursion(int n) {
    //     if(n == 0 || n == 1 )return n;
    //     if(n == 2) return 1;

    //     return tribonacciRecursion(n - 1) + tribonacciRecursion(n - 2) + tribonacciRecursion(n - 3);
    // }


    public int tribonacci(int n) {
       
    //    return tribonacciRecursion(n);
    if(n == 0){
        return 0;
    }
    if(n == 1 || n == 2 )return 1;
    int tribo[] = new int[n + 1];
    tribo[0] = 0;
    tribo[1] = 1;
    tribo[2] = 1;

    for(int i = 3; i < n + 1; i++){
        tribo[i] = tribo[i - 1] + tribo[i - 2] + tribo[i - 3];
    }
    
    return tribo[n];
    }
}
