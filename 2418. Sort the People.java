class Solution {
    class People{
        String name;
        int height;
        public People(String name, int height){
            this.name = name;
            this.height = height;
        }
    }

    class MyComparator implements Comparator<People> {
        public int compare(People p1, People p2){
            return p2.height - p1.height;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        People arr[] = new People[names.length];

        for(int i = 0; i < arr.length; i ++){
            People p = new People(names[i], heights[i]);
            arr[i] = p;
        }

        Arrays.sort(arr, new MyComparator());

        String ans[] = new String[arr.length];

        for(int i = 0; i < arr.length; i ++){
            ans[i] = arr[i].name;
        }

        return ans;
    }
}
