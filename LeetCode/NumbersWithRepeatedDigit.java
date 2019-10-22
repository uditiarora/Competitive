class Solution {
    public int numDupDigitsAtMostN(int N) {
        int ans = 0;

        String num = Integer.toString(N);
       
        int[] A = new int[num.length()];
        for(int i = 0;i<A.length; i++){
            A[i] = num.charAt(i)-'0';
        }
       
        int[] cnt = new int[A.length];
        boolean[] used = new boolean[10];
        used[A[0]] = true;
        cnt[0] = A[0]-1;
        
        int rpt = A.length;
        
        for(int i=1;i<A.length; i++){
            for(int j = 0;j<A[i];j++){
                if(!used[j]) cnt[i]++;
            }
            if(used[A[i]]){
                rpt=i;
                break;
            }
            used[A[i]] = true;
        }
        
        
        for(int i = 0;i<rpt; i++){
            int c = cnt[i];
            c*=perm(9-i,A.length-i-1);
            ans+=c;
        }
        if(rpt!=A.length) ans+= cnt[rpt]*perm(9-rpt, A.length-rpt-1);
        
        for(int i = 1;i<A.length;i++){
            ans+= 9*perm(9,A.length-i-1);
        }
        if(rpt==A.length) ans++;
        return N-ans;
    }
    
    public int perm(int n, int k){
        int a= 1;
        for(int i = 0;i<k;i++){
            a*=(n-i);
        }
        return a;
    }
    
}