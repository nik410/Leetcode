class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        // int cirSand = 0, sqrSand = 0;
        // int ind1 = 0, ind2 = 0;
        // int notAbleToEat = 0;
        // while(true){
            
        //     if(students[ind1] == -1)ind1 = (ind1 + 1) % students.length;
        //     if(students[ind1] == sandwiches[ind2]){
        //         students[ind1] = -1;
        //         ind1 = (ind1 + 1) % students.length;
                
        //         ind2= (ind2 + 1) % sandwiches.length;

        //         notAbleToEat = 0;
        //     }
        //     else {
        //         ind1 = (ind1 + 1) % students.length;
        //         notAbleToEat++;
        //     }

        //     if(notAbleToEat > 103)break;
        // }

        // int ans = 0;

        // for(int i : students){
        //     if(i != -1)ans++;
        // }
        
        // return ans;

        int cSandDemand = 0, sSandDemand = 0;

        for(int i: students){
            if(i == 1)sSandDemand++;
            else{
                cSandDemand++;
            }
        }

        for(int i : sandwiches){
            if(i == 0){
                if(cSandDemand > 0){
                    cSandDemand--;
                }
                else{
                    break;
                }
            }
            if(i == 1){
                if(sSandDemand > 0){
                    sSandDemand--;
                }
                else{
                    break;
                }
            }
        }


        return cSandDemand + sSandDemand;

    }
}
