
public class solution {
	
 // static long count = 0;
  
	public static long solve(int[] arr,int n){
		
		//Write your code here.      return count;
      return util(arr,0,n-1);
	}
	
  	public static long merge(int arr[],int low,int mid,int high){
      int temp[] = new int[high-low+1];
      int i=low,j=mid+1,k=0;
      long count=0;
     while(i<=mid && j<=high){
      if(arr[i]<=arr[j]){
        temp[k++] = arr[i++];
      }
       
       else{
         temp[k++] = arr[j++];
         count+= (mid+1-i);
       }
     }
      while(i<=mid){
        temp[k++] = arr[i++];
        
      }
      
      while(j<=high){
        temp[k++] = arr[j++];
      }
      i=low;
      for(k=0;k<temp.length;k++){
        arr[i++] = temp[k];
      }
      return count;
    }
  
  	public static long util(int arr[],int low,int high){
      if(low>=high){
        return 0;
      }
      int mid = (low+high)/2;
      return util(arr,low,mid)+
      util(arr,mid+1,high)+
      merge(arr,low,mid,high);
      
      
    }
  
  
  
}
