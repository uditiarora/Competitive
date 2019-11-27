public class PalindromeSubstrings {

	public static int countPalindromeSubstrings(String s) {
		// Write your code here
		int res=0;
      int n=s.length();
      for(int i=0;i<n;i++){
        int left=i-1;
        int right=i+1;
        while(left>=0 && right<n){
          if(s.charAt(left)==s.charAt(right)){
            res++;
            left--;
            right++;
          }
          else{
            break;
          }
        }
        if(i<n-1 && s.charAt(i)==s.charAt(i+1)){
          left=i-1;
          right=i+2;
          res++;
          while(left>=0 && right<n){
              if(s.charAt(left)==s.charAt(right)){
            res++;
            left--;
            right++;
          }
          else{
            break;
          }
          }
        }
      }
      return res+n;
	}
}
