class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> q = new LinkedList();

        Arrays.sort(deck);

        for(int i = 0; i < deck.length; i++){
            q.offer(i);
        }

        int ans[] = new int[deck.length];
        int point = 0;
        for(int i = 0; i < deck.length; i++){
            ans[q.peek()] = deck[point++];
            q.poll();
            if(q.peek() != null){
            int temp = q.poll();
            q.offer(temp);}
        }

        return ans;

    }
}
