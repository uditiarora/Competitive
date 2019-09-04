class Solution {
    public boolean canFinish(int n, int[][] pre) {
        int in[] = new int[n];
        Queue<Integer> q = new LinkedList<Integer>();
        HashMap<Integer,ArrayList<Integer>> m =new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            m.put(i,new ArrayList<Integer>());
        }
        for(int i=0;i<pre.length;i++){
            //System.out.println(pre[i][0] + " "+pre[i][1]);
            in[pre[i][1]]++;
            ArrayList<Integer> temp = m.get(pre[i][0]);
            temp.add(pre[i][1]);
            //System.out.println(i+ " "+temp);
            m.put(pre[i][0],temp);
            
        }
        for(int i=0;i<n;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int x = q.poll();
            ArrayList<Integer> temp = m.get(x);
            //System.out.println(x);
            for(int i=0;i<temp.size();i++){
                int temp2 = temp.get(i);
                
                in[temp2]--;
                if(in[temp2]==0){
                    q.add(temp2);
                }
            }
            count++;
        }
       // System.out.println(count);
        if(count==n){
            return true;
        }
        return false;
    }
}