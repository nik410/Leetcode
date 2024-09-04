class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> obs = new HashSet();

        for(int i[]: obstacles){
            String s = i[0] + "_" + i[1];
            obs.add(s);
        }

        // System.out.println(obs);

        int x = 0;
        int y = 0;
        int eDis = 0;

        int direc[][]= {{0, 1}};

        for(int i = 0; i < commands.length; i ++){
            if(commands[i] == -2){
                int newD[][] = {
                    {direc[0][1] * -1, direc[0][0]}
                    };

                direc = newD;
            }
            else if(commands[i] == -1){
               int newD[][] = {
                    {direc[0][1], -1 * direc[0][0]}
                    };
                direc = newD;
        }
        else{
            for(int j = 0; j < commands[i]; j ++){
                int newX = x + direc[0][0];
                int newY = y + direc[0][1];

                String s = newX + "_" + newY;

                if(obs.contains(s)){
                    break;
                }
                else{
                    x = newX;
                    y = newY;
                }
            }
        }

        eDis = Math.max(eDis, (x * x + y * y));
    }


    return eDis;
}
}
