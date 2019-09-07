class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        HashMap<String,Boolean > m = new HashMap<String,Boolean>();
        for(int i=0;i<dict.size();i++){
            m.put(dict.get(i),true);
        }
        String output = "";
        String arr[] = sentence.split(" ");
        for(int i=0;i<arr.length;i++){
            String temp = arr[i];
            for(int j=0;j<temp.length();j++){
                
                if(m.containsKey(temp.substring(0,j))){
                    output += (temp.substring(0,j)+" ");
                    break;
                }
                if(j == temp.length()-1){
                    output += (temp+" ");
                }
            }
        }
        return output.substring(0,output.length()-1);
        
    }
}