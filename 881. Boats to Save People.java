class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        int numBoats = 0;
        while(l <= r){
            int num1 = people[l];
            int num2 = people[r];
            if(num2 + num1 > limit){
                numBoats++;
                r--;
            }
            else{
                l++;
                r--;
                numBoats++;
            }
        }

        return numBoats;
    }
}
