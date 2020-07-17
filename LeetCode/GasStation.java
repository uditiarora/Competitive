class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, totalGas = 0, currentGas = 0;
        
        for(int i = 0; i < gas.length; i++){
            currentGas += gas[i] - cost[i];
            totalGas += gas[i] - cost[i];
            
            if(currentGas < 0){
                currentGas = 0;
                start = i + 1;
            }
        }
        return totalGas >= 0? start : -1;
    }
}