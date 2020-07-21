class Solution {
    public String arrangeWords(String text) {
        text = text.toLowerCase();
        HashMap<Integer, String> m = new HashMap<Integer, String>();
        String[] arr = text.split(" ");
        int temp=0;
        for(int i=0;i<arr.length;i++){
            temp = arr[i].length();
            if(m.containsKey(temp)){
                m.put(temp, m.get(temp)+" "+arr[i]);
            }
            else{
                m.put(temp, arr[i]);
            }
        }
        
        ArrayList<Integer> k = new ArrayList<Integer>(m.keySet());
        Collections.sort(k);
        int n = k.size();
        String ans = "";
        for(int i=0;i<n;i++){
            ans += m.get(k.get(i)) + " ";
        }
        String s = "" + (char)(ans.charAt(0) + 'A' - 'a');
        return s + ans.substring(1,ans.length() -1);
    }
}