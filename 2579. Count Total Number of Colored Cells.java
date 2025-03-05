class Solution {
    public long coloredCells(int n) {
        // Math Problem try to hand solve first few solvable testcases 
        // Converting a int value to long necessary to prevent overflow as int * int returns a int value
        // And if that value exceeds integer range this can result in wrong answer
        long subParts = ((long)(n - 1) * (n)) / 2;
        long ans = (long)4 * subParts + 1;
        return ans;
    }
}
