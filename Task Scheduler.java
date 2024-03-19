class Solution {
    public int leastInterval(char[] tasks, int n) {
        int charCounter[] = new int[26];

        for(char c: tasks){
            charCounter[c - 'A']++;
        }

        Arrays.sort(charCounter);
        int batches = charCounter[25];
        int vacant = (batches - 1) * n;

        for(int i = 0; i < 25; i++){
            vacant -= Math.min(charCounter[i], (batches - 1));
        }

        if(vacant > 0)return tasks.length + vacant;
        else
            return tasks.length;

       

    }
}
