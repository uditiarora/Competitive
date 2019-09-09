class Solution {
    public int reachNumber(int target) {
        
        target = Math.abs(target);
        int i = 0;
        while(target>0){
            target -= ++i;
            
        }
        if(target%2 == 0){
            return i;
        }
        
        return (i + 1 + i%2);
    }
}