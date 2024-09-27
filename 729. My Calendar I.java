class MyCalendar {

     class Pair{
        int start;
        int end;

        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    class MyComparator implements Comparator<Pair>{
        public int compare(Pair p1, Pair p2){
            return p1.start - p2.start;
        }
    }

    TreeSet<Pair> times;   

    public MyCalendar() {
        times = new TreeSet(new MyComparator());
       
    }
    
    public boolean book(int start, int end) {
        Pair l = times.floor(new Pair(start, end));
        Pair h = times.ceiling(new Pair(start, end));

        if(l == null && h == null){           
            times.add(new Pair(start, end));
            return true;           
        }

        if(l == null && h != null){
            if(h.start >= end){
                times.add(new Pair(start, end));
                return true;
            }
            else return false;
        }

        if(l != null && h == null){
            if(l.end <= start){
                times.add(new Pair(start, end));
                return true;
            }
            else return false;
        }

          

        if(l != null && h != null){
            if((l.end <= start && h.start >= end)){
                times.add(new Pair(start, end));
                return true;
            }
            else{
                return false;
            }
         }


         return false;
    }   
}

       

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
