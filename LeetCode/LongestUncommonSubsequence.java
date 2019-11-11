
class Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        });
        for(int i=0;i<strs.length;i++){
            int j=0;
            for(;j<strs.length;j++){
                if(i==j){continue;}
                if(isCommon(strs[i],strs[j])){
                    break;
                }
            }
            if(j==strs.length){
                return strs[i].length();
            }
        }
        return -1;
    }
    public boolean isCommon(String dst,String src){
        if(dst.length()>src.length()){
            return false;
        }
        if(dst.length()==src.length()){
            return dst.equals(src);
        }
        int index=-1;
        for(int i=0;i<dst.length();i++){
            index=src.indexOf(dst.charAt(i),index+1);
            if(index==-1){
                return false;
            }
        }
        return true;
    }
}