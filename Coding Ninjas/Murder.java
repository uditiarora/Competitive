import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
		Scanner s = new Scanner(System.in);
      int t = s.nextInt();
      while(t-- != 0){
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
          arr[i] = s.nextInt();
        }
        
        System.out.println(util(arr,0,n-1));
        
        
      }
	}
  public static long merge(int arr[],int low,int mid,int high){
    long ans=0,sum=0;
    int i=low,j=mid+1,k=0;
    int temp[] = new int[high-low+1];
    while(i<=mid && j<=high){
      if(arr[i]<arr[j]){
        temp[k++] = arr[i];
        ans += (arr[i] * (high-j+1));
        i++;
        
      }
      else if(arr[i]>=arr[j]){
        temp[k++] = arr[j];
        j++;
      }
      
      
    }
    
    while(i<=mid){
      temp[k++] = arr[i++];
    }
    while(j<=high){
      temp[k++] = arr[j++];
    }
    k=0;
    for(int l = low;l<=high;l++){
      arr[l] = temp[k++];
    }
    return ans;
  }
  public static long util(int arr[],int low,int high){
    if(low>=high){
      return 0;
    }
    int mid = (low+high)/2;
    return util(arr,low,mid) + util(arr,mid+1,high) + merge(arr,low,mid,high);
    
    
  }
  

}