class Solution {

    public void recur(int n, StringBuilder stb, ArrayList<String> al){
        
        if(stb.length() == n){
            al.add(stb.toString());
            return;
        }

        for(int i = 0; i < 3; i ++){
            char curr = (char)(i + 'a');

            if(stb.length() > 0  && stb.charAt(stb.length() - 1) == curr){
                continue;
            }

            stb.append(curr);
            recur(n, stb, al);
            stb.deleteCharAt(stb.length() - 1);
        }
    }

    public String getHappyString(int n, int k) {
        StringBuilder stb = new StringBuilder();

        // We can use arraylist, treeset, hashset for storage of the strings 
        // As we know how many total strings are possible
        // given n -> the total strings possible is 3 *(2) ^ (n - 1)  ... ..

        // We can use array in this case
        // Or to reduce space usage we can altogether not store the strings and only show the k position
        // string

        ArrayList<String> al = new ArrayList();

        // recur(n, stb, al);

        // System.out.println(al);

        // // Iterator<String> it = al.iterator();
        // // int count = 0;
        // // while(it.hasNext()){
        // //     count ++;
        // //     String s = it.next();
        // //     if(count == k)return s;
        // // }

        // if(al.size() >= k)return al.get(k - 1);

       // Always use array when trying to get value from a void function as there can
       // bew issues with the reference and scope of primitive types 
        String[] res = new String[1];
        Arrays.fill(res, "");
        rec(n, k, stb, res);

        return res[0];
    }

    
    int count = 0;

    public void rec(int n, int k,StringBuilder stb, String ans[]){
        if(stb.length() == n){
            count ++;
            
            if(count == k)ans[0] =  stb.toString();
            return;
        }

        for(int i = 0; i < 3; i ++){
            char curr = (char)(i + 'a');
            if(stb.length() > 0 && stb.charAt(stb.length() - 1) == curr){
                continue;
            }

            stb.append(curr);
            rec(n, k, stb, ans);
            stb.deleteCharAt(stb.length() - 1);
        }
    } 
}
