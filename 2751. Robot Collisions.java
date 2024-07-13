class Solution {

    class Trip{
        int pos;
        int health;
        char direction;
        int currIndex;
        Trip(int pos, int health, char direction, int currIndex){
            this.pos = pos;
            this.health = health;
            this.direction = direction;
            this.currIndex = currIndex;
        }
    }

    class MyComparator implements Comparator<Trip>{
        public int compare(Trip t1, Trip t2){
            return t1.pos - t2.pos;
        }
    }

    class MyComparator1 implements Comparator<Trip>{
        public int compare(Trip t1, Trip t2){
            return t1.currIndex - t2.currIndex;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Trip arr[] = new Trip[n];
        for(int i = 0; i < n; i ++){
           arr[i] = new Trip(positions[i], healths[i], directions.charAt(i), i);
        }

        Arrays.sort(arr, new MyComparator());

       
        Stack<Trip> st = new Stack();

        List<Integer> ans = new ArrayList();

        for(int i = 0; i < n; i ++){
            if(arr[i].direction == 'L'){                
                int currHealth = arr[i].health;               
                   
                while(!st.isEmpty() && currHealth > 0){
                    if(st.peek().health == currHealth){                      
                        healths[st.peek().currIndex] = 0;
                        st.pop();
                        
                        healths[arr[i].currIndex]  = 0;
                        currHealth = 0;                                             
                        break;
                    }
                    else if(st.peek().health < currHealth){
                        
                        currHealth --;
                        healths[arr[i].currIndex]  --;
                        healths[st.pop().currIndex] = 0;              
                        
                    }
                    else if(st.peek().health > currHealth){
                        Trip temp = st.pop();
                        healths[temp.currIndex] --;
                        st.push(new Trip(temp.pos, temp.health - 1, 'R', temp.currIndex));
                        // arr[st.peek().currIndex].health = 0;
                       
                        currHealth = 0;
                         healths[arr[i].currIndex]  = 0;
                        break;
                    }
                }              
            }
            else{
                st.push(arr[i]);
            }
            // if(st.size() > 0)
            // System.out.println(st.peek().health +" :health " +  i +" index");

        }

       
   
      for(int i = 0; i < n; i ++){
        if(healths[i] > 0){           
            ans.add(healths[i]);
            }
          
        }

        return ans;
    }
}
