// Task: Given an array of integers arr, replace each element with its rank.
// The rank represents how large the element is. The rank has the following rules:
//     Rank is an integer starting from 1.
//     The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
//     Rank should be as small as possible.


// Constraint: 
//     0 <= arr.length <= 105
//     -109 <= arr[i] <= 109

// Approach: Use sorting on the copy of the given array with taking 2d array with index and val. Shorter code to implement using lambda fucntion.
// Make a custom class like pair, Triple and implement comparator for it. [Solved previously].


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
    //     int len = arr.length;

    //     if(len == 0)return new int[]{};

    //     Triple arrCopy[] = new Triple[len];

    //     for(int i = 0; i < len; i ++){
    //         arrCopy[i] = new Triple(arr[i], i);
    //     }

    //     Arrays.sort(arrCopy, new MyComparator());

    //     int rankList[] = new int[arr.length];

    //     int rankCurr = 1;
        
    //     arrCopy[0].rank = rankCurr;
    //     rankList[arrCopy[0].oldIndex] = rankCurr;

    //     for(int i = 1; i < len; i ++){
    //         if(arrCopy[i].num == arrCopy[i - 1].num){
    //             arrCopy[i].rank = rankCurr;
    //             rankList[arrCopy[i].oldIndex] = rankCurr;
    //         }
    //         else{
    //             arrCopy[i].rank = ++ rankCurr;
    //             rankList[arrCopy[i].oldIndex] = rankCurr;
    //         }
    //     }

    // return rankList;

        int len = arr.length;
        int arrWithIndex[][] = new int[len][2];
        

        for(int i = 0; i < len; i ++){
            arrWithIndex[i] = new int[]{arr[i], i}; 
        }


        Arrays.sort(arrWithIndex, (x, y) ->{
            if(x[0] == y[0]){
                return Integer.compare(x[0], y[0]);
            }

            return Integer.compare(x[0], y[0]);
        });

        int ans[] = new int[len];

        int rank = 1;

        if(len == 0)return new int[]{};
        
        ans[arrWithIndex[0][1]] = 1;
        int val = arrWithIndex[0][0];

        for(int i = 1; i < len; i ++){

            if(arrWithIndex[i][0] == val){
                ans[arrWithIndex[i][1]] = rank;
            }
            else{
                ++ rank;
                ans[arrWithIndex[i][1]] = rank;
            }

            val = arrWithIndex[i][0];
        }

        return ans;
    }
}

