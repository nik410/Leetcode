class Solution {

    class MyComparator implements Comparator<String>{
        public int compare(String s1, String s2){
            String st1 = s1 + "" + s2;
            String st2 = s2 + "" + s1;
            return st2.compareTo(st1);
        }
    }

    public String largestNumber(int[] nums) {
        int len = nums.length;
        String num[] = new String[len];
        int index = 0;
        for(int i: nums){
            num[index ++] = Integer.toString(i);
        }

        Arrays.sort(num, new MyComparator());

        if(num[0].charAt(0) == '0')return "0";

        String ans = "";

        for(String s: num){
            ans += s;
        }

        return ans;
    }
}
