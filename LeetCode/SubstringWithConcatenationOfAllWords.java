class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<Integer>();
        int n = words.length;
        if(n==0){
            return ans;
        }
        int m = words[0].length();
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0;i<n;i++){
            map.put(words[i],map.getOrDefault(words[i],0) + 1);
        }
        for(int i=0;i<s.length()-n*m + 1;i++){
            String temp = s.substring(i,i+m);
            if(map.containsKey(temp)){
                HashMap<String,Integer> map2 = new HashMap<String,Integer>();
                for(int j=i;j<i+n*m;j+=m){
                    temp = s.substring(j,j+m);
                    map2.put(temp, map2.getOrDefault(temp,0)+1);
                }
                Set<String> set = map2.keySet();
                boolean flag = true;
                for(String str : set){
                    if(map2.get(str) != map.getOrDefault(str,0)){
                        flag = false;
                        break;
                    }
                }
                if(flag==true){
                    ans.add(i);
                }
            }
        }
        return ans;
    }
}