class Solution {

    public boolean recur(String val, int index, int target){
        
        if(index == val.length()){
            if(target == 0)return true;
            else return false;
        }
        
        int sum = 0;
        for(int i = index; i < val.length(); i ++){
            // sum = sum * 10 + Character.getNumericValue(val.charAt(i));
            // System.out.println(sum +" :Sum");
            // Or using 
            sum = sum * 10 + (int)(val.charAt(i) - '0');

            if(sum > target)return false;
            if(recur(val, i + 1, target - sum))return true;
        }

        return false;
    }

    public int punishmentNumber(int n) {
        int ans = 0;

        for(int i = 1; i <= n; i ++){
            String val = Integer.toString(i * i);
            // System.out.println(val + " val");
            if(recur(val, 0, i)){            
                ans += i * i;
            }
        }

        return ans;
    }
}
