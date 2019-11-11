class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
         HashMap<Integer,List<Integer>> stopsMap = new HashMap();
        for(int i=0; i<routes.length; i++){
            for(int j=0; j<routes[i].length; j++){
                stopsMap.putIfAbsent(routes[i][j], new ArrayList());
                stopsMap.get(routes[i][j]).add(i);
            }
        }
        HashMap<Integer,Integer> dist = new HashMap();
        Queue<Integer> q = new LinkedList();
        HashSet<Integer> visitedBus = new HashSet();
        q.add(S);
        dist.put(S,0);
        while(!q.isEmpty()){
            int curStop = q.poll();
            if(curStop==T) return dist.get(curStop);
            List<Integer> buses = stopsMap.get(curStop);
            for(int bus : buses){
                if(visitedBus.contains(bus)) continue;
                for(int nextStop : routes[bus]){
                    if(!dist.containsKey(nextStop)){
                        dist.put(nextStop, dist.get(curStop)+1);
                        q.add(nextStop);
                    }                    
                }
                visitedBus.add(bus);
            }
        }
        return -1;
    }
}