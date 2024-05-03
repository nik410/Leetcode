class Solution {
    public int compareVersion(String version1, String version2) {
        int l = 0, r = 0;

        ArrayList<Integer> v1 = new ArrayList();
        ArrayList<Integer> v2 = new ArrayList();
        String num = "";
        for(char c: version1.toCharArray()){
            if(c =='.'){
                int n = Integer.parseInt(num);
                v1.add(n);
                num = "";
            }
            else{
                num += c + "";
            }
        }

        int n = Integer.parseInt(num);
        v1.add(n);

        num = "";
        for(char c: version2.toCharArray()){
            if(c =='.'){
                 n = Integer.parseInt(num);
                v2.add(n);
                num = "";
            }
            else{
                num += c + "";
            }
        }
        n = Integer.parseInt(num);
        v2.add(n);

        
        if(v1.size() > v2.size()){
            while(v2.size() != v1.size()){
                v2.add(0);
            }
        }

         if(v1.size() < v2.size()){
            while(v2.size() != v1.size()){
                v1.add(0);
            }
        }


        for(int i = 0; i < v1.size(); i++){
            if(v1.get(i) > v2.get(i))return 1;
            else if(v1.get(i) < v2.get(i))return -1;
        }


        return 0;

    }
}
