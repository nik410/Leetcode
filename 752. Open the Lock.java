class Solution {

    char turnRight(char c){
        return (c == '9' ? '0' : (char)(c + 1));
    }

    char turnLeft(char c){
        return (c == '0' ? '9' : (char)(c - 1));
    }

    ArrayList<String> nextOptions(String s){
        ArrayList<String> al = new ArrayList();
        for(int i = 0; i < 4; i ++){
            StringBuilder copy = new StringBuilder();
            copy.append(s);            
            copy.setCharAt(i,  (turnRight(s.charAt(i))));
            al.add(copy.toString());
            copy.setCharAt(i, (turnLeft(s.charAt(i))));
            al.add(copy.toString());
        }
        return al;
    }

    public int openLock(String[] deadends, String target) {
        HashSet<String> dead = new HashSet();
        for(String s: deadends)dead.add(s);
        HashMap<String, Boolean> hm = new HashMap();
        Queue<String> q = new LinkedList();
        q.offer("0000");
        hm.put("0000", true);
        int level = 0;
        while(!q.isEmpty()){
            int sz = q.size();;
            while(sz-- > 0){
            String s = q.peek();
            q.poll();

            if(s.equals(target))return level;

            if(dead.contains(s))continue;

            for(String ops: nextOptions(s)){
                if(!hm.containsKey(ops)){
                    q.offer(ops);
                    hm.put(ops, true);
                }
            }

            }
            level++;
        }


        return -1;



    }
}
