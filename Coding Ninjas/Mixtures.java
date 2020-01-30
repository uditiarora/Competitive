public class solution {
    public int solve(int n,int colors[]){
        //write your code here
      
      int mix[][] = new int[n+1][n+1];
      int smoke[][] = new int[n+1][n+1];
      for(int i=0;i<n;i++){
        mix[i+1][i+1] = colors[i];
      }
      for(int l=2;l<=n;l++){
        for(int i=1;i<=n-l+1;i++){
          int j = l+i-1;
          smoke[i][j] = Integer.MAX_VALUE;
          for(int k=i;k<j;k++){
            int temp = smoke[i][k] + smoke[k+1][j] + mix[i][k] * mix[k+1][j];
            if(temp < smoke[i][j]){
              smoke[i][j] = temp;
              mix[i][j] = (mix[i][k] + mix[k+1][j])%100;
            }
          }
        }
      }
      return smoke[1][n];
    }
}
