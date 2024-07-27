class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
                
        int adj[][] = new int[26][26];

        for(int i = 0; i < 26; i ++){
            Arrays.fill(adj[i], Integer.MAX_VALUE);
            adj[i][i] = 0;
        }

        for(int i = 0; i < original.length; i ++){
            char u = original[i];
            char v = changed[i];
            adj[u - 'a'][v - 'a'] = Math.min(adj[u -'a'][v - 'a'], cost[i]);
        }

        for(int i = 0; i < 26; i ++){
            for(int j = 0; j < 26; j ++){
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }

        for(int k = 0; k < 26; k ++){
            for(int i = 0; i < 26; i ++){
                for(int j = 0; j < 26; j ++){
                    if(adj[i][k] < Integer.MAX_VALUE && adj[k][j] < Integer.MAX_VALUE)
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }

        long ans = 0;

        for(int i = 0; i < source.length(); i ++){
            char s = source.charAt(i);
            char d = target.charAt(i);
            if(adj[s - 'a'][d - 'a'] == Integer.MAX_VALUE)return -1;             
            ans += adj[s - 'a'][d - 'a'];           
        }

        return ans;
    }
}

