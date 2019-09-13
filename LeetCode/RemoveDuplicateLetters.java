class Solution {
    public String removeDuplicateLetters(String s) {
        int arr[] = new int[26];
        Stack<Character> st = new Stack<Character>();
        int a[] = new int[26];
        int n = s.length();
        for(int i=0;i<n;i++){
            arr[s.charAt(i)-'a']++;
        }
        String ans = "";
        for(int i=0;i<n;i++){
            char temp = s.charAt(i);
            
            arr[temp-'a']--;
            while(a[temp-'a'] ==0 && !st.isEmpty() && st.peek() > temp && arr[st.peek()-'a']>=1){
                //System.out.println(st.peek());
                a[st.peek()-'a']=0;
                st.pop();
            }
            //System.out.println(s.charAt(i)+" "+arr[temp-'a']);
            if(a[temp-'a']==0){
                a[temp-'a']=1;
                st.push(temp);
            }
            
        }
        while(!st.isEmpty()){
            ans = st.pop() + ans;
        }
        return ans;
        
    }
}