class Solution {

    class Triple{
        int num;
        int oldIndex;
        int rank = -1;

        Triple(int num, int oldIndex){
            this.num = num;
            this.oldIndex = oldIndex;
        }
    }

    class MyComparator implements Comparator<Triple>{
        public int compare(Triple t1, Triple t2){
            return t1.num - t2.num;
        }
    }

    public int[] arrayRankTransform(int[] arr) {
        
        int len = arr.length;

        if(len == 0)return new int[]{};

        Triple arrCopy[] = new Triple[len];

        for(int i = 0; i < len; i ++){
            arrCopy[i] = new Triple(arr[i], i);
        }

        Arrays.sort(arrCopy, new MyComparator());

        int rankList[] = new int[arr.length];

        int rankCurr = 1;
        
        arrCopy[0].rank = rankCurr;
        rankList[arrCopy[0].oldIndex] = rankCurr;

        for(int i = 1; i < len; i ++){
            if(arrCopy[i].num == arrCopy[i - 1].num){
                arrCopy[i].rank = rankCurr;
                rankList[arrCopy[i].oldIndex] = rankCurr;
            }
            else{
                arrCopy[i].rank = ++ rankCurr;
                rankList[arrCopy[i].oldIndex] = rankCurr;
            }
        }

    return rankList;
    
    }
}
