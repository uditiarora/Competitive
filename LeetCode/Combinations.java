class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        util(1,k,new ArrayList<Integer>(),n);
        return ans;
    }
    public void util(int i, int k,List<Integer> x,int n){
        if(k==0){
            ans.add(x);
            return;
        }
        if(i>n){
            return;
        }
        
        for(int j=i;j<=n;j++){
            List<Integer> temp = new ArrayList<Integer>(x);
            temp.add(j);
            util(j+1,k-1,temp,n);
        }
        //util(i+1,k,x,n);
    }
}