class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for(int i=1;i<=(n-1)/2;i++){
            if(num.charAt(0) == '0' && i>=2){
                return false;
            }
            for(int j=i+1;j-i<=n-j && i<=n-j;j++){
                if(num.charAt(i) == '0' && j-i >= 2){
                    break;
                }
                long a = Long.parseLong("0"+num.substring(0,i));
                long b = Long.parseLong("0"+num.substring(i,j));
                if(util(a,b,num.substring(j,n))){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean util(long a, long b, String s){
        if(s.length()==0){
            return true;
        }
        long c = a + b;
        String cc = Long.toString(c);
        int i = 0;
        if(s.length()<cc.length()){
            return false;
        }
        while(i<cc.length()){
            if(s.charAt(i) != cc.charAt(i)){
                return false;
            }
            i++;
        }
        return util(b,c,s.substring(i));
    }
    
}