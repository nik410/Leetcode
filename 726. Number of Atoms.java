class Solution {
    class Pair{
        String ele;
        int freq;

        Pair(String ele, int freq){
            this.ele = ele;
            this.freq = freq;
        }
    }
    public String countOfAtoms(String formula) {
        Stack<Pair> st = new Stack();

        for(int i = 0; i < formula.length(); i ++){
            char c = formula.charAt(i);

            if(Character.isUpperCase(c)){
                String nameEle = c + "";
                String freq = "";
                int j = 0;
                for(j = i + 1; j < formula.length(); j ++){
                    char ch = formula.charAt(j);
                    if(Character.isLowerCase(ch)){
                        nameEle += ch +"";
                    }
                    else{
                        break;
                    }
                }
                int k = 0;
                for(k = j; k < formula.length(); k ++){
                    char ch = formula.charAt(k);
                    if(Character.isDigit(ch)){
                        freq += ch +"";
                    }
                    else{
                        break;
                    }
                }
                int freqInNum = 1;
                if(freq != "")
                freqInNum = Integer.parseInt(freq);

                st.push(new Pair(nameEle, freqInNum));
                i = k - 1; 
            }
            else if(c == '('){
                st.push(new Pair("(", -1));
            }
            else if(c == ')'){
                String freq = "";
                  for(int k = i + 1; k < formula.length(); k ++){
                    char ch = formula.charAt(k);
                    if(Character.isDigit(ch)){
                        freq += ch +"";
                    }
                    else{
                        break;
                    }
                }
                int freqInNum = 1;
                if(freq != "")
                freqInNum = Integer.parseInt(freq);

                ArrayList<Pair> al = new ArrayList();

                Pair openB = new Pair("(", -1);

                while(!st.peek().ele.equals("(")){
                    Pair p =  st.peek();
                    al.add(new Pair(p.ele, p.freq * freqInNum));
                    st.pop();
                }
                st.pop();

                for(Pair p1: al){
                    st.push(p1);
                }


            }

        }

        String ans = "";
        
        TreeMap<String, Integer> tm = new TreeMap();

        while(!st.isEmpty()){
            Pair temp = st.pop();
            if(tm.containsKey(temp.ele)){
                tm.put(temp.ele, tm.get(temp.ele) + temp.freq);
            }
            else
            tm.put(temp.ele, temp.freq);
        }

        for(String s: tm.keySet()){
            ans += s +"";
            if((tm.get(s)) != 1)
            ans += Integer.toString(tm.get(s)) +"";
        }

        return ans;
    }
}
