class Solution {
    public int findCenter(int[][] edges) {
        // int counter[] = new int[edges.length + 2];
        // for(int i = 0; i < edges.length; i ++){
        //    counter[edges[i][0]] ++;
        //    counter[edges[i][1]] ++;

        //    if(counter[edges[i][0]] == edges.length)return edges[i][0];
        //    if(counter[edges[i][1]] == edges.length)return edges[i][1];
        // }

        // return -1;

        int edge1[] = edges[0];
        int edge2[] = edges[1];

        if(edge1[0] == edge2[0] || edge1[0] == edge2[1])return edge1[0];
        if(edge1[1] == edge2[0] || edge1[1] == edge2[1])return edge1[1];

        return -1;
    }
}
