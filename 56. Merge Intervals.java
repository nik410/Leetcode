class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        List< List< Integer > > ans = new ArrayList();
        int start = arr[0][0];
        int end = arr[0][1];
        for(int i = 1; i < arr.length; i++){
            if(arr[i][0] <= end){
                end = Math.max(end, arr[i][1]);
            }
            else{
                List<Integer> al = new ArrayList();
                al.add(start);
                al.add(end);

                ans.add(al);

                start = arr[i][0];
                end = arr[i][1];
            }
        }

        List<Integer> al = new ArrayList();
        al.add(start);
        al.add(end);
        ans.add(al);
        
        int ansArray[][] = new int[ans.size()][2];
        for(int i = 0; i < ans.size(); i++){
            ansArray[i][0] = ans.get(i).get(0); 

            ansArray[i][1] = ans.get(i).get(1); 
        }
        
        return ansArray;
    }
}
