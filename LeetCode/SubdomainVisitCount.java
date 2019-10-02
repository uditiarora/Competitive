class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
         List<String> output=new ArrayList();
    HashMap<String,Integer> map=new HashMap();
    for(String a:cpdomains){
        String[] r=a.split("\\s+|\\.");
        String s=r[r.length-1];
        for(int i=r.length-1;i>=1;i--){
            map.put(s,map.getOrDefault(s,0)+Integer.parseInt(r[0]));
          s=r[i-1]+"."+s;
        }
    }
    for(Map.Entry e:map.entrySet()){
      output.add((Integer)e.getValue()+" "+(String)e.getKey());
    }
    return output;
    }
}