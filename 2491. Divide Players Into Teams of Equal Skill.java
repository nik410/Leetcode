class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int len = skill.length;
        long skillReq = skill[0] + skill[len - 1];

        long prod = (long)skill[0] * skill[len - 1];

        for(int i = 1; i < len/2; i ++ ){
            if(skill[i] +  skill[len - 1 - i] !=  skillReq){
                return -1;
            }
            else{
                prod += (long)skill[i] * skill[len - 1 - i];
            }
        }

        return prod;


    }
}
