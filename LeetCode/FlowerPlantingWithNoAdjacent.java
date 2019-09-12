class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        HashMap<Integer, ArrayList<Integer>> m = new HashMap<Integer, ArrayList<Integer>>();
        for(int i=1;i<=N;i++){
            m.put(i, new ArrayList<Integer>());
            
        }
        
        for(int i=0;i<paths.length;i++){
            int a = paths[i][0];
            int b = paths[i][1];
            ArrayList<Integer> temp = m.get(a);
            ArrayList<Integer> temp2 = m.get(b);
            temp.add(b);
            temp2.add(a);
            m.put(a,temp);
            m.put(b,temp2);
        }
        
        int ans[] = new int[N];
        for(int i=1;i<=N;i++){
            ArrayList<Integer> temp = m.get(i);
            int vis[] = new int[5];
            for(int j=0;j<temp.size();j++){
                vis[ans[temp.get(j)-1]]++;
            }
            for(int k=1;k<=4;k++){
                if(vis[k]==0){
                    ans[i-1] = k;
                    break;
                }
            }
        }
        return ans;
        
    }
}